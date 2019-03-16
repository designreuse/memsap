package com.we.sdk.memsap.service;//package com.we.sdk.memsap.service;
//
//
//import com.we.sdk.memsap.base.vo.Page;
//import com.we.sdk.memsap.base.vo.SearchVo;
//import OrderDetail;
//
//import java.util.List;
//
///**
// *
// *
// * @author ${author}
// * @date 2019-02-25 12:31:22
// */
//public interface OrderDetailService {
//
//    /**
//     *  新增OrderDetail
//     * @param orderDetail 新增的对象
//     * @return 新增成功条数
//     */
//    Integer save(OrderDetail orderDetail);
//
//    /**
//     *  根据id删除OrderDetail
//     * @param id id
//     * @return 删除成功条数
//     */
//    Integer delete(Integer id);
//
//    /**
//     *  修改OrderDetail
//     * @param orderDetail 修改的对象
//     * @return 修改成功条数
//     */
//    Integer update(OrderDetail orderDetail);
//
//    /**
//     *  根据id查询OrderDetail
//     * @param id id
//     * @return OrderDetail对象
//     */
//        OrderDetail getOrderDetailById(Integer id);
//
//    /**
//     *  分页查询OrderDetail
//     * @param searchVo 封装的搜索对象
//     * @return List
//     */
//    List<OrderDetail> getOrderDetailListByPage(SearchVo searchVo, Page page);
//
//    /**
//     *  分页查询OrderDetail数量
//     * @param searchVo 封装的搜索对象
//     * @return 数量
//     */
//    Integer getOrderDetailListCount(SearchVo searchVo);
//
//}
//
