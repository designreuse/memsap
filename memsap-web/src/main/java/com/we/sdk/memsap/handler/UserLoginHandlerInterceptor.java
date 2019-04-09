package com.we.sdk.memsap.handler;

import com.we.sdk.memsap.base.util.CookieUtils;
import com.we.sdk.memsap.bean.User;
import com.we.sdk.memsap.service.impl.SSOService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class UserLoginHandlerInterceptor implements HandlerInterceptor {

    public static final String COOKIE_NAME = "USER_TOKEN";

    @Autowired
    private SSOService ssoService;

    @Value("${administrator.name}")
    private String name;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String token = CookieUtils.getCookieValue(request, COOKIE_NAME);
        User user = this.ssoService.queryUserByToken(token).getData();
        if (StringUtils.isEmpty(token) || null == user || (!name.equals(user.getPhoneNumber()))) {
            // 跳转到登录页面，把用户请求的url作为参数传递给登录页面。
            response.sendRedirect("http://localhost:8084/memsap-web/user/toLogin?redirect=" + request.getRequestURL());
            // 返回false
            return false;
        }
        // 把用户信息放入Request
        request.getSession().setAttribute("user", new User(user.getUserName()));
        // 返回值决定handler是否执行。true：执行，false：不执行。
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                Exception ex) throws Exception {
    }

}