package com.we.sdk.memsap.controller;

import com.we.sdk.memsap.base.result.RestResult;
import com.we.sdk.memsap.base.result.RestResultGenerator;
import com.we.sdk.memsap.base.vo.Page;
import com.we.sdk.memsap.base.vo.SearchVo;
import com.we.sdk.memsap.bean.Phone;
import com.we.sdk.memsap.service.PhoneService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author sudk
 * @date 2019-01-19 15:31:09
 */
@RestController
@Api(value = "Phone接口", description = "Phone接口")
@RequestMapping("/phone")
@RequiredArgsConstructor
public class PhoneController {

    private final PhoneService phoneService;

    /**
     * 新增
     */
    @ApiOperation(value = "新增Phone", notes = "新增Phone")
    @PostMapping(value = "/save")
    public RestResult<Integer> save(@RequestBody Phone phone) {
        phoneService.save(phone);
        return RestResultGenerator.createOkResult(phone.getId());
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除Phone", notes = "删除Phone")
    @DeleteMapping(value = "/delete/{id}")
    public RestResult<Integer> delete(@PathVariable Integer id) {
        Integer result = phoneService.delete(id);
        return RestResultGenerator.createOkResult(result);
    }

    /**
     * 修改
     */
    @ApiOperation(value = "修改Phone", notes = "修改Phone")
    @PostMapping(value = "/update")
    public RestResult<Integer> update(@RequestBody Phone phone) {
        Integer result = phoneService.update(phone);
        return RestResultGenerator.createOkResult(result);
    }

    /**
     * 列表
     */
    @ApiOperation(value = "查询Phone列表", notes = "查询Phone列表")
    @PostMapping("/getPhoneListByConditions")
    public RestResult<Page<Phone>> getPhoneListByConditions(@RequestBody(required = false) SearchVo searchVo) {
        Page<Phone> phoneList = phoneService.getPhoneListByConditions(searchVo, Page.initPage(searchVo.getPage()));
        return RestResultGenerator.createOkResult(phoneList);
    }
//    @ApiOperation(value = "查询Phone列表", notes = "查询Phone列表")
//    @PostMapping("/getPhoneListByConditions/{pn}/{pageSize}")
//    public RestResult<Page<Phone>> getPhoneListByConditions(@RequestBody(required = false) SearchVo searchVo, @PathVariable Integer pn, @PathVariable Integer pageSize) {
//        Page<Phone> phoneList = phoneService.getPhoneListByConditions(searchVo, Page.initPage(new Page(pn, pageSize)));
//        return RestResultGenerator.createOkResult(phoneList);
//    }

    /**
     * 根据id查询Phone
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "根据id查询Phone", notes = "根据id查询Phone")
    @GetMapping(value = "/getPhoneById/{id}")
    public RestResult<Phone> getPhoneById(@PathVariable Integer id) {
        Phone phone = phoneService.getPhoneById(id);
        return RestResultGenerator.createOkResult(phone);
    }

    /**
     * 查询PhoneList
     *
     * @param
     * @return
     */
    @ApiOperation(value = "查询PhoneList", notes = "查询PhoneList")
    @GetMapping(value = "/getPhoneList")
    public RestResult<List<Phone>> getPhoneList() {
        System.out.println(1);
        List<Phone> phoneList = phoneService.getPhoneList();
        return RestResultGenerator.createOkResult(phoneList);
    }

}
