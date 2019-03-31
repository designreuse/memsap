package com.we.sdk.memsap.service.impl;

import com.we.sdk.memsap.dao.PhoneDao;
import com.we.sdk.memsap.base.vo.Page;
import com.we.sdk.memsap.base.vo.SearchVo;
import com.we.sdk.memsap.bean.Phone;
import com.we.sdk.memsap.service.PhoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PhoneServiceImpl implements PhoneService {

    private static final String DEFAULT_COLOR = "黑色";

    private final PhoneDao phoneDao;

    @Override
    public Integer save(Phone phone) {
        if (phone.getPhoneColors()==null){
            phone.setPhoneColors(DEFAULT_COLOR);
        }
        return phoneDao.save(phone);
    }

    @Override
    public Integer delete(Integer id) {
        return phoneDao.delete(id);
    }

    @Override
    public Integer update(Phone phone) {
        return phoneDao.update(phone);
    }

    @Override
    public Phone getPhoneById(Integer id) {
        return phoneDao.getPhoneById(id);
    }

    @Override
    public Page getPhoneListByConditions(SearchVo searchVo, Page page) {
        Integer count = getPhoneListCount(searchVo);
        page.setTotalCount(count);
        page.calculate();
        page.setData(phoneDao.getPhoneListByConditions(searchVo, page));
        return page;
    }

    @Override
    public Integer getPhoneListCount(SearchVo searchVo) {
        return phoneDao.getPhoneListCount(searchVo);
    }

    @Override
    public List<Phone> getPhoneList() {
        return phoneDao.getPhoneList();
    }

}
