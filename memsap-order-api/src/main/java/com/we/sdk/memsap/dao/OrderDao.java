package com.we.sdk.memsap.dao;

import com.we.sdk.memsap.base.vo.Page;
import com.we.sdk.memsap.base.vo.SearchVo;
import com.we.sdk.memsap.bean.Order;
import com.we.sdk.memsap.bean.OrderDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author SDK
 * @date 2019-02-25 12:31:17
 */
@Mapper
public interface OrderDao {

    /**
     * 新增Order
     *
     * @param order 新增的对象
     * @return 新增成功条数
     */
    Integer save(Order order);

    /**
     * 根据id删除Order
     *
     * @param id id
     * @return 删除成功条数
     */
    Integer delete(@Param("id") Integer id);

    /**
     * 修改Order
     *
     * @param order 修改的对象
     * @return 修改成功条数
     */
    Integer update(Order order);

    /**
     * 根据id查询Order
     *
     * @param id id
     * @return Order对象
     */
    Order getOrderById(@Param("id") Integer id);

    /**
     * 条件查询Order
     *
     * @param searchVo 封装的搜索对象
     * @return List
     */
    List<Order> getOrderListByCondition(@Param("searchVo") SearchVo searchVo, @Param("page") Page page);

    /**
     * 查询Order数量
     *
     * @param searchVo 封装的搜索对象
     * @return 数量
     */
    Integer getOrderListCount(@Param("searchVo") SearchVo searchVo);



    /**
     * 批量插入订单详情
     *
     * @param orderDetails
     * @return
     */
    Integer saveOrderDetail(@Param("orderDetails") List<OrderDetail> orderDetails);


    /**
     * 删除订单详情
     *
     * @param id
     * @return
     */
    Integer deleteOrderDetail(@Param("id") Integer id);


    /**
     * 通过订单号批量删除订单详情
     *
     * @param orderIds
     * @return
     */
    Integer batchDeleteDetailByOrderIds(@Param("orderIds") List<Integer> orderIds);


    /**
     * 根据id查询OrderDetail
     *
     * @param id
     * @return
     */
    OrderDetail getOrderDetailById(@Param("id") Integer id);


    /**
     * 通过多个订单号查询多个订单详情
     *
     * @param orderIds
     * @return
     */
    List<OrderDetail> getOrderDetailsByOrderIds(@Param("orderIds") List<Integer> orderIds);

}
