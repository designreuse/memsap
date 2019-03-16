package com.we.sdk.memsap.service.impl;

import com.we.sdk.memsap.bean.Address;
import com.we.sdk.memsap.dao.AddressDao;
import com.we.sdk.memsap.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressDao addressDao;

    @Override
    public Integer save(Address address) {
        return addressDao.save(address);
    }

    @Override
    public Integer delete(Integer id) {
        return addressDao.delete(id);
    }

    @Override
    public Integer update(Address address) {
        return addressDao.update(address);
    }

    @Override
    public Address getAddressById(Integer id){
        return addressDao.getAddressById(id);
    }

    @Override
    public List<Address> getAddressList() {
        return addressDao.getAddressList();
    }

    @Override
    public List<Address> getAddressByPhoneNumber(String phoneNumber) {
        return addressDao.getAddressByPhoneNumber(phoneNumber);
    }


}
