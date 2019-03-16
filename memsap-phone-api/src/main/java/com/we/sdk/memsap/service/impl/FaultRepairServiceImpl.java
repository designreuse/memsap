package com.we.sdk.memsap.service.impl;

import com.we.sdk.memsap.bean.RepairPrice;
import com.we.sdk.memsap.dao.FaultRepairDao;
import com.we.sdk.memsap.service.FaultRepairService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class FaultRepairServiceImpl implements FaultRepairService {

    private final FaultRepairDao faultRepairDao;


    @Override
    public Integer save(RepairPrice repairPrice) {
        return faultRepairDao.save(repairPrice);
    }

    @Override
    public Integer delete(RepairPrice repairPrice) {
        return faultRepairDao.delete(repairPrice);
    }

    @Override
    public Integer update(RepairPrice repairPrice) {
        return faultRepairDao.update(repairPrice);
    }

    @Override
    public List<RepairPrice> getFaultRepairPriceByCondition(RepairPrice repairPrice) {
        return faultRepairDao.getFaultRepairPriceByCondition(repairPrice);
    }

  /*  @Override
    public List<RepairPrice> getFaultRepairPriceList() {
        return faultRepairDao.getFaultRepairPriceList();
    }*/
}
