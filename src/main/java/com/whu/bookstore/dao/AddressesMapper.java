package com.whu.bookstore.dao;

import com.whu.bookstore.entity.Address;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ：qx.w
 * @description：地址dao层
 * @modified By：
 * @since ：Created in 2020/3/7 11:01
 */
@Mapper
public interface AddressesMapper {
    /**
     * 通过用户名查找
     * @param username
     * @return
     */
    List<Address> selectByUser(@Param("username") String username);

    /**
     * 新增一个地址在地址栏中
     * @param address
     * @return
     */
    int insertAddress(Address address);

    /**
     * 修改地址栏中一个地址
     * @param address
     * @return
     */
    int updateAddress(Address address);


    /**
     * 删除地址栏中一个地址
     * @param uuid
     * @return
     */
    int deleteAddress(@Param("uuid") String uuid);


}
