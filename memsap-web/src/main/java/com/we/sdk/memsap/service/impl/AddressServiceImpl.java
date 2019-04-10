package com.we.sdk.memsap.service.impl;

import com.we.sdk.memsap.bean.Address;
import com.we.sdk.memsap.feign.UserFeignClient;
import com.we.sdk.memsap.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private UserFeignClient addressFeignClient;

    @Override
    public Integer saveAddress(Address address) {
        return addressFeignClient.saveAddress(address).getData();
    }

    @Override
    public Integer deleteAddress(Integer id) {
        return addressFeignClient.deleteAddress(id).getData();
    }

    @Override
    public Integer updateAddress(Address address) {
        return  addressFeignClient.updateAddress(address).getData();
    }

    @Override
    public Address getAddressById(Integer id) {
        return addressFeignClient.getAddressById(id).getData();
    }

    @Override
    public List<Address> getAddressList() {
        return addressFeignClient.getAddressList().getData();
    }

    @Override
    public List<Address> getAddressByPhoneNumber(String phoneNumber) {
        return addressFeignClient.getAddressByPhoneNumber(phoneNumber).getData();
    }

    /////////////////// AddressDic

/*    @Override
    public Integer save(AddressDic addressDic) {
        return addressFeignClient.saveAddressDic(addressDic).getData();
    }

    @Override
    public Integer deleteAddressDic(Integer id) {
        return addressFeignClient.deleteAddressDic(id).getData();
    }

    @Override
    public Integer update(AddressDic addressDic) {
        return addressFeignClient.updateAddressDic(addressDic).getData();
    }

    @Override
    public List<AddressDic> getAddressDicByParentId(Integer parentId) {
        return addressFeignClient.getAddressDicByParentId(parentId).getData();
    }

    @Override
    public Page<AddressDic> getAddressDicListByCondition(String address, Page<AddressDic> page) {
        return addressFeignClient.getAddressDicListByCondition(address, page).getData();
    }*/


}
