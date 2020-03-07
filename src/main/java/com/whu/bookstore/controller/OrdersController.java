package com.whu.bookstore.controller;

import com.whu.bookstore.Util.PictureUtil;
import com.whu.bookstore.common.OneOrder;
import com.whu.bookstore.common.Result;
import com.whu.bookstore.service.IBooksService;
import com.whu.bookstore.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @program: bookstore
 * @description: 订单
 * @author: lyj
 * @create: 2020-03-07 10:43
 **/


@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    IOrdersService ordersService;

    @Autowired
    IBooksService booksService;

    // 根据订单号查询订单
    @GetMapping(value = "/aOrder/{orderId}")
    public Result getOrderByOrderId(@PathVariable("orderId") String orderId) {
        Result result = new Result();
        try {
            result.setData(ordersService.getOrderByOrderId(orderId));
            result.setCode(200);
            result.setMsg("成功");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            result.setCode(400);
        }
        return result;
    }

    // 根据用户名查询订单
    @GetMapping(value = "/order/{username}")
    public Result getOrderByUsername(@PathVariable("username") String username) {
        Result result = new Result();
        try {
            result.setData(ordersService.getOrderByUsername(username));
            result.setCode(200);
            result.setMsg("成功");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            result.setCode(400);
        }
        return result;
    }


    // 新增订单
    @PostMapping(value = "/order")
    public Result insertOrders(@RequestBody OneOrder [] oneOrder) {
        Result result = new Result();
        String orderId = UUID.randomUUID().toString(); //生成订单号
        boolean bookStock = true;
        double price = 0;
        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time =  df.format(day);

        try {
            for (int i = 0;i<oneOrder.length;i++)
            {
                OneOrder order = oneOrder[i];
                String id = oneOrder[i].getBookId();
                int stock =  booksService.getBookByUuid(id).get(0).getStock();
                int num = oneOrder[i].getNum();
                double singlePrice = booksService.getBookByUuid(id).get(0).getPrice();
                price = price + num*singlePrice;
                if(num > stock){
                    bookStock = false;
                    result.setMsg("库存不足");
                }
            }
            if(bookStock){
                for (int i = 0;i<oneOrder.length;i++)
                {
                    OneOrder order = oneOrder[i];
                    String id = oneOrder[i].getBookId();
                    int num = oneOrder[i].getNum();
                    booksService.updateStock(id,num);
                    String uuid = UUID.randomUUID().toString(); //生成uuid
                    ordersService.insertOrder(uuid,orderId,order.getUsername(),order.getBookId(),order.getNum(),price,time);
                }
                result.setCode(200);
                result.setMsg("成功");
            }
        }
        catch (Exception e) {
            result.setMsg(e.getMessage());
        }
        return result;

    }
}
