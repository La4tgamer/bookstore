package com.whu.bookstore.controller;

import com.whu.bookstore.entity.ShoppingCart;
import com.whu.bookstore.service.IShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：qx.w
 * @description：
 * @modified By：
 * @since ：Created in 2020/2/24 17:58
 */


@RestController
@RequestMapping("/demo")
public class DemoController {
    @Autowired
    IShoppingCart shoppingCart;


    @GetMapping(value = "/user/{username}")
    public String user(@PathVariable("username") String username){
        List<ShoppingCart> shoppingCarts = shoppingCart.getByUser(username);
        return "这就是收到的" + shoppingCarts.get(0);

    }

}
