package com.we.sdk.memsap.controller;

import com.we.sdk.memsap.base.result.RestResult;
import com.we.sdk.memsap.base.result.RestResultGenerator;
import com.we.sdk.memsap.bean.Brand;
import com.we.sdk.memsap.service.BrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author sudk
 * @date 2019-01-19 15:51:36
 */
@RestController
@Api(value = "Brand接口", description = "Brand接口")
@RequestMapping("/brand")
@RequiredArgsConstructor
public class BrandController {

    private final BrandService brandService;

    /**
     * 新增
     */
    @ApiOperation(value = "新增Brand", notes = "新增Brand")
    @PostMapping(value = "/save")
    public RestResult<Integer> save(@RequestBody Brand brand) {
        Integer result = brandService.save(brand);
        return RestResultGenerator.createOkResult(result);
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除Brand", notes = "删除Brand")
    @PostMapping(value = "/delete")
    public RestResult<Integer> delete(@RequestParam Integer id) {
        Integer result = brandService.delete(id);
        return RestResultGenerator.createOkResult(result);
    }

    /**
     * 修改
     */
    @ApiOperation(value = "修改Brand", notes = "修改Brand")
    @PostMapping(value = "/update")
    public RestResult<Integer> update(@RequestBody Brand brand) {
        Integer result = brandService.update(brand);
        return RestResultGenerator.createOkResult(result);
    }

    /**
     * 列表
     */
    @ApiOperation(value = "查询Brand列表", notes = "查询Brand列表")
    @GetMapping("/getBrands")
    public RestResult<List<Brand>> getBrands() {
        List<Brand> BrandList = brandService.getBrands();
        return RestResultGenerator.createOkResult(BrandList);
    }

    /**
     * 根据id查询Brand
     * @param id
     * @return
     */
    @ApiOperation(value = "根据id查询Brand", notes = "根据id查询Brand")
    @PostMapping(value = "/getBrandById")
    public RestResult<Brand> getBrandById(@RequestParam Integer id) {
        Brand brand = brandService.getBrandById(id);
        return RestResultGenerator.createOkResult(brand);
    }

}
