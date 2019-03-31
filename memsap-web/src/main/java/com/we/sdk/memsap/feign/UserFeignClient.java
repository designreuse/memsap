package com.we.sdk.memsap.feign;

import com.we.sdk.memsap.base.result.RestResult;
import com.we.sdk.memsap.base.vo.Page;
import com.we.sdk.memsap.base.vo.SearchVo;
import com.we.sdk.memsap.bean.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "user", url = "http://localhost:8082")
@RequestMapping("/memsap-user-api")
public interface UserFeignClient {
    /*新增*/
    @PostMapping(value = "/user/save")
    RestResult<Integer> save(@RequestBody User user);

    /*删除*/
    @DeleteMapping(value = "/user/delete/{phoneNumber}")
    RestResult<Integer> delete(@PathVariable String phoneNumber);

    /*修改*/
    @PostMapping(value = "/user/update")
    RestResult<Integer> update(@RequestBody User user);

    /*条件查询列表*/
    @PostMapping(value = "/user/getUsersByCondition")
    RestResult<Page<User>> getUserListByCondition(@RequestBody SearchVo searchVo);

    /*条件查询列表*/
    @GetMapping(value = "/user/getUserList")
    RestResult<List<User>> getUserList();

    /*根据id获取User*/
    @GetMapping(value = "/user/getUserByPhoneNumber/{phoneNumber}")
    RestResult<User> getUserByPhoneNumber(@PathVariable("phoneNumber") String phoneNumber);

    /*根据id获取User*/
    @RequestMapping(value = "/user/checkUser")
    RestResult<User> checkUser(@RequestBody User user);
}
