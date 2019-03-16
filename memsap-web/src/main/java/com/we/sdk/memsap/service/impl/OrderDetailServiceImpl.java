package com.we.sdk.memsap.service.impl;//package com.we.sdk.memsap.service.impl;
//
//import com.we.sdk.memsap.base.vo.Page;
//import com.we.sdk.memsap.base.vo.SearchVo;
//import OrderDetail;
//import com.we.sdk.memsap.feign.OrderDetailFeignClient;
//import com.we.sdk.memsap.service.OrderDetailService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class OrderDetailServiceImpl implements OrderDetailService {
//
//    @Autowired
//    private OrderDetailFeignClient orderDetailFeignClient;
//
//    @Override
//    public Integer save(OrderDetail orderDetail) {
//        return orderDetailFeignClient.save(orderDetail).getData();
//    }
//
//    @Override
//    public Integer delete(Integer id) {
//        return orderDetailFeignClient.delete(id).getData();
//    }
//
//    @Override
//    public Integer update(OrderDetail orderDetail) {
//        return orderDetailFeignClient.update(orderDetail).getData();
//    }
//
//    @Override
//    public OrderDetail getOrderDetailById(Integer id){
//        return orderDetailFeignClient.getOrderDetailById(id).getData();
//    }
//
//    @Override
//    public List<OrderDetail> getOrderDetailListByPage(SearchVo searchVo, Page page) {
//        Integer count = orderDetailFeignClient.getOrderDetailListCount(searchVo).getData();
//        page.setTotalCount(count);
//        return orderDetailFeignClient.getOrderDetailListByPage(searchVo, page.getPn(),page.getPageSize()).getData();
//    }
//
//    @Override
//    public Integer getOrderDetailListCount(SearchVo searchVo) {
//        return orderDetailFeignClient.getOrderDetailListCount(searchVo).getData();
//    }
//
//}
