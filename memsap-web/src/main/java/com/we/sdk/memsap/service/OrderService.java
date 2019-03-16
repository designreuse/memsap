package com.we.sdk.memsap.service;//package com.we.sdk.memsap.service;
//
//
//import com.we.sdk.memsap.base.vo.Page;
//import com.we.sdk.memsap.base.vo.SearchVo;
//import Order;
//
//import java.util.List;
//
///**
// * @author SDK
// * @date 2019-02-25 12:31:17
// */
//public interface OrderService {
//
//    /**
//     * 新增Order
//     *
//     * @param order 新增的对象
//     * @return 新增成功条数
//     */
//    Integer save(Order order);
//
//    /**
//     * 根据id删除Order
//     *
//     * @param id id
//     * @return 删除成功条数
//     */
//    Integer delete(Integer id);
//
//    /**
//     * 修改Order
//     *
//     * @param order 修改的对象
//     * @return 修改成功条数
//     */
//    Integer update(Order order);
//
//    /**
//     * 根据id查询Order
//     *
//     * @param id id
//     * @return Order对象
//     */
//    Order getOrderById(Integer id);
//
//    /**
//     * 条件查询Order
//     *
//     * @param searchVo 封装的搜索对象
//     * @return List
//     */
//    List<Order> getOrderListByCondition(SearchVo searchVo, Page page);
//
//}
//
