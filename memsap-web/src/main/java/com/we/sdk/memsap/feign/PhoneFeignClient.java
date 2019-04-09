package com.we.sdk.memsap.feign;

import com.we.sdk.memsap.base.result.RestResult;
import com.we.sdk.memsap.base.vo.Page;
import com.we.sdk.memsap.base.vo.SearchVo;
import com.we.sdk.memsap.bean.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@FeignClient(name = "memsap-phone-api", fallbackFactory = HystrixFallbackFactory.class, url = "http://localhost:8080")
@FeignClient(name = "memsap-phone-api")
@RequestMapping("/memsap-phone-api")
public interface PhoneFeignClient {
    /*新增*/
    @PostMapping(value = "/phone/save")
    RestResult<Integer> save(@RequestBody Phone phone);

    /*删除*/
    @DeleteMapping(value = "/phone/delete/{id}")
    RestResult<Integer> delete(@PathVariable Integer id);

    /*修改*/
    @PostMapping(value = "/phone/update")
    RestResult<Integer> update(@RequestBody Phone phone);


    @PostMapping(value = "/phone/getPhoneListByConditions")
    RestResult<Page<Phone>> getPhoneListByConditions(@RequestBody SearchVo searchVo);

    /*根据id获取Phone*/
    @GetMapping(value = "/phone/getPhoneById/{id}")
    RestResult<Phone> getPhoneById(@PathVariable Integer id);

    @GetMapping(value = "/phone/getPhoneList")
    RestResult<List<Phone>> getPhoneList();


    /////////////////////////////    fault-repair
    //维修价格
    @PostMapping(value = "/repairPrice/getFaultRepairPriceListByCondition")
    RestResult<List<RepairPrice>> getFaultRepairPriceByCondition(@RequestBody RepairPrice repairPrice);

    @PostMapping(value = "/repairPrice/batchEdit")
    RestResult<Integer> batchEdit(@RequestBody List<RepairPrice> repairPriceList);


    @GetMapping(value = "/fault/getFaultList")
    RestResult<List<Fault>> getFaultList();

    @GetMapping(value = "/repair/getRepairList")
    RestResult<List<Repair>> getRepairList();

    @GetMapping(value = "/brand/getBrands")
    RestResult<List<Brand>> getBrandList();

    ///////////////////////////// series
    /*新增*/
    @PostMapping(value = "/series/save")
    RestResult<Integer> saveSeries(@RequestBody Series series);

    /*删除*/
    @DeleteMapping(value = "/series/delete/{id}")
    RestResult<Integer> deleteSeries(@PathVariable Integer id);

    /*修改*/
    @PostMapping(value = "/series/update")
    RestResult<Integer> updateSeries(@RequestBody Series series);


    @GetMapping(value = "/series/getSeriesList")
    RestResult<List<Series>> getSeriesList();

    /*根据id获取系列*/
    @GetMapping(value = "/series/getSeriesById/{id}")
    RestResult<Series> getSeriesById(@PathVariable Integer id);


}
