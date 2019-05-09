package com.we.sdk.memsap.feign.fallback;

import com.we.sdk.memsap.base.result.RestResult;
import com.we.sdk.memsap.base.vo.Page;
import com.we.sdk.memsap.base.vo.SearchVo;
import com.we.sdk.memsap.bean.Order;
import com.we.sdk.memsap.bean.OrderDetail;
import com.we.sdk.memsap.feign.OrderFeignClient;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HystrixFallbackFactory implements FallbackFactory<OrderFeignClient> {
    private static final Logger log = LoggerFactory.getLogger(HystrixFallbackFactory.class);


    @Override
    public OrderFeignClient create(Throwable throwable) {
        log.info("回退原因：{}", throwable.getMessage());
        return new OrderFeignClient() {

            @Override
            public RestResult<Integer> save(Order order) {
                return null;
            }

            @Override
            public RestResult<Page<Order>> getOrderListByCondition(SearchVo searchVo) {
                return null;
            }

            @Override
            public RestResult<Order> getOrderById(Integer id) {
                return null;
            }

            @Override
            public RestResult<List<OrderDetail>> getOrderDetailsByOrderIds(List<Integer> orderIds) {
                return null;
            }

            @Override
            public RestResult<Integer> save(List<OrderDetail> orderDetailList) {
                return null;
            }
        };
    }
}
