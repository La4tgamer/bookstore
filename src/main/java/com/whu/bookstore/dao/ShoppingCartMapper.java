package com.whu.bookstore.dao;

import com.whu.bookstore.entity.ShoppingCart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author ：qx.w
 * @description：
 * @modified By：
 * @since ：Created in 2020/2/25 11:03
 */
@Mapper
public interface ShoppingCartMapper {
    /**
     * 通过用户名查找
     * @param username
     * @return
     */
    List<ShoppingCart> selectByUser(@Param("username") String username);

    /**
     * 新增一本书在购物车中
     * @param shoppingCart
     * @return
     */
    int insertBook(ShoppingCart shoppingCart);

    /**
     * 修改购物车中一本数的数据
     * @param shoppingCart
     * @return
     */
    int updateBook(ShoppingCart shoppingCart);

    int updateBookNum(@Param("uuid") String uuid, @Param("num") int num);

    /**
     * 删除购物车中的一本书
     * @param uuid
     * @return
     */
    int deleteBook(@Param("uuid") String uuid);

    /**
     * 清空购物车
     * @param username
     * @return
     */
    int deleteAllBook(@Param("username") String username);
}
