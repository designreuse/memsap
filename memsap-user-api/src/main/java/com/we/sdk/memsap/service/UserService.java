package com.we.sdk.memsap.service;


import com.we.sdk.memsap.base.vo.Page;
import com.we.sdk.memsap.base.vo.SearchVo;
import com.we.sdk.memsap.bean.User;

import java.util.List;

/**
 * @author SDK
 * @date 2019-02-23 17:21:24
 */
public interface UserService {

    Integer save(User user);

    Integer delete(String phoneNumber);

    Integer update(User user);

    User getUserByPhoneNumber(String phoneNumber);

    Page getUsersByCondition(SearchVo searchVo, Page<User> page);

    User checkUser(User user);

    List<User> getUsers();

}

