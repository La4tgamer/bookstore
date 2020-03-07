package com.whu.bookstore.service;

import com.whu.bookstore.entity.Address;

import java.util.List;

/**
 * @author ：qx.w
 * @description：地址服务层接口
 * @modified By：
 * @since ：Created in 2020/3/7 11:03
 */
public interface IAddressesService {
    /**
     * 通过用户名得到购物车记录
     * @param username
     * @return
     */
    List<Address> getByUser(String username);

    /**
     * 新增到购物车
     * @param uuid
     * @param username
     * @param name
     * @param phone
     * @param location
     * @return
     */
    int insertAddress(String uuid, String username, String name, String phone, String location);

    /**
     * 修改购物车里面的书籍
     * @param uuid
     * @param username
     * @param name
     * @param phone
     * @param location
     * @return
     */
    int updateAddress(String uuid, String username, String name, String phone, String location);

    /**
     * 从购物车删除这个商品
     * @param uuid
     * @return
     */
    int deleteAddress(String uuid);

}
