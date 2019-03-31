package com.we.sdk.memsap.controller;

import com.we.sdk.memsap.base.result.RestResult;
import com.we.sdk.memsap.base.result.RestResultGenerator;
import com.we.sdk.memsap.base.util.BindingResultHandler;
import com.we.sdk.memsap.base.vo.Page;
import com.we.sdk.memsap.base.vo.SearchVo;
import com.we.sdk.memsap.bean.User;
import com.we.sdk.memsap.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author SDK
 * @date 2019-02-23 17:21:24
 */
@RestController
@Api(value = "User接口", description = "User接口")
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * 新增
     */
    @ApiOperation(value = "新增User", notes = "新增User")
    @PostMapping(value = "/save")
    public RestResult<Integer> save(@RequestBody @Valid User user, BindingResult bindingResult) {
        RestResult validResult = BindingResultHandler.bindingMessageHandle(bindingResult);
        if (validResult.getCode() != 0) {
            return validResult;
        }
        Integer result = userService.save(user);
        return RestResultGenerator.createOkResult(result);
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除User", notes = "删除User")
    @DeleteMapping(value = "/delete/{phoneNumber}")
    public RestResult<Integer> delete(@PathVariable String phoneNumber) {
        Integer result = userService.delete(phoneNumber);
        return RestResultGenerator.createOkResult(result);
    }

    /**
     * 修改
     */
    @ApiOperation(value = "修改User", notes = "修改User")
    @PostMapping(value = "/update")
    public RestResult<Integer> update(@RequestBody @Valid User user, BindingResult bindingResult) {
        RestResult validResult = BindingResultHandler.bindingMessageHandle(bindingResult);
        if (validResult.getCode() != 0) {
            return validResult;
        }
        Integer result = userService.update(user);
        return RestResultGenerator.createOkResult(result);
    }

    /**
     * 列表
     */
    @ApiOperation(value = "查询User列表", notes = "查询User列表")
    @PostMapping("/getUsersByCondition")
    public RestResult<Page<User>> getUsersByCondition(@RequestBody(required = false) SearchVo searchVo) {
        Page<User> UserList = userService.getUsersByCondition(searchVo, Page.initPage(searchVo.getPage()));
        return RestResultGenerator.createOkResult(UserList);
    }

    /**
     * 列表
     */
    @ApiOperation(value = "查询User列表", notes = "查询User列表")
    @GetMapping("/getUserList")
    public RestResult<List<User>> getUsers() {
        List<User> UserList = userService.getUsers();
        return RestResultGenerator.createOkResult(UserList);
    }

    /*
     * 根据id查询User
     */
    @ApiOperation(value = "根据phoneNumber查询User", notes = "根据phoneNumber查询User")
    @GetMapping(value = "/getUserByPhoneNumber/{phoneNumber}")
    public RestResult<User> getUserByPhoneNumber(@PathVariable("phoneNumber") String phoneNumber) {
        User user = userService.getUserByPhoneNumber(phoneNumber);
        return RestResultGenerator.createOkResult(user);
    }

    /*
     * 查询User是否存在
     */
    @ApiOperation(value = "查找用户是否存在", notes = "查找用户是否存在")
    @PostMapping(value = "/checkUser")
    public RestResult<User> checkUser(@RequestBody User user) {
        return RestResultGenerator.createOkResult(userService.checkUser(user));
    }

}
