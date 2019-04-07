package com.we.sdk.memsap.feign;//package com.we.sdk.memsap.feign;

import com.we.sdk.memsap.base.result.RestResult;
import com.we.sdk.memsap.base.vo.SearchVo;
import com.we.sdk.memsap.bean.OrderDetail;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//@FeignClient(name = "memsap-phone-apir")
public interface OrderDetailFeignClient {
    /*新增*/
    @PostMapping(value = "/memsap-phone-api/phone/orderdetail/save")
    RestResult<Integer> save(@RequestBody OrderDetail orderDetail);

    /*删除*/
    @PostMapping(value = "/memsap-phone-api/phone/orderdetail/delete")
    RestResult<Integer> delete(@RequestParam("id") Integer id);

    /*修改*/
    @PostMapping(value = "/memsap-phone-api/phone/orderdetail/update")
    RestResult<Integer> update(@RequestBody OrderDetail orderDetail);

    /*分页查询列表*/
    @PostMapping(value = "/memsap-phone-api/phone/orderdetail/getOrderDetailListByPage")
    RestResult<List<OrderDetail>> getOrderDetailListByPage(@RequestBody SearchVo searchVo, @RequestParam Integer pn, @RequestParam Integer pageSize);

    /*根据总数*/
    @PostMapping(value = "/memsap-phone-api/phone/orderdetail/getOrderDetailListCount")
    RestResult<Integer> getOrderDetailListCount(@RequestBody SearchVo searchVo);

    /*根据id获取OrderDetail*/
    @PostMapping(value = "/memsap-phone-api/phone/orderdetail/getOrderDetailById")
    RestResult<OrderDetail> getOrderDetailById(@RequestParam("id") Integer id);
}
