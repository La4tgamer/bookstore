package com.whu.bookstore.dao;

import com.whu.bookstore.entity.ShoppingCart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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

}
