package com.whu.bookstore.service;

import com.whu.bookstore.entity.Order;

import java.util.List;

/**
 * @program: bookstore
 * @description: 订单
 * @author: lyj
 * @create: 2020-03-07 10:04
 **/

public interface IOrdersService {

    /**
     * 根据订单号查询订单
     * @param orderId
     * @return
     */
    List<Order> getOrderByOrderId(String orderId);

    /**
     * 根据用户名查询
     * @param username
     * @return
     */
    List<Order> getOrderByUsername(String username);

    /**
     * 新增订单
     * @param uuid
     * @param orderId
     * @param username
     * @param bookId
     * @param num
     * @param price
     * @param time
     * @return
     */
    int insertOrder(String uuid,String orderId,String username,String bookId,int num,double price,String time);
}
