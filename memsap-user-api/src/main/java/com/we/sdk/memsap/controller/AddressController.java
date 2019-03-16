package com.we.sdk.memsap.controller;

import com.we.sdk.memsap.base.result.RestResult;
import com.we.sdk.memsap.base.result.RestResultGenerator;
import com.we.sdk.memsap.bean.Address;
import com.we.sdk.memsap.service.AddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 
 *
 * @author SDK
 * @date 2019-02-23 17:20:52
 */
@RestController
@Api(value = "Address接口", description = "Address接口")
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    /**
     * 新增
     */
    @ApiOperation(value = "新增Address", notes = "新增用户地址")
    @PostMapping(value = "/save")
    public RestResult<Integer> save(@RequestBody Address address){
        Integer result = addressService.save(address);
        return RestResultGenerator.createOkResult(result);
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除Address", notes = "删除用户地址")
    @DeleteMapping(value = "/delete/{id}")
    public RestResult<Integer> delete(@PathVariable Integer id){
        Integer result = addressService.delete(id);
        return RestResultGenerator.createOkResult(result);
    }

    /**
     * 修改
     */
    @ApiOperation(value = "修改Address", notes = "修改用户地址")
    @PostMapping(value = "/update")
    public RestResult<Integer> update(@RequestBody Address address){
        Integer result = addressService.update(address);
        return RestResultGenerator.createOkResult(result);
    }

    /**
     * 列表
     */
    @ApiOperation(value = "查询Address列表", notes = "查询Address列表")
    @GetMapping("/getAddressList")
    public RestResult<List<Address>> getAddressList(){
        List<Address> UserAddressList = addressService.getAddressList();
        return RestResultGenerator.createOkResult(UserAddressList);
    }


    /*
     * 根据id查询UserAddress
     */
    @ApiOperation(value = "根据id查询Address", notes = "根据id查询Address")
    @GetMapping(value = "/getUserAddressById/{id}")
    public RestResult<Address> getAddressById(@PathVariable Integer id) {
        Address userAddress = addressService.getAddressById(id);
        return RestResultGenerator.createOkResult(userAddress);
    }

    /*
     * 根据用户手机号查询UserAddress
     */
    @ApiOperation(value = "根据用户手机号查询全部Address", notes = "根据用户手机号查询查询地址")
    @GetMapping(value = "/getAddressByPhoneNumber/{phoneNumber}")
    public RestResult<List<Address>> getAddressByPhoneNumber(@PathVariable String phoneNumber) {
        List<Address> userAddress = addressService.getAddressByPhoneNumber(phoneNumber);
        return RestResultGenerator.createOkResult(userAddress);
    }

}
