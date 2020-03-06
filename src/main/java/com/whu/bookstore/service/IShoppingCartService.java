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

    /**
     * 新增到购物车
     * @param uuid
     * @param username
     * @param bookId
     * @param num
     * @param singlePrice
     * @return
     */
    int insertBook(String uuid, String username, String bookId, int num, double singlePrice, String image);

    /**
     * 修改购物车里面的书籍
     * @param uuid
     * @param username
     * @param bookId
     * @param num
     * @param singlePrice
     * @return
     */
    int updateBook(String uuid, String username, String bookId, int num, double singlePrice, String image);

    /**
     * 修改购物车里的书籍数量
     * @param uuid
     * @param num
     * @return
     */
    int updateBookNum(String uuid, int num);

    /**
     * 从购物车删除这个商品
     * @param uuid
     * @return
     */
    int deleteBook(String uuid);

    /**
     * 清空购物车
     * @param username
     * @return
     */
    int deleteAllBook(String username);
}
