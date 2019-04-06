package com.we.sdk.memsap.service;

import com.we.sdk.memsap.bean.RepairPrice;

import java.util.List;

/**
 * @author sudk
 * @date 2019-01-19 15:31:05
 */
public interface FaultRepairService {

    Integer save(RepairPrice repairPrice);

    Integer batchSave(List<RepairPrice> repairPriceList);

    Integer delete(RepairPrice repairPrice);

    Integer update(RepairPrice repairPrice);

    Integer batchUpdate(List<RepairPrice> repairPriceList);

    Integer batchEdit(List<RepairPrice> repairPriceList);

    List<RepairPrice> getFaultRepairPriceByCondition(RepairPrice repairPrice);

//    List<RepairPrice> getFaultRepairPriceList();

}

