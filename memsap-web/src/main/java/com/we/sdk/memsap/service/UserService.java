package com.we.sdk.memsap.service;


import com.we.sdk.memsap.base.result.RestResult;
import com.we.sdk.memsap.base.vo.Page;
import com.we.sdk.memsap.base.vo.SearchVo;
import com.we.sdk.memsap.bean.User;

import java.util.List;

/**
 * @author ${author}
 * @date 2019-02-23 17:21:24
 */
public interface UserService {

    RestResult<Integer>  save(User user);

    Integer delete(String phoneNumber);

    RestResult<Integer> update(User user);

    User getUserByPhoneNumber(String phoneNumber);

    Page<User> getUserListByCondition(SearchVo searchVo, Page page);

   List<User> getUserList();

    User checkUser(User user);
}

