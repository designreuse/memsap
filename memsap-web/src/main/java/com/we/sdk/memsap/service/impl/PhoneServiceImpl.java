package com.we.sdk.memsap.service.impl;

import com.we.sdk.memsap.base.result.RestResult;
import com.we.sdk.memsap.base.vo.Page;
import com.we.sdk.memsap.base.vo.SearchVo;
import com.we.sdk.memsap.bean.*;
import com.we.sdk.memsap.feign.PhoneFeignClient;
import com.we.sdk.memsap.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PhoneServiceImpl implements PhoneService {

    @Autowired
    private PhoneFeignClient phoneFeignClient;

    @Override
    public Integer save(Phone phone) {
        RestResult<Integer> result = phoneFeignClient.save(phone);
        if (result == null || result.getCode() != 0) {
            return null;
        }
        return result.getData();
    }

    @Override
    public Integer delete(Integer id) {
        RestResult<Integer> result = phoneFeignClient.delete(id);
        if (result == null || result.getCode() != 0) {
            return null;
        }
        return result.getData();

    }

    @Override
    public Integer update(Phone phone) {
        List<String> phoneColorList = phone.getPhoneColorList();
        String color = "";
        for (String phoneColor : phoneColorList) {
            color += phoneColor + ",";
        }
        color.substring(0, color.length() - 1);
        phone.setPhoneColors(color);
        RestResult<Integer> result = phoneFeignClient.update(phone);
        if (result == null || result.getCode() != 0) {
            return null;
        }
        return result.getData();
    }

    @Override
    public Phone getPhoneById(Integer id) {
        RestResult<Phone> result = phoneFeignClient.getPhoneById(id);
        if (result == null || result.getCode() != 0) {
            return new Phone();
        }
        return result.getData();
    }

    @Override
    public Page<Phone> getPhoneListByConditions(SearchVo searchVo, Page page) {
        searchVo.setPage(page);
        RestResult<Page<Phone>> result = phoneFeignClient.getPhoneListByConditions(searchVo);
        return result.getData();
    }

    @Override
    public List<Phone> getPhoneList() {
        RestResult<List<Phone>> result = phoneFeignClient.getPhoneList();
        if (result == null || result.getCode() != 0) {
            return new ArrayList<>();
        }
        for (Phone phone : result.getData()) {
            phone.setPhoneColorList(Arrays.asList(phone.getPhoneColors().split(",")));
        }
        return result.getData();
    }

    @Override
    public List<RepairPrice> getFaultRepairPriceByCondition(RepairPrice repairPrice) {
        RestResult<List<RepairPrice>> result = phoneFeignClient.getFaultRepairPriceByCondition(repairPrice);
        if (result == null || result.getCode() != 0) {
            return new ArrayList<>();
        }
        return result.getData();
    }

    @Override
    public List<Fault> getFaultList() {
        RestResult<List<Fault>> result = phoneFeignClient.getFaultList();
        if (result == null || result.getCode() != 0) {
            return new ArrayList<>();
        }
        return result.getData();
    }

    @Override
    public List<Repair> getRepairList() {
        RestResult<List<Repair>> result = phoneFeignClient.getRepairList();
        if (result == null || result.getCode() != 0) {
            return new ArrayList<>();
        }
        return result.getData();
    }

    @Override
    public List<Brand> getBrandList() {
        RestResult<List<Brand>> result = phoneFeignClient.getBrandList();
        if (result == null || result.getCode() != 0) {
            return new ArrayList<>();
        }
        return result.getData();
    }

    @Override
    public Integer batchEdit(List<RepairPrice> repairPriceList) {
        return phoneFeignClient.batchEdit(repairPriceList).getData();
    }

}
