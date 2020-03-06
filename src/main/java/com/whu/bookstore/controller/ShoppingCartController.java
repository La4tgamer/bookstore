package com.whu.bookstore.controller;

import com.whu.bookstore.common.Result;
import com.whu.bookstore.entity.ShoppingCart;
import com.whu.bookstore.service.IShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * @author ：qx.w
 * @description：购物车接口类
 * @modified By：
 * @since ：Created in 2020/3/6 13:10
 */
@RestController
@RequestMapping("/shoppingCart")
public class ShoppingCartController {
    @Autowired
    IShoppingCartService shoppingCartService;

    @GetMapping(value = "/{username}")
    public Result getShoppingCartByUsername(@PathVariable("username") String username) {
        Result result = new Result();
        try {
            result.setData(shoppingCartService.getByUser(username));
            result.setMsg("成功");
            result.setCode(200);
        }
        catch (Exception e) {
            result.setMsg("失败");
            result.setCode(500);
        }
        return result;
    }

    @PostMapping(value = "/{username}")
    public Result uploadABook(@PathVariable("username") String username,
                              @RequestParam("name") String name,
                              @RequestParam("bookId") String bookId,
                              @RequestParam("num") int num,
                              @RequestParam("singlePrice") double singlePrice,
                              @RequestParam("image") String image) {
        Result result = new Result();
        String uuid = UUID.randomUUID().toString(); //生成UUID
        try {
            int count = shoppingCartService.insertBook(uuid, username, name, bookId, num, singlePrice, image);
            result.setData(count);
            result.setMsg("成功，插入条数为data");
            result.setCode(200);
        }
        catch (Exception e) {
            result.setMsg("失败");
            result.setCode(500);
        }
        return result;
    }

    @PutMapping(value = "/{uuid}")
    public Result updateBookNum(@PathVariable("uuid") String uuid,
                              @RequestParam("num") int num) {
        Result result = new Result();
        try {
            int count = shoppingCartService.updateBookNum(uuid, num);
            result.setData(count);
            result.setMsg("成功，修改条数为data");
            result.setCode(200);
        }
        catch (Exception e) {
            result.setMsg("失败");
            result.setCode(500);
        }
        return result;
    }

    @DeleteMapping(value = "/{uuid}")
    public Result deleteABook(@PathVariable("uuid") String uuid) {
        Result result = new Result();
        try {
            int count = shoppingCartService.deleteBook(uuid);
            result.setData(count);
            result.setMsg("成功，删除条数为data");
            result.setCode(200);
        }
        catch (Exception e) {
            result.setMsg("失败");
            result.setCode(500);
        }
        return result;
    }

    @DeleteMapping(value = "/allBook/{username}")
    public Result deleteAllBook(@PathVariable("username") String username) {
        Result result = new Result();
        try {
            int count = shoppingCartService.deleteAllBook(username);
            result.setData(count);
            result.setMsg("成功，删除条数为data");
            result.setCode(200);
        }
        catch (Exception e) {
            result.setMsg("失败");
            result.setCode(500);
        }
        return result;
    }
}
