package com.we.sdk.memsap.service;

import com.we.sdk.memsap.base.vo.Page;
import com.we.sdk.memsap.base.vo.SearchVo;
import com.we.sdk.memsap.bean.Phone;

import java.util.List;

/**
 * @author sudk
 * @date 2019-01-19 15:31:09
 */
public interface PhoneService {

    /**
     * 新增Phone
     *
     * @param phone 新增的对象
     * @return 返回成功的对象id
     */
    Integer save(Phone phone);

    /**
     * 根据id删除Phone
     *
     * @param id id
     * @return 删除成功条数
     */
    Integer delete(Integer id);

    /**
     * 修改Phone
     *
     * @param phone 修改的对象
     * @return 修改成功条数
     */
    Integer update(Phone phone);

    /**
     * 根据id查询Phone
     *
     * @param id id
     * @return Phone对象
     */
    Phone getPhoneById(Integer id);

    /**
     * 根据条件查询Phone
     *
     * @param searchVo 封装的搜索对象
     * @param page     分页参数
     * @return List
     */
    Page getPhoneListByConditions(SearchVo searchVo, Page page);

    /**
     * 分页查询Phone数量
     *
     * @param searchVo 封装的搜索对象
     * @return 数量
     */
    Integer getPhoneListCount(SearchVo searchVo);

    List<Phone> getPhoneList();
}

