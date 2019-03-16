package com.we.sdk.memsap.service;


import com.we.sdk.memsap.base.vo.Page;
import com.we.sdk.memsap.bean.AddressDic;

import java.util.List;

/**
 * 
 *
 * @author SDK
 * @date 2019-02-23 17:21:29
 */
public interface AddressDicService {

    Integer save(AddressDic addressDic);

    Integer delete(Integer id);

    Integer update(AddressDic addressDic);

    AddressDic getAddressDicById(Integer id);

    AddressDic getAddressDicByAddress(String address);

    Page<AddressDic> getAddressDicListByCondition(String address,Page<AddressDic> page);

    Integer getAddressDicListCount(String address);

   List<AddressDic> getAddressDicByParentId(Integer parentId);

}

