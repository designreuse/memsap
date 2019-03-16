package com.we.sdk.memsap.service.impl;//package com.we.sdk.memsap.service.impl;
//
//import com.we.sdk.memsap.base.vo.SearchVo;
//import Order;
//import com.we.sdk.memsap.base.vo.Page;
//import com.we.sdk.memsap.feign.OrderFeignClient;
//import com.we.sdk.memsap.service.OrderService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class OrderServiceImpl implements OrderService {
//
//    private final OrderFeignClient orderFeignClient;
//
//    @Override
//    public Integer save(Order order) {
//        return orderFeignClient.save(order).getData();
//    }
//
//    @Override
//    public Integer delete(Integer id) {
//        return orderFeignClient.delete(id).getData();
//    }
//
//    @Override
//    public Integer update(Order order) {
//        return orderFeignClient.update(order).getData();
//    }
//
//    @Override
//    public Order getOrderById(Integer id) {
//        return orderFeignClient.getOrderById(id).getData();
//    }
//
//    @Override
//    public List<Order> getOrderListByCondition(SearchVo searchVo, Page page) {
//        return orderFeignClient.getOrderListByCondition(searchVo,page).getData();
//    }
//
//}
