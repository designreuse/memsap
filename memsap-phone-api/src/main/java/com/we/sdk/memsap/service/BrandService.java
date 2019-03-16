package com.we.sdk.memsap.service;

import com.we.sdk.memsap.bean.Brand;

import java.util.List;

/**
 * 
 *
 * @author sudk
 * @date 2019-01-19 15:51:36
 */
public interface BrandService {

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
    Integer delete(Integer id);

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
    Brand getBrandById(Integer id);

    /**
     *  查询所有Brand
     * @return List
     */
    List<Brand> getBrands();

}

