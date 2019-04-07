package com.we.sdk.memsap.controller;//package com.we.sdk.memsap.controller;

import com.we.sdk.memsap.base.vo.Page;
import com.we.sdk.memsap.base.vo.SearchVo;
import com.we.sdk.memsap.bean.Order;
import com.we.sdk.memsap.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 列表
     */
    @RequestMapping("/listByCondition")
    public String getOrderListByCondition(Model model, SearchVo searchVo, Page page) {
        Page<Order> orderList = orderService.getOrderListByCondition(searchVo, page);
        model.addAttribute("orderList", orderList.getData());
        model.addAttribute("searchVo", searchVo);
        model.addAttribute("page", orderList);
        return "order/orderList";
    }

    @GetMapping("/get/{id}")
    public String getOrderById(Model model, @PathVariable Integer id) {
        Order order = orderService.getOrderById(id);
        model.addAttribute("order", order);
        return "order/orderManage";
    }

    @RequestMapping("/update")
    @ResponseBody
    public Integer updateOrder(@RequestBody Order order) {
        return orderService.update(order);
    }

    @RequestMapping("/save")
    @ResponseBody
    public Integer saveOrder(@RequestBody Order order) {
        return orderService.save(order);
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public Integer saveOrder(@PathVariable Integer id) {
        return orderService.delete(id);
    }
}

