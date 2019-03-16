package com.we.sdk.memsap.dao;

import com.we.sdk.memsap.bean.Brand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * 
 * @author sudk
 * @date 2019-01-19 15:51:36
 */
@Mapper
public interface BrandDao {

    /**
    *  新增Brand
    * @param brand 新增的对象
    * @return 新增成功条数
    */
    Integer save(Brand brand);

    /**
     *  根据id删除Brand
     * @param id id
     * @return 删除成功条数
     */
    Integer delete(@Param("id") Integer id);

    /**
     *  修改Brand
     * @param brand 修改的对象
     * @return 修改成功条数
     */
    Integer update(Brand brand);

    /**
     *  根据id查询Brand
     * @param id id
     * @return Brand对象
     */
    Brand getBrandById(@Param("id") Integer id);


    /**
     *  查询所有Brand
     * @return Brand对象
     */
    List<Brand> getBrands();

}
