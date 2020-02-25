package com.whu.bookstore.service;

import com.whu.bookstore.entity.ShoppingCart;

import java.util.List;

/**
 * @author ：qx.w
 * @description：
 * @modified By：
 * @since ：Created in 2020/2/25 11:12
 */
public interface IShoppingCartService {
    /**
     * 通过用户名得到购物车记录
     * @param username
     * @return
     */
    List<ShoppingCart> getByUser(String username);
}
