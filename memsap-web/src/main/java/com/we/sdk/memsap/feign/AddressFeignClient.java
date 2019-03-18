package com.we.sdk.memsap.feign;

import com.we.sdk.memsap.base.result.RestResult;
import com.we.sdk.memsap.base.vo.Page;
import com.we.sdk.memsap.bean.Address;
import com.we.sdk.memsap.bean.AddressDic;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "memsap-user-api", url = "http://localhost:8082")
@RequestMapping("/memsap-user-api")
public interface AddressFeignClient {
    /*新增*/
    /*@PostMapping(value = "/address/save")
    RestResult<Integer> save(@RequestBody User user);*/

    /*删除*/
    @DeleteMapping(value = "/address/delete/{id}")
    RestResult<Integer> delete(@PathVariable Integer id);

    /*条件查询列表*/
    @GetMapping(value = "/address/getAddressByPhoneNumber/{phoneNumber}")
    RestResult<List<Address>> getAddressByPhoneNumber(@PathVariable String phoneNumber);

    //////////////////////  Address
    /*条件查询列表*/
    @GetMapping(value = "/address/getAddressList")
    RestResult<List<Address>> getAddressList();


    //////////////////////////////////////////////////  AddressDic

    @PostMapping(value = "/addressDic/getAddressDicListByCondition")
    RestResult<Page<AddressDic>> getAddressDicListByCondition(@RequestParam("address") String address, @RequestBody Page page);

    @PostMapping(value = "/addressDic/save")
    RestResult<Integer> saveAddressDic(@RequestBody AddressDic addressDic);

    @DeleteMapping(value = "/addressDic/delete/{id}")
    RestResult<Integer> deleteAddressDic(@PathVariable("id") Integer id);

    @PostMapping(value = "/addressDic/update")
    RestResult<Integer> updateAddressDic(@RequestBody AddressDic addressDic);

    /*根据父亲id获取下面的所有AddressDic*/
    @GetMapping(value = "/addressDic/getAddressDicByParentId/{parentId}")
    RestResult<List<AddressDic>> getAddressDicByParentId(@PathVariable("parentId") Integer parentId);

}