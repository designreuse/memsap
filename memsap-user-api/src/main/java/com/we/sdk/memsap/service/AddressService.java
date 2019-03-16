package com.we.sdk.memsap.service;

import com.we.sdk.memsap.bean.Address;

import java.util.List;

/**
 * @author SDK
 * @date 2019-02-23 17:20:52
 */
public interface AddressService {

    Integer save(Address address);

    Integer delete(Integer id);

    Integer update(Address address);

    Address getAddressById(Integer id);

    List<Address> getAddressList();

    List<Address> getAddressByPhoneNumber(String phoneNumber);
}

