package com.we.sdk.memsap.service.impl;

import com.we.sdk.memsap.bean.Repair;
import com.we.sdk.memsap.service.RepairService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

@RequiredArgsConstructor
public class RepairServiceImpl implements RepairService {

    private final com.we.sdk.memsap.dao.RepairDao RepairDao;

    @Override
    public Integer save(Repair Repair) {
        return RepairDao.save(Repair);
    }

    @Override
    public Integer delete(Integer id) {
        return RepairDao.delete(id);
    }

    @Override
    public Integer update(Repair Repair) {
        return RepairDao.update(Repair);
    }

    @Override
    public Repair getRepairById(Integer id){
        return RepairDao.getRepairById(id);
    }

    @Override
    public List<Repair> getRepairList() {
        return RepairDao.getRepairList();
    }


}
