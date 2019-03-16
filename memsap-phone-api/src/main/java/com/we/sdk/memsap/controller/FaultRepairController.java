package com.we.sdk.memsap.controller;

import com.we.sdk.memsap.base.result.RestResult;
import com.we.sdk.memsap.base.result.RestResultGenerator;
import com.we.sdk.memsap.bean.RepairPrice;
import com.we.sdk.memsap.service.FaultRepairService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author sudk
 * @date 2019-01-19 15:31:05
 */
@RestController
@Api(value = "FaultRepair接口", description = "用来查询各个维修的价格")
@RequestMapping("/repairPrice")
@RequiredArgsConstructor
public class FaultRepairController {
    private final FaultRepairService faultRepairService;

    @ApiOperation(value = "新增RepairPrice", notes = "新增手机故障维修价格")
    @PostMapping(value = "/save")
    public RestResult<Integer> save(@RequestBody RepairPrice repairPrice) {
        if (!StringUtils.isEmpty(faultRepairService.getFaultRepairPriceByCondition(repairPrice))) {
            return RestResultGenerator.createFailResult("对应故障维修价格已经存在");
        }
        Integer result = faultRepairService.save(repairPrice);
        return RestResultGenerator.createOkResult(result);
    }

    @ApiOperation(value = "删除RepairPrice", notes = "删除手机故障维修价格")
    @PostMapping(value = "/delete")
    public RestResult<Integer> delete(@RequestBody RepairPrice repairPrice) {
        Integer result = faultRepairService.delete(repairPrice);
        return RestResultGenerator.createOkResult(result);
    }

    @ApiOperation(value = "修改RepairPrice", notes = "修改手机故障维修价格")
    @PostMapping(value = "/update")
    public RestResult<Integer> update(@RequestBody RepairPrice repairPrice) {
        Integer result = faultRepairService.update(repairPrice);
        return RestResultGenerator.createOkResult(result);
    }

 /*   @ApiOperation(value = "查询RepairPrice列表", notes = "查询手机故障维修价格列表")
    @PostMapping("/getFaultRepairPriceList")
    public RestResult<List<RepairPrice>> getFaultRepairPriceList() {
        List<RepairPrice> repairPriceList = faultRepairService.getFaultRepairPriceList();
        return RestResultGenerator.createOkResult(repairPriceList);
    }*/

    @ApiOperation(value = "根据条件查询RepairPrice", notes = "根据条件查询手机故障维修价格")
    @PostMapping(value = "/getFaultRepairPriceListByCondition")
    public RestResult<List<RepairPrice>> getFaultRepairPriceByCondition(@RequestBody(required = false) RepairPrice repairPrice) {
        List<RepairPrice> repairPriceList = faultRepairService.getFaultRepairPriceByCondition(repairPrice);
        return RestResultGenerator.createOkResult(repairPriceList);
    }

}
