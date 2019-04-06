package com.we.sdk.memsap.dao;

import com.we.sdk.memsap.base.vo.Page;
import com.we.sdk.memsap.bean.AddressDic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author SDK
 * @date 2019-02-23 17:21:29
 */
@Mapper
public interface AddressDicDao {

    /**
     * 新增AddressDic
     *
     * @param addressDic 新增的对象
     * @return 新增成功条数
     */
    Integer save(AddressDic addressDic);

    /**
     * 根据id删除AddressDic
     *
     * @param id id
     * @return 删除成功条数
     */
    Integer delete(@Param("id") Integer id);

    /**
     * 修改AddressDic
     *
     * @param addressDic 修改的对象
     * @return 修改成功条数
     */
    Integer update(AddressDic addressDic);

    /**
     * 根据id查询AddressDic
     *
     * @param id id
     * @return AddressDic对象
     */
    AddressDic getAddressDicById(@Param("id") Integer id);

    /**
     * 分页查询AddressDic
     *
     * @param address 搜索地址
     * @return List
     */
    List<AddressDic> getAddressDicListByCondition(@Param("address") String address, @Param("page") Page page);

    /**
     * 查询AddressDic数量
     *
     * @param address 封装的搜索对象
     * @return 数量
     */
    Integer getAddressDicListCount(@Param("address") String address);

    /**
     * 根据address查询AddressDic
     *
     * @param address
     * @return AddressDic对象
     */
    AddressDic getAddressDicByAddress(String address);

    /**根据父亲id查询AddressDic
     * @param parentId
     * @return
     */
    List<AddressDic> getAddressDicByParentId(Integer parentId);
}
