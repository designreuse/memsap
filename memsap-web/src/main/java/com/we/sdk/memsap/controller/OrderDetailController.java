package com.we.sdk.memsap.controller;//package com.we.sdk.memsap.order.controller;
//
//import Page;
//import SearchVo;
//import OrderDetail;
//import OrderDetailService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("/OrderDetail")
//@Api(value = "指标配置页面", description = "指标配置页面")
//public class OrderDetailController {
//    private static final Logger log = LoggerFactory.getLogger(OrderDetailController.class);
//    @Autowired
//    private OrderDetailService orderDetailService;
//
//    /**
//     * 列表
//     */
//    @ApiOperation(value = "查询OrderDetail列表", notes = "查询OrderDetail列表")
//    @RequestMapping("/page")
//    public String getOrderDetailListByPage(Model model, SearchVo searchVo, Page page) {
//        List<OrderDetail> orderDetailList = orderDetailService.getOrderDetailListByPage(searchVo, page);
//        Integer orderDetailCount = orderDetailService.getOrderDetailListCount(searchVo);
//        if (orderDetailCount != null) {
//            page.setTotalCount(orderDetailCount);
//        }
//        model.addAttribute("orderDetailList", orderDetailList);
//        model.addAttribute("searchVo", searchVo);
//        model.addAttribute("page", page);
//        return "orderDetail/orderDetail_page";
//    }
//
//    @ApiOperation("根据ID获取OrderDetail")
//    @RequestMapping("/getOrderDetail")
//    public String getOrderDetailById(Model model, @RequestParam Integer id) {
//        OrderDetail orderDetail = orderDetailService.getOrderDetailById(id);
//        model.addAttribute("orderDetail", orderDetail);
//        return "orderDetail/orderDetail_details";
//    }
//
//    @ApiOperation("修改OrderDetail")
//    @RequestMapping("/update")
//    @ResponseBody
//    public Integer updateOrderDetail(OrderDetail orderDetail) {
//        return orderDetailService.update(orderDetail);
//    }
//
//    @ApiOperation("新增OrderDetail")
//    @RequestMapping("/save")
//    @ResponseBody
//    public Integer saveOrderDetail(OrderDetail orderDetail) {
//        return orderDetailService.save(orderDetail);
//    }
//
//    @ApiOperation("根据ID删除OrderDetail")
//    @RequestMapping("/delete")
//    @ResponseBody
//    public Integer saveOrderDetail(Integer id) {
//        return orderDetailService.delete(id);
//    }
//}
//
