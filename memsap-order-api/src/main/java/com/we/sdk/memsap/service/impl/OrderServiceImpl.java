package com.we.sdk.memsap.service.impl;

import com.we.sdk.memsap.base.vo.Page;
import com.we.sdk.memsap.base.vo.SearchVo;
import com.we.sdk.memsap.bean.Order;
import com.we.sdk.memsap.bean.OrderDetail;
import com.we.sdk.memsap.dao.OrderDao;
import com.we.sdk.memsap.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderDao orderDao;

    @Override
    public Integer save(Order order) {
        return orderDao.save(order);
    }

    @Override
    public Integer delete(Integer id) {
        return orderDao.delete(id);
    }

    @Override
    public Integer update(Order order) {
        return orderDao.update(order);
    }

    @Override
    public Order getOrderById(Integer id) {
        return orderDao.getOrderById(id);
    }

    @Override
    public Page<Order> getOrderListByCondition(SearchVo searchVo, Page page) {
        Integer count = orderDao.getOrderListCount(searchVo);
        page.setTotalCount(count);
        page.calculate();
        page.setData(orderDao.getOrderListByCondition(searchVo, page));
        return page;
    }

    @Override
    public Integer getOrderListCount(SearchVo searchVo) {
        return orderDao.getOrderListCount(searchVo);
    }

    @Override
    public Integer saveOrderDetail(List<OrderDetail> orderDetails) {
        return orderDao.saveOrderDetail(orderDetails);
    }

    @Override
    public Integer deleteOrderDetail(Integer id) {
        return orderDao.deleteOrderDetail(id);
    }

    @Override
    public Integer batchDeleteDetailByOrderIds(List<Integer> orderIds) {
        return orderDao.batchDeleteDetailByOrderIds(orderIds);
    }

    @Override
    public OrderDetail getOrderDetailById(Integer id) {
        return orderDao.getOrderDetailById(id);
    }

    @Override
    public List<OrderDetail> getOrderDetailsByOrderIds(List<Integer> orderIds) {
        return orderDao.getOrderDetailsByOrderIds(orderIds);
    }

}
