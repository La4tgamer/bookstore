package com.whu.bookstore.controller;

import com.whu.bookstore.common.Result;
import com.whu.bookstore.service.IBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：qx.w
 * @description：书籍类接口
 * @modified By：
 * @since ：Created in 2020/2/26 20:32
 */
@RestController
@RequestMapping("/books")
public class BooksController {
    @Autowired
    IBooksService booksService;

    @GetMapping(value = "/allBook/{sort}")
    public Result getBookBySort(@PathVariable("sort") String sort) {
        Result result = new Result();
        if (sort.equals("all")) {
            sort = null;
        }
        try {
            result.setData(booksService.getBookVoBySort(sort));
            result.setCode(200);
            result.setMsg("成功");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            result.setCode(400);
        }
        return result;


    }


}
