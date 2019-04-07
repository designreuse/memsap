package com.we.sdk.memsap.feign;

import com.we.sdk.memsap.base.result.RestResult;
import com.we.sdk.memsap.base.vo.Page;
import com.we.sdk.memsap.base.vo.SearchVo;
import com.we.sdk.memsap.bean.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "memsap-order-api")
@RequestMapping("/memsap-order-api")
public interface OrderFeignClient {
    /* *//*新增*//*
    @PostMapping(value = "/order/save")
    RestResult<Integer> save(@RequestBody Order order);

    *//*删除*//*
    @DeleteMapping(value = "/order/delete/{id}")
    RestResult<Integer> delete(@PathVariable("id") Integer id);

    *//*修改*//*
    @PostMapping(value = "/order/update")
    RestResult<Integer> update(@RequestBody Order order);*/

    /*条件查询查询列表*/
    @PostMapping(value = "/order/getOrderListByCondition")
    RestResult<Page<Order>> getOrderListByCondition(@RequestBody SearchVo searchVo);

    /*根据id获取Order*/
    @GetMapping(value = "/order/getOrderById/{id}")
    RestResult<Order> getOrderById(@PathVariable("id") Integer id);
}
