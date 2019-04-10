package com.we.sdk.memsap.service;

import com.we.sdk.memsap.bean.Address;

import java.util.List;

/**
 * @author SDK
 * @date 2019-02-23 17:20:52
 */
public interface AddressService {

    Integer saveAddress(Address address);

    Integer deleteAddress(Integer id);

    Integer updateAddress(Address address);

    Address getAddressById(Integer id);

    List<Address> getAddressList();

    List<Address> getAddressByPhoneNumber(String phoneNumber);

    ///////////////// AddressDic

 /*   Integer save(AddressDic addressDic);

    Integer deleteAddressDic(Integer id);

    Integer update(AddressDic addressDic);

    List<AddressDic> getAddressDicByParentId(Integer parentId);

    Page<AddressDic> getAddressDicListByCondition(String address, Page<AddressDic> page);*/
}

