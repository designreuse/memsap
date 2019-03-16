package com.we.sdk.memsap.dao;

import com.we.sdk.memsap.bean.Series;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * 
 * @author sudk
 * @date 2019-01-19 15:31:13
 */
@Mapper
public interface SeriesDao {

    /**
    *  新增Series
    * @param series 新增的对象
    * @return 新增成功条数
    */
    Integer save(Series series);

    /**
     *  根据id删除Series
     * @param id id
     * @return 删除成功条数
     */
    Integer delete(@Param("id") Integer id);

    /**
     *  修改Series
     * @param series 修改的对象
     * @return 修改成功条数
     */
    Integer update(Series series);

    /**
     *  根据id查询Series
     * @param id id
     * @return Series对象
     */
    Series getSeriesById(@Param("id") Integer id);

    /**
     *  查询全部Series
     * @return List
     */
    List<Series> getSeriesList();

}
