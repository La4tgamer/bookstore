package com.whu.bookstore.controller;

import com.whu.bookstore.common.Result;
import com.whu.bookstore.entity.Address;
import com.whu.bookstore.service.IAddressesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author ：qx.w
 * @description：地址接口类
 * @modified By：
 * @since ：Created in 2020/3/7 11:20
 */
@RestController
@RequestMapping(value = "/addresses")
public class AddressesController {
    @Autowired
    IAddressesService addressesService;

    @GetMapping(value = "/{username}")
    public Result getAddressesByUsername(@PathVariable("username") String username) {
        Result result = new Result();
        try {
            result.setData(addressesService.getByUser(username));
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
    public Result uploadAddress(@PathVariable("username") String username,
                              @RequestParam("name") String name,
                              @RequestParam("phone") String phone,
                              @RequestParam("location") String location) {
        Result result = new Result();
        String uuid = UUID.randomUUID().toString(); //生成UUID
        try {
            int count = addressesService.insertAddress(uuid, username, name, phone, location);
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
    public Result updateAddress(@PathVariable("uuid") String uuid,
                                @RequestParam("username") String username,
                                @RequestParam("name") String name,
                                @RequestParam("phone") String phone,
                                @RequestParam("location") String location) {
        Result result = new Result();
        try {
            int count = addressesService.updateAddress(uuid, username, name, phone, location);
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
    public Result deleteAddress(@PathVariable("uuid") String uuid) {
        Result result = new Result();
        try {
            int count = addressesService.deleteAddress(uuid);
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
