package com.we.sdk.memsap.dao;

import com.we.sdk.memsap.bean.RepairPrice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author sudk
 * @date 2019-01-19 15:31:05
 */
@Mapper
public interface FaultRepairDao {

    /**
     * 新增RepairPrice
     *
     * @param repairPrice 新增的对象
     * @return 新增成功条数
     */
    Integer save(RepairPrice repairPrice);

    /**
     * 批量新增RepairPrice
     *
     * @param repairPriceList 批量新增的对象
     * @return 新增成功条数
     */
    Integer batchSave(@Param("list") List<RepairPrice> repairPriceList);

    /**
     * 根据对象删除RepairPrice
     *
     * @param repairPrice repairPrice
     * @return 删除成功条数
     */
    Integer delete(RepairPrice repairPrice);

    /**
     * 修改RepairPrice
     *
     * @param repairPrice 修改的对象
     * @return 修改成功条数
     */
    Integer update(RepairPrice repairPrice);

    /**
     * 批量修改RepairPrice
     *
     * @param repairPriceList 批量修改的对象
     * @return 修改成功条数
     */
    Integer batchUpdate(@Param("list") List<RepairPrice> repairPriceList, @Param("phoneId") Integer phoneId);

    /**
     * 根据 RepairPrice 对象获取对应的维修价格
     *
     * @param repairPrice
     * @return
     */
    List<RepairPrice> getFaultRepairPriceByCondition(RepairPrice repairPrice);

//    /**
//     *  查询全部维修价钱
//     * @return List
//     */
//    List<RepairPrice> getFaultRepairPriceList();

}
