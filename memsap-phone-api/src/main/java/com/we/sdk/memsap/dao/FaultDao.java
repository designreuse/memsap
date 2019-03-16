package com.we.sdk.memsap.dao;

import com.we.sdk.memsap.bean.Fault;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * 
 * @author sudk
 * @date 2019-01-19 15:30:55
 */
@Mapper
public interface FaultDao {

    /**
    *  新增Fault
    * @param fault 新增的对象
    * @return 新增成功条数
    */
    Integer save(Fault fault);

    /**
     *  根据id删除Fault
     * @param id id
     * @return 删除成功条数
     */
    Integer delete(@Param("id") Integer id);

    /**
     *  修改Fault
     * @param fault 修改的对象
     * @return 修改成功条数
     */
    Integer update(Fault fault);

    /**
     *  根据id查询Fault
     * @param id id
     * @return Fault对象
     */
    Fault getFaultById(@Param("id") Integer id);

    List<Fault> getFaultList();

}
