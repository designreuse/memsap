package com.we.sdk.memsap.service.impl;

import com.we.sdk.memsap.dao.FaultDao;
import com.we.sdk.memsap.bean.Fault;
import com.we.sdk.memsap.service.FaultService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FaultServiceImpl implements FaultService {

    private final FaultDao faultDao;

    @Override
    public Integer save(Fault fault) {
        return faultDao.save(fault);
    }

    @Override
    public Integer delete(Integer id) {
        return faultDao.delete(id);
    }

    @Override
    public Integer update(Fault fault) {
        return faultDao.update(fault);
    }

    @Override
    public Fault getFaultById(Integer id){
        return faultDao.getFaultById(id);
    }

    @Override
    public List<Fault> getFaultList() {
        return faultDao.getFaultList();
    }

}
