package com.we.sdk.memsap.dao;

import com.we.sdk.memsap.base.vo.Page;
import com.we.sdk.memsap.base.vo.SearchVo;
import com.we.sdk.memsap.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author SDK
 * @date 2019-02-23 17:21:24
 */
@Mapper
public interface UserDao {

    /**
     * 新增User
     *
     * @param user 新增的对象
     * @return 新增成功条数
     */
    Integer save(User user);

    /**
     * 根据phoneNumber删除User
     *
     * @param phoneNumber phoneNumber
     * @return 删除成功条数
     */
    Integer delete(@Param("phoneNumber") String phoneNumber);

    /**
     * 修改User
     *
     * @param user 修改的对象
     * @return 修改成功条数
     */
    Integer update(User user);

    /**
     * phoneNumber
     *
     * @param phoneNumber phoneNumber
     * @return User对象
     */
    User getUserByPhoneNumber(@Param("phoneNumber") String phoneNumber);

    /**
     * 分页查询User
     *
     * @param searchVo 封装的搜索对象
     * @return List
     */
    List<User> getUsersByCondition(@Param("searchVo") SearchVo searchVo, @Param("page") Page page);

    /**
     * 分页查询User数量
     *
     * @param searchVo 封装的搜索对象
     * @return 数量
     */
    Integer getUsersCount(@Param("searchVo") SearchVo searchVo);

    User checkUser(User user);

}
