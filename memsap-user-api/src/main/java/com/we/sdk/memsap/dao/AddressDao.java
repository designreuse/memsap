package com.we.sdk.memsap.dao;

import com.we.sdk.memsap.bean.Address;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author SDK
 * @date 2019-02-23 17:20:52
 */
@Mapper
public interface AddressDao {

    /**
     * 新增Address
     *
     * @param address 新增的对象
     * @return 新增成功条数
     */
    Integer save(Address address);

    /**
     * 根据id删除Address
     *
     * @param id id
     * @return 删除成功条数
     */
    Integer delete(@Param("id") Integer id);

    /**
     * 修改Address
     *
     * @param address 修改的对象
     * @return 修改成功条数
     */
    Integer update(Address address);

    /**
     * 根据id查询UserAddress
     *
     * @param id id
     * @return UserAddress对象
     */
    Address getAddressById(@Param("id") Integer id);

    /**
     * 查询全部收货地址
     *
     * @return List
     */
    List<Address> getAddressList();

    /**
     * 查询全部收货地址
     *
     * @return List
     */
    List<Address> getAddressByPhoneNumber(@Param("phoneNumber") String phoneNumber);
}
