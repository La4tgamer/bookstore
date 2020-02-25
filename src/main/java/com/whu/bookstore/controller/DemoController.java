package com.whu.bookstore.controller;

import com.whu.bookstore.common.Result;
import com.whu.bookstore.entity.ShoppingCart;
import com.whu.bookstore.service.IShoppingCartService;
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
    IShoppingCartService shoppingCartService;

//111111
    @GetMapping(value = "/user/{username}")
    public Result user(@PathVariable("username") String username){
        List<ShoppingCart> shoppingCarts = shoppingCartService.getByUser(username);
        Result result = new Result();
        result.setData(shoppingCarts);
        return result;

    }

}
