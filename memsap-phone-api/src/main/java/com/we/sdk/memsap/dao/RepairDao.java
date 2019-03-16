package com.we.sdk.memsap.dao;

import com.we.sdk.memsap.bean.Repair;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * 
 * @author sudk
 * @date 2019-01-19 15:31:00
 */
@Mapper
public interface RepairDao {

    /**
    *  新增Repair
    * @param Repair 新增的对象
    * @return 新增成功条数
    */
    Integer save(Repair Repair);

    /**
     *  根据id删除Repair
     * @param id id
     * @return 删除成功条数
     */
    Integer delete(@Param("id") Integer id);

    /**
     *  修改Repair
     * @param Repair 修改的对象
     * @return 修改成功条数
     */
    Integer update(Repair Repair);

    /**
     *  根据id查询Repair
     * @param id id
     * @return Repair对象
     */
    Repair getRepairById(@Param("id") Integer id);

    /**
     *  查询全部Repair
     * @return List
     */
    List<Repair> getRepairList();

}
