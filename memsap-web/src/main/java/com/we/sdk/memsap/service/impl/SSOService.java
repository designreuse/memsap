package com.we.sdk.memsap.service.impl;

import com.we.sdk.memsap.base.result.RestResult;
import com.we.sdk.memsap.base.result.RestResultGenerator;
import com.we.sdk.memsap.base.util.CookieUtils;
import com.we.sdk.memsap.base.util.JsonUtils;
import com.we.sdk.memsap.bean.User;
import com.we.sdk.memsap.feign.UserFeignClient;
import com.we.sdk.memsap.repository.JedisClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Service
@PropertySource(value = "classpath:redis.properties")
@RequiredArgsConstructor
public class SSOService {

    private final UserFeignClient userFeignClient;

    private final JedisClient jedisClient;


    @Value("${REDIS_USER_SESSION_KEY}")
    private String REDIS_USER_SESSION_KEY;

    @Value("${SSO_SESSION_EXPIRE}")
    private Integer SSO_SESSION_EXPIRE;

    @Value("${administrator.name}")
    private String name;

    @Value("${administrator.password}")
    private String password;

    public RestResult<String> userLogin(String phoneNumber, String password,
                                        HttpServletRequest request, HttpServletResponse response) {
        // 判断账号密码是否正确
        User user = userFeignClient.getUserByPhoneNumber(phoneNumber).getData();
        if ((user == null) | !password.equals(user.getPassword())) {
            return RestResultGenerator.createFailResult("账号名或密码错误");
        }
        // 生成token
        String token = UUID.randomUUID().toString();
        // 清空密码泄漏
        String userPassword = user.getPassword();
        user.setPassword(null);
        // 把用户信息写入 redis
        jedisClient.set(REDIS_USER_SESSION_KEY + ":" + token, JsonUtils.objectToJson(user));
        // user 已经是持久化对象，被保存在session缓存当中，若user又重新修改属性值，那么在提交事务时，此时 hibernate对象就会拿当前这个user对象和保存在session缓存中的user对象进行比较，如果两个对象相同，则不会发送update语句，否则会发出update语句。
        user.setPassword(userPassword);
        // 设置 session 的过期时间
        jedisClient.expire(REDIS_USER_SESSION_KEY + ":" + token, SSO_SESSION_EXPIRE);
        // 添加写 cookie 的逻辑，cookie 的有效期是关闭浏览器就失效。
        CookieUtils.setCookie(request, response, "USER_TOKEN", token);
        // 返回token
        if (name.equals(user.getUserName()) && password.equals(user.getPassword())) {
            return RestResultGenerator.createOkResult("root", token);
        }
        return RestResultGenerator.createOkResult(token);
    }

    public void logout(String token) {
        jedisClient.del(REDIS_USER_SESSION_KEY + ":" + token);
    }

    public RestResult<User> queryUserByToken(String token) {
        // 根据token从redis中查询用户信息
        String json = jedisClient.get(REDIS_USER_SESSION_KEY + ":" + token);
        // 判断是否为空
        if (StringUtils.isEmpty(json)) {
            return RestResultGenerator.createFailResult("此session已经过期");
        }
        // 更新过期时间
        jedisClient.expire(REDIS_USER_SESSION_KEY + ":" + token, SSO_SESSION_EXPIRE);
        // 返回用户信息
        return RestResultGenerator.createOkResult(JsonUtils.jsonToPojo(json, User.class));
    }
}