package com.we.sdk.memsap.service;

import com.we.sdk.memsap.base.vo.Page;
import com.we.sdk.memsap.base.vo.SearchVo;
import com.we.sdk.memsap.bean.*;

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
     * @return 新增成功对象的ID
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

    List<Phone> getPhoneList();

    List<RepairPrice> getFaultRepairPriceByCondition(RepairPrice repairPrice);

    List<Fault> getFaultList();

    List<Repair> getRepairList();

    List<Brand> getBrandList();

    Integer batchEdit(List<RepairPrice> repairPriceList);


}

