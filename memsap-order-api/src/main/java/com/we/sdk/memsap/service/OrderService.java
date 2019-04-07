package com.we.sdk.memsap.service;


import com.we.sdk.memsap.base.vo.SearchVo;
import com.we.sdk.memsap.bean.Order;
import com.we.sdk.memsap.bean.OrderDetail;
import com.we.sdk.memsap.base.vo.Page;

import java.util.List;

/**
 * @author SDK
 * @date 2019-02-25 12:31:17
 */
public interface OrderService {

    Integer save(Order order);

    Integer delete(Integer id);

    Integer update(Order order);

    Order getOrderById(Integer id);

    Page<Order> getOrderListByCondition(SearchVo searchVo, Page page);

    Integer getOrderListCount(SearchVo searchVo);

    Integer saveOrderDetail(List<OrderDetail> orderDetails);

    Integer deleteOrderDetail(Integer id);

    Integer batchDeleteDetailByOrderIds(List<Integer> orderIds);

    OrderDetail getOrderDetailById(Integer id);

    List<OrderDetail> getOrderDetailsByOrderIds(List<Integer> orderIds);

}

