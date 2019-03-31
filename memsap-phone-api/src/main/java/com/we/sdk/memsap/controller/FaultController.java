package com.we.sdk.memsap.controller;

import com.we.sdk.memsap.base.result.RestResult;
import com.we.sdk.memsap.base.result.RestResultGenerator;
import com.we.sdk.memsap.bean.Fault;
import com.we.sdk.memsap.service.FaultService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 
 *
 * @author sudk
 * @date 2019-01-19 15:30:55
 */
@RestController
@Api(value = "Fault接口", description = "Fault接口")
@RequestMapping("/fault")
public class FaultController {
    @Autowired
    private FaultService faultService;

    /**
     * 新增
     */
    @ApiOperation(value = "新增Fault", notes = "新增Fault")
    @PostMapping(value = "/save")
    public RestResult<Integer> save(@RequestBody Fault fault){
        Integer result = faultService.save(fault);
        return RestResultGenerator.createOkResult(result);
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除Fault", notes = "删除Fault")
    @DeleteMapping(value = "/delete/{id}")
    public RestResult<Integer> delete(@PathVariable Integer id){
        Integer result = faultService.delete(id);
        return RestResultGenerator.createOkResult(result);
    }

    /**
     * 修改
     */
    @ApiOperation(value = "修改Fault", notes = "修改Fault")
    @PostMapping(value = "/update")
    public RestResult<Integer> update(@RequestBody Fault fault){
        Integer result = faultService.update(fault);
        return RestResultGenerator.createOkResult(result);
    }

    /**
     * 列表
     */
    @ApiOperation(value = "查询Fault列表", notes = "查询Fault列表")
    @GetMapping("/getFaultList")
    public RestResult<List<Fault>> getFaultList(){
        List<Fault> FaultList = faultService.getFaultList();
        return RestResultGenerator.createOkResult(FaultList);
    }

    /**
     * 根据id查询Fault
     * @param id
     * @return
     */
    @ApiOperation(value = "根据id查询Fault", notes = "根据id查询Fault")
    @GetMapping(value = "/getFaultById/{id}")
    public RestResult<Fault> getFaultById(@PathVariable Integer id) {
        Fault fault = faultService.getFaultById(id);
        return RestResultGenerator.createOkResult(fault);
    }

}
