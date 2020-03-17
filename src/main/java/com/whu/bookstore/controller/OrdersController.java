package com.whu.bookstore.controller;

import com.whu.bookstore.Util.TimeUtil;
import com.whu.bookstore.common.OneOrderVo;
import com.whu.bookstore.common.Result;
import com.whu.bookstore.service.IBooksService;
import com.whu.bookstore.service.IOrdersService;
import com.whu.bookstore.service.IShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
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

    @Autowired
    IShoppingCartService shoppingCartService;

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
            result.setCode(500);
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
            result.setCode(500);
        }
        return result;
    }


    // 新增订单
    @PostMapping(value = "/order")
    public Result insertOrders(@RequestBody OneOrderVo[] oneOrder, @RequestParam String name, @RequestParam String phone, @RequestParam String location) {
        Result result = new Result();

        boolean bookStock = true;
      //  double price = 0;
        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time =  df.format(day);

        try {
            for (int i = 0;i<oneOrder.length;i++)
            {
                // OneOrder order = oneOrder[i];
                String id = oneOrder[i].getBookId();
                int stock =  booksService.getBookByUuid(id).get(0).getStock();
                int num = oneOrder[i].getNum();
               // double singlePrice = booksService.getBookByUuid(id).get(0).getPrice();
                // price = price + num*oneOrder[i].getSinglePrice();
                if(num > stock){
                    bookStock = false;
                    result.setMsg("库存不足");
                    result.setCode(500);
                }
            }
            if(bookStock){
                for (int i = 0;i<oneOrder.length;i++)
                {
                  //  OneOrder order = oneOrder[i];
                    String id = oneOrder[i].getBookId();
                    int num = oneOrder[i].getNum();
                    booksService.updateStock(id,num);
                    String uuid = UUID.randomUUID().toString(); //生成uuid
                    String orderId = UUID.randomUUID().toString(); //生成订单号
                    double price = num*oneOrder[i].getSinglePrice();
                    ordersService.insertOrder(uuid,orderId,oneOrder[i].getUsername(),oneOrder[i].getBookId(),oneOrder[i].getNum(),price,time,name,phone,location);
                    shoppingCartService.deleteBook(oneOrder[i].getUuid());   // 删除购物车的数据
                }
                result.setCode(200);
                result.setMsg("成功");
            }
        }
        catch (Exception e) {
            result.setMsg(e.getMessage());
            result.setCode(500);
        }
        return result;
    }

    // 查询时间段内订单
    @GetMapping(value = "/timeOrder")
    public Result selectByTime(@RequestParam("dateTime1") String datetime1, @RequestParam("dateTime2") String datetime2) {
        Result result = new Result();
        LocalDateTime dateTime1 = TimeUtil.parserString2LocalDateTime(datetime1, TimeUtil.DATE_FORMAT);
        LocalDateTime dateTime2 = TimeUtil.parserString2LocalDateTime(datetime2, TimeUtil.DATE_FORMAT);
        try {
            result.setData(ordersService.selectByTime(dateTime1, dateTime2));
            result.setCode(200);
            result.setMsg("查询成功");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            result.setCode(500);
        }
        return result;
    }
}
