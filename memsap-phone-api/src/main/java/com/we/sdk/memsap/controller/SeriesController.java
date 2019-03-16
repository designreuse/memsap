package com.we.sdk.memsap.controller;

import com.we.sdk.memsap.base.result.RestResult;
import com.we.sdk.memsap.base.result.RestResultGenerator;
import com.we.sdk.memsap.bean.Series;
import com.we.sdk.memsap.service.SeriesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author sudk
 * @date 2019-01-19 15:31:13
 */
@RestController
@Api(value = "Series接口", description = "Series接口")
@RequestMapping("/series")
@RequiredArgsConstructor
public class SeriesController {

    private final SeriesService seriesService;

    /**
     * 新增
     */
    @ApiOperation(value = "新增Series", notes = "新增Series")
    @PostMapping(value = "/save")
    public RestResult<Integer> save(@RequestBody Series series) {
        Integer result = seriesService.save(series);
        return RestResultGenerator.createOkResult(result);
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除Series", notes = "删除Series")
    @DeleteMapping(value = "/delete/{id}")
    public RestResult<Integer> delete(@PathVariable Integer id) {
        Integer result = seriesService.delete(id);
        return RestResultGenerator.createOkResult(result);
    }

    /**
     * 修改
     */
    @ApiOperation(value = "修改Series", notes = "修改Series")
    @PostMapping(value = "/update")
    public RestResult<Integer> update(@RequestBody Series series) {
        Integer result = seriesService.update(series);
        return RestResultGenerator.createOkResult(result);
    }

    /**
     * 列表
     */
    @ApiOperation(value = "查询Series列表", notes = "查询Series列表")
    @GetMapping("/getSeriesList")
    public RestResult<List<Series>> getSeriesList() {
        List<Series> SeriesList = seriesService.getSeriesList();
        return RestResultGenerator.createOkResult(SeriesList);
    }

    /**
     * 根据id查询Series
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "根据id查询Series", notes = "根据id查询Series")
    @GetMapping(value = "/getSeriesById/{id}")
    public RestResult<Series> getSeriesById(@PathVariable Integer id) {
        Series series = seriesService.getSeriesById(id);
        return RestResultGenerator.createOkResult(series);
    }

}
