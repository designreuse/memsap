package com.we.sdk.memsap.service;

import com.we.sdk.memsap.bean.Series;

import java.util.List;

/**
 * @author sudk
 * @date 2019-01-19 15:31:13
 */
public interface SeriesService {

    /**
     * 新增Series
     *
     * @param series 新增的对象
     * @return 新增成功条数
     */
    Integer save(Series series);

    /**
     * 根据id删除Series
     *
     * @param id id
     * @return 删除成功条数
     */
    Integer delete(Integer id);

    /**
     * 修改Series
     *
     * @param series 修改的对象
     * @return 修改成功条数
     */
    Integer update(Series series);

    /**
     * 根据id查询Series
     * @param id id
     * @return Series对象
     */
    Series getSeriesById(Integer id);

    /**
     * 查询所有Series
     * @return List
     */
    List<Series> getSeriesList();


}

