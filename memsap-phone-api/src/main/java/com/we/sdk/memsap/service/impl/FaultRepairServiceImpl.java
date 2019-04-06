package com.we.sdk.memsap.service.impl;

import com.we.sdk.memsap.bean.RepairPrice;
import com.we.sdk.memsap.dao.FaultRepairDao;
import com.we.sdk.memsap.service.FaultRepairService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    public Integer batchSave(List<RepairPrice> repairPriceList) {
        return faultRepairDao.batchSave(repairPriceList);
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
    public Integer batchUpdate(List<RepairPrice> repairPriceList) {
        Integer phoneId = repairPriceList.get(0).getPhoneId();
        return faultRepairDao.batchUpdate(repairPriceList, phoneId);
    }

    @Override
    public Integer batchEdit(List<RepairPrice> repairPriceList) {
        List<RepairPrice> updateRepairPrice = new ArrayList<>();
        List<RepairPrice> saveRepairPrice = new ArrayList<>();
        for (RepairPrice repairPrice : repairPriceList) {
            if (getFaultRepairPriceByCondition(repairPrice).isEmpty()) {
                saveRepairPrice.add(repairPrice);
            } else {
                updateRepairPrice.add(repairPrice);
            }
        }
        Integer updateResult = 0;
        Integer saveResult = 0;
        if (!updateRepairPrice.isEmpty()) {
            updateResult = this.batchUpdate(updateRepairPrice);
        }
        if (!saveRepairPrice.isEmpty()) {
            saveResult = this.batchSave(saveRepairPrice);
        }
        return updateResult + saveResult;
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
