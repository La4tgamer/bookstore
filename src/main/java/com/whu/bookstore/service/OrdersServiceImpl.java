package com.whu.bookstore.service;

import com.whu.bookstore.dao.OrdersMapper;
import com.whu.bookstore.entity.Order;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: bookstore
 * @description:订单
 * @author: lyj
 * @create: 2020-03-07 10:19
 **/

@Service
public class OrdersServiceImpl implements IOrdersService {

    @Resource
    OrdersMapper ordersMapper;

    @Override
    public List<Order> getOrderByOrderId(String orderId){
        return ordersMapper.selectByOrderId(orderId);
    }

    @Override
    public List<Order> getOrderByUsername(String username) {
        return ordersMapper.selectByUsername(username);
    }

    @Override
    public int insertOrder(String uuid, String orderId, String username, String bookId, int num, double price, String time,String name,String phone,String location) {
        Order order = new Order();
        order.setUuid(uuid);
        order.setOrderId(orderId);
        order.setUsername(username);
        order.setBookId(bookId);
        order.setNum(num);
        order.setPrice(price);
        order.setTime(time);
        order.setName(name);
        order.setPhone(phone);
        order.setLocation(location);
        return ordersMapper.insertOrder(order);
    }
}
