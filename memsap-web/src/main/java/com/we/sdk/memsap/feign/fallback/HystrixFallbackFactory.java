package com.we.sdk.memsap.feign.fallback;

import com.we.sdk.memsap.base.result.RestResult;
import com.we.sdk.memsap.base.vo.Page;
import com.we.sdk.memsap.base.vo.SearchVo;
import com.we.sdk.memsap.bean.*;
import com.we.sdk.memsap.feign.PhoneFeignClient;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HystrixFallbackFactory implements FallbackFactory<PhoneFeignClient> {
    private static final Logger log = LoggerFactory.getLogger(HystrixFallbackFactory.class);
    @Override
    public PhoneFeignClient create(Throwable throwable) {
        log.info("回退原因：{}", throwable.getMessage());
        return new PhoneFeignClient() {
            @Override
            public RestResult<Integer> save(Phone phone) {
                return null;
            }

            @Override
            public RestResult<Integer> delete(Integer id) {
                return null;
            }

            @Override
            public RestResult<Integer> update(Phone phone) {
                return null;
            }

            @Override
            public RestResult<Page<Phone>> getPhoneListByConditions(SearchVo searchVo) {
                return null;
            }


            @Override
            public RestResult<Phone> getPhoneById(Integer id) {
                return null;
            }

            @Override
            public RestResult<List<Phone>> getPhoneList() {
                return null;
            }

            @Override
            public RestResult<List<RepairPrice>> getFaultRepairPriceByCondition(RepairPrice repairPrice) {
                return null;
            }

            @Override
            public RestResult<List<Fault>> getFaultList() {
                return null;
            }

            @Override
            public RestResult<List<Repair>> getRepairList() {
                return null;
            }

            @Override
            public RestResult<List<Brand>> getBrandList() {
                return null;
            }
        };
    }
}
