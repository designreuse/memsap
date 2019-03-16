package com.we.sdk.memsap.feign;

import com.we.sdk.memsap.base.result.RestResult;
import com.we.sdk.memsap.bean.Series;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "series", url = "http://localhost:8080")
@RequestMapping("/memsap-phone-api/series")
public interface SeriesFeignClient {
    /*新增*/
    @PostMapping(value = "/save")
    RestResult<Integer> save(@RequestBody Series series);

    /*删除*/
    @DeleteMapping(value = "/delete/{id}")
    RestResult<Integer> delete(@PathVariable Integer id);

    /*修改*/
    @PostMapping(value = "/update")
    RestResult<Integer> update(@RequestBody Series series);


    @GetMapping(value = "/getSeriesList")
    RestResult<List<Series>> getSeriesList();

    /*根据id获取系列*/
    @GetMapping(value = "/getSeriesById/{id}")
    RestResult<Series> getSeriesById(@PathVariable Integer id);

}
