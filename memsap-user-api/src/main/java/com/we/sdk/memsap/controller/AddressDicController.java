package com.we.sdk.memsap.controller;

import com.we.sdk.memsap.base.result.RestResult;
import com.we.sdk.memsap.base.result.RestResultGenerator;
import com.we.sdk.memsap.base.vo.Page;
import com.we.sdk.memsap.bean.AddressDic;
import com.we.sdk.memsap.service.AddressDicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author SDK
 * @date 2019-02-23 17:21:29
 */
@RestController
@Api(value = "AddressDic接口", description = "AddressDic接口")
@RequestMapping("/addressDic")
@RequiredArgsConstructor
public class AddressDicController {

    private final AddressDicService addressDicService;

    /**
     * 新增
     */
    @ApiOperation(value = "新增AddressDic", notes = "新增AddressDic")
    @PostMapping(value = "/save")
    public RestResult<Integer> save(@RequestBody AddressDic addressDic) {
        AddressDic address = addressDicService.getAddressDicByAddress(addressDic.getAddress());
        if (!ObjectUtils.isEmpty(address)) {
            return RestResultGenerator.createFailResult("地址字典名称已经存在");
        }
        Integer result = addressDicService.save(addressDic);
        return RestResultGenerator.createOkResult(result);
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除AddressDic", notes = "删除AddressDic")
    @DeleteMapping(value = "/delete/{id}")
    public RestResult<Integer> delete(@PathVariable("id") Integer id) {
        Integer result = addressDicService.delete(id);
        return RestResultGenerator.createOkResult(result);
    }

    /**
     * 修改
     */
    @ApiOperation(value = "修改AddressDic", notes = "修改AddressDic")
    @PostMapping(value = "/update")
    public RestResult<Integer> update(@RequestBody AddressDic addressDic) {
        Integer result = addressDicService.update(addressDic);
        return RestResultGenerator.createOkResult(result);
    }

    /**
     * 列表
     */
    @ApiOperation(value = "查询AddressDic列表", notes = "查询AddressDic列表")
    @PostMapping("/getAddressDicListByCondition")
    public RestResult<Page<AddressDic>> getAddressDicListByCondition(@RequestParam(required = false) String address, @RequestBody(required = false) Page page) {
        Page<AddressDic> data = addressDicService.getAddressDicListByCondition(address, Page.initPage(page));
        return RestResultGenerator.createOkResult(data);
    }

    /*
     * 根据id查询AddressDic
     */
    @ApiOperation(value = "根据id查询AddressDic", notes = "根据id查询AddressDic")
    @GetMapping(value = "/getAddressDicById/{id}")
    public RestResult<AddressDic> getAddressDicById(@PathVariable("id") Integer id) {
        AddressDic addressDic = addressDicService.getAddressDicById(id);
        return RestResultGenerator.createOkResult(addressDic);
    }


    /*
     * 根据父亲id查询AddressDic
     */
    @ApiOperation(value = "根据id查询AddressDic", notes = "根据id查询AddressDic")
    @GetMapping(value = "/getAddressDicByParentId/{parentId}")
    public RestResult<List<AddressDic>> getAddressDicByParentId(@PathVariable("parentId") Integer id) {
        List<AddressDic> addressDic = addressDicService.getAddressDicByParentId(id);
        return RestResultGenerator.createOkResult(addressDic);
    }
}
