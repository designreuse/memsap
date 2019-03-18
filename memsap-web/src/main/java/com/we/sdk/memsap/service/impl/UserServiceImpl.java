package com.we.sdk.memsap.service.impl;

import com.we.sdk.memsap.base.result.RestResult;
import com.we.sdk.memsap.base.vo.Page;
import com.we.sdk.memsap.base.vo.SearchVo;
import com.we.sdk.memsap.bean.User;
import com.we.sdk.memsap.feign.UserFeignClient;
import com.we.sdk.memsap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserFeignClient userFeignClient;


    @Override
    public RestResult<Integer> save(User user) {
//        ItdragonUtils.entryptPassword(user);
        return userFeignClient.save(user);
    }

    @Override
    public Integer delete(String phoneNumber) {
        return userFeignClient.delete(phoneNumber).getData();
    }

    @Override
    public RestResult<Integer> update(User user) {
//        ItdragonUtils.entryptPassword(user);
        return userFeignClient.update(user);
    }

    @Override
    public User getUserByPhoneNumber(String phoneNumber) {
        return userFeignClient.getUserByPhoneNumber(phoneNumber).getData();
    }

    @Override
    public Page<User> getUserListByCondition(SearchVo searchVo, Page page) {
        searchVo.setPage(page);
        return userFeignClient.getUserListByCondition(searchVo).getData();
    }

    @Override
    public List<User> getUserList() {
        return userFeignClient.getUserList().getData();
    }

    @Override
    public User checkUser(User user) {
        return userFeignClient.checkUser(user).getData();
    }

}
