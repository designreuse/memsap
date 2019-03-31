package com.we.sdk.memsap.service.impl;

import com.we.sdk.memsap.base.vo.Page;
import com.we.sdk.memsap.base.vo.SearchVo;
import com.we.sdk.memsap.bean.User;
import com.we.sdk.memsap.dao.UserDao;
import com.we.sdk.memsap.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Override
    public Integer save(User user) {
        return userDao.save(user);
    }

    @Override
    public Integer delete(String phoneNumber) {
        return userDao.delete(phoneNumber);
    }

    @Override
    public Integer update(User user) {
        return userDao.update(user);
    }

    @Override
    public User getUserByPhoneNumber(String phoneNumber) {
        return userDao.getUserByPhoneNumber(phoneNumber);
    }

    @Override
    public Page getUsersByCondition(SearchVo searchVo, Page<User> page) {
        Integer count = userDao.getUsersCount(searchVo);
        page.setTotalCount(count);
        page.calculate();
        page.setData(userDao.getUsersByCondition(searchVo, page));
        return page;
    }

    @Override
    public User checkUser(User user) {
        return userDao.checkUser(user);
    }

    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }

}
