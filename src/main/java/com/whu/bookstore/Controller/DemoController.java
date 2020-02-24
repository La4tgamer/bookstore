package com.whu.bookstore.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：qx.w
 * @description：
 * @modified By：
 * @since ：Created in 2020/2/24 17:58
 */


@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping(value = "/user/{id}")
    public String user(@PathVariable("id") Integer id){

        return "这就是收到的" + id;

    }

}
