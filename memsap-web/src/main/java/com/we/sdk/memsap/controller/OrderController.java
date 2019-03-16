package com.we.sdk.memsap.controller;//package com.we.sdk.memsap.controller;
//
//import com.we.sdk.memsap.base.vo.Page;
//import com.we.sdk.memsap.base.vo.SearchVo;
//import Order;
//import com.we.sdk.memsap.service.OrderService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("/order")
//public class OrderController {
//
//    @Autowired
//    private OrderService orderService;
//
//    /**
//     * 列表
//     */
//    @RequestMapping("/page")
//    public String getOrderListByCondition(Model model, SearchVo searchVo, Page page) {
//        List<Order> orderList = orderService.getOrderListByCondition(searchVo, page);
////        Integer orderCount = orderService.getOrderListCount(searchVo);
////        if (orderCount != null) {
////            page.setTotalCount(orderCount);
////        }
//        model.addAttribute("orderList", orderList);
////        model.addAttribute("searchVo", searchVo);
////        model.addAttribute("page", page);
//        return "order/orderManage";
//    }
//
//    @GetMapping("/get/{id}")
//    public String getOrderById(Model model, @PathVariable Integer id) {
//        Order order = orderService.getOrderById(id);
//        model.addAttribute("order", order);
//        return "order/orderManage";
//    }
//
//    @RequestMapping("/update")
//    @ResponseBody
//    public Integer updateOrder(@RequestBody Order order) {
//        return orderService.update(order);
//    }
//
//    @RequestMapping("/save")
//    @ResponseBody
//    public Integer saveOrder(@RequestBody Order order) {
//        return orderService.save(order);
//    }
//
//    @RequestMapping("/delete/{id}")
//    @ResponseBody
//    public Integer saveOrder(@PathVariable Integer id) {
//        return orderService.delete(id);
//    }
//}
//
