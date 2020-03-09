package com.whu.bookstore.dao;

import com.whu.bookstore.common.OrdersVo;
import com.whu.bookstore.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: bookstore
 * @description: 订单
 * @author: lyj
 * @create: 2020-03-07 10:28
 **/

@Mapper
public interface OrdersMapper {

    /**
     * 通过订单号查询订单
     * @param orderId
     * @return
     */
    List<Order> selectByOrderId(@Param("orderId") String orderId);

    /**
     * 通过用户名查询
     * @param username
     * @return
     */
    List<OrdersVo> selectByUsername(@Param("username") String username);

    /**
     * 新增订单
     * @param order
     * @return
     */
    int insertOrder(Order order);
}
