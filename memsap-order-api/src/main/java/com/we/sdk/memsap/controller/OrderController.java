package com.we.sdk.memsap.controller;

import com.we.sdk.memsap.base.result.RestResult;
import com.we.sdk.memsap.base.vo.SearchVo;
import com.we.sdk.memsap.bean.Order;
import com.we.sdk.memsap.bean.OrderDetail;
import com.we.sdk.memsap.base.vo.Page;
import com.we.sdk.memsap.base.result.RestResultGenerator;
import com.we.sdk.memsap.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author SDK
 * @date 2019-02-25 12:31:17
 */
@RestController
@Api(value = "Order接口", description = "Order接口")
@RequestMapping("order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 新增
     */
    @ApiOperation(value = "新增Order", notes = "新增Order")
    @PostMapping(value = "/save")
    public RestResult<Integer> save(@RequestBody Order order) {
        Integer result = orderService.save(order);
        return RestResultGenerator.createOkResult(result);
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除Order", notes = "删除Order")
    @PostMapping(value = "/delete")
    public RestResult<Integer> delete(@RequestParam Integer id) {
        Integer result = orderService.delete(id);
        return RestResultGenerator.createOkResult(result);
    }

    /**
     * 修改
     */
    @ApiOperation(value = "修改Order", notes = "修改Order")
    @PostMapping(value = "/update")
    public RestResult<Integer> update(@RequestBody Order order) {
        Integer result = orderService.update(order);
        return RestResultGenerator.createOkResult(result);
    }

    /**
     * 列表
     */
    @ApiOperation(value = "查询Order列表", notes = "查询Order列表")
    @PostMapping("/getOrderListByCondition")
    public RestResult<List<Order>> getOrderListByCondition(@RequestParam("searchVo") SearchVo searchVo, @RequestBody(required = false) Page page) {
        List<Order> OrderList = orderService.getOrderListByCondition(searchVo, Page.initPage(page));
        return RestResultGenerator.createOkResult(OrderList);
    }

    /*
     * 根据id查询Order
     */
    @ApiOperation(value = "根据id查询Order", notes = "根据id查询Order")
    @GetMapping(value = "/getOrderById/{id}")
    public RestResult<Order> getOrderById(@PathVariable Integer id) {
        Order order = orderService.getOrderById(id);
        return RestResultGenerator.createOkResult(order);
    }

    @ApiOperation(value = "批量插入OrderDetail", notes = "批量插入订单详情")
    @PostMapping(value = "/saveOrderDetails")
    public RestResult<Integer> saveOrderDetails(@RequestBody List<OrderDetail> orderDetails) {
        Integer result = orderService.saveOrderDetail(orderDetails);
        return RestResultGenerator.createOkResult(result);
    }

    @ApiOperation(value = "根据id删除orderDetail", notes = "根据id删除订单详情")
    @PostMapping(value = "/deleteOrderDetail")
    public RestResult<Integer> deleteOrderDetail(Integer id) {
        Integer result = orderService.deleteOrderDetail(id);
        return RestResultGenerator.createOkResult(result);
    }

    @ApiOperation(value = "通过orderIds批量删除orderDetail", notes = "通过订单号批量删除订单详情")
    @PostMapping(value = "/batchDeleteDetailByOrderIds")
    public RestResult<Integer> batchDeleteDetailByOrderIds(@RequestBody List<Integer> orderIds) {
        Integer result = orderService.batchDeleteDetailByOrderIds(orderIds);
        return RestResultGenerator.createOkResult(result);
    }

    @ApiOperation(value = "根据id查询OrderDetail", notes = "根据id查询OrderDetail")
    @PostMapping(value = "/getOrderDetailById")
    public RestResult<OrderDetail> getOrderDetailById(@RequestParam Integer id) {
        OrderDetail orderDetail = orderService.getOrderDetailById(id);
        return RestResultGenerator.createOkResult(orderDetail);
    }

    @ApiOperation(value = "通过orderIds查询OrderDetails", notes = "通过多个订单号查询多个订单详情")
    @PostMapping(value = "/getOrderDetailsByOrderIds")
    public RestResult<List<OrderDetail>> getOrderDetailsByOrderIds(@RequestBody List<Integer> orderIds) {
        List<OrderDetail> orderDetails = orderService.getOrderDetailsByOrderIds(orderIds);
        return RestResultGenerator.createOkResult(orderDetails);
    }


}