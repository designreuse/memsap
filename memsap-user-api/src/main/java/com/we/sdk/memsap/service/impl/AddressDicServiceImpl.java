package com.we.sdk.memsap.service.impl;

import com.we.sdk.memsap.base.vo.Page;
import com.we.sdk.memsap.bean.AddressDic;
import com.we.sdk.memsap.dao.AddressDicDao;
import com.we.sdk.memsap.service.AddressDicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AddressDicServiceImpl implements AddressDicService {

    private final AddressDicDao addressDicDao;

    @Override
    public Integer save(AddressDic addressDic) {
        return addressDicDao.save(addressDic);
    }

    @Override
    public Integer delete(Integer id) {
        return addressDicDao.delete(id);
    }

    @Override
    public Integer update(AddressDic addressDic) {
        return addressDicDao.update(addressDic);
    }

    @Override
    public AddressDic getAddressDicById(Integer id) {
        return addressDicDao.getAddressDicById(id);
    }

    @Override
    public AddressDic getAddressDicByAddress(String address) {
        return addressDicDao.getAddressDicByAddress(address);
    }

    @Override
    public Page<AddressDic> getAddressDicListByCondition(String address, Page<AddressDic> page) {
        Integer count = addressDicDao.getAddressDicListCount(address);
        page.setTotalCount(count);
        page.setData(addressDicDao.getAddressDicListByCondition(address, page));
        return page;
    }

    @Override
    public Integer getAddressDicListCount(String address) {
        return addressDicDao.getAddressDicListCount(address);
    }

    @Override
    public List<AddressDic> getAddressDicByParentId(Integer parentId) {
        return addressDicDao.getAddressDicByParentId(parentId);
    }

}
