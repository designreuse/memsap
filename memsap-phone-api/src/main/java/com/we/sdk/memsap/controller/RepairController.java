package com.we.sdk.memsap.controller;

import com.we.sdk.memsap.base.result.RestResult;
import com.we.sdk.memsap.base.result.RestResultGenerator;
import com.we.sdk.memsap.bean.Repair;
import com.we.sdk.memsap.service.RepairService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 
 *
 * @author sudk
 * @date 2019-01-19 15:31:00
 */
@RestController
@Api(value = "Repair接口", description = "Repair接口")
@RequestMapping("/repair")
public class RepairController {
    @Autowired
    private RepairService repairService;

    /**
     * 新增
     */
    @ApiOperation(value = "新增Repair", notes = "新增Repair")
    @PostMapping(value = "/save")
    public RestResult<Integer> save(@RequestBody Repair Repair){
        Integer result = repairService.save(Repair);
        return RestResultGenerator.createOkResult(result);
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除Repair", notes = "删除Repair")
    @PostMapping(value = "/delete")
    public RestResult<Integer> delete(@RequestParam Integer id){
        Integer result = repairService.delete(id);
        return RestResultGenerator.createOkResult(result);
    }

    /**
     * 修改
     */
    @ApiOperation(value = "修改Repair", notes = "修改Repair")
    @PostMapping(value = "/update")
    public RestResult<Integer> update(@RequestBody Repair Repair){
        Integer result = repairService.update(Repair);
        return RestResultGenerator.createOkResult(result);
    }

    /**
     * 列表
     */
    @ApiOperation(value = "查询Repair列表", notes = "查询Repair列表")
    @GetMapping("/getRepairList")
    public RestResult<List<Repair>> getRepairList(){
        List<Repair> RepairList = repairService.getRepairList();
        return RestResultGenerator.createOkResult(RepairList);
    }

    /**
     * 根据id查询Repair
     * @param id
     * @return
     */
    @ApiOperation(value = "根据id查询Repair", notes = "根据id查询Repair")
    @PostMapping(value = "/getRepairById")
    public RestResult<Repair> getRepairById(@RequestParam Integer id) {
        Repair Repair = repairService.getRepairById(id);
        return RestResultGenerator.createOkResult(Repair);
    }

}
