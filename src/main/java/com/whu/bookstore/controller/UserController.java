package com.whu.bookstore.controller;

import com.whu.bookstore.Util.PictureUtil;
import com.whu.bookstore.common.Result;
import com.whu.bookstore.entity.User;
import com.whu.bookstore.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    IUserService userService;


    // 获取用户信息
    @GetMapping(value = "/user/{username}")
    public Result user(@PathVariable("username") String username){
        List<User> user = userService.getByUsername(username);
        Result result = new Result();
        result.setData(user);
        result.setCode(200);
        return result;
    }


    // 登录
    @GetMapping("/user/login")
    public Result login(@RequestParam("username") String username,@RequestParam("password") String password)  {
        List<User> user = userService.getByUsername(username);
        List<String> userLogin =  new ArrayList();
        ArrayList a = new ArrayList();

        Result result = new Result();
        if(user==null|| user.size() ==0){
            result.setMsg("用户名不存在");
            result.setCode(500);
        }
        else if (!password.equals(user.get(0).getPassword())){
            result.setMsg("密码错误");
            result.setCode(500);
        }
        else if (password.equals(user.get(0).getPassword())){
            String token = userService.getToken(username,password);
            userLogin.add(token);
            userLogin.add(user.get(0).getPosition());
          //  result.setData(user.get(0).getPosition()+" "+token);
            result.setData(userLogin);
          //  result.setMsg(token);

            user.get(0).setToken(token);
            result.setData(user);
            result.setCode(200);
        }
        return result;
    }


    // 删除用户
//    @DeleteMapping("/user/{username}")
//    public String deleteUser(@PathVariable("username") String username) {
//        List<User> user = userService.delByUsername(username);
//        return "删除成功";
//    }

    // 普通用户注册
    @PostMapping("/user/register")
    public Result postUser(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("name") String name) {
        Result result = new Result();
        String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        List<User> user = userService.getByUsername(username);
        if (user==null|| user.size() ==0){
            //result.setData(userService.insUser(uuid, username, password, name, position,image));
            String position = "ordinaryuser";
            String image = "http://localhost:9010/photo/default.jpg";

            result.setMsg(userService.insUser(uuid, username, password, name, position,image));
            result.setCode(200);
        }
        else {
            result.setMsg("用户已存在");
            result.setCode(500);
        }
        return result;
    }

    // 添加管理员
    @PostMapping("/administrator/register")
    public Result postAdministrator(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("name") String name) {
        Result result = new Result();
        String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        List<User> user = userService.getByUsername(username);
        if (user==null|| user.size() ==0){
            //result.setData(userService.insUser(uuid, username, password, name, position,image));
            String position = "administrator";
            String image = "http://localhost:9010/photo/default.jpg";

            result.setMsg(userService.insUser(uuid, username, password, name, position,image));
            result.setCode(200);
        }
        else {
            result.setMsg("用户已存在");
            result.setCode(500);
        }
        return result;
    }

//    // 更改用户信息
//    @PutMapping("/user/change/{username}")
//    public Result putUser(@PathVariable("username") String username, @RequestParam("password") String password, @RequestParam("name") String name, @RequestParam("position") String position,@RequestParam("image") String image) {
//        userService.updUser(username,password,name,position,image);
//        Result result = new Result();
//        List<User> user=userService.getByUsername(username);
//        result.setData(user);
//        return result;
//    }

    // 更改昵称
    @PutMapping("/user/changename/{username}")
    public Result putUser(@PathVariable("username") String username,  @RequestParam("name") String name) {
        userService.updName(username,name);
        Result result = new Result();
//        List<User> user=userService.getByUsername(username);
        result.setMsg("更改昵称成功");
        result.setCode(200);
        return result;
    }

    // 更改图片
    @PutMapping("/user/changeimage/{username}")
    public Result putImage(@PathVariable("username") String username, @RequestParam("image") MultipartFile image) {
       // userService.updImage(username,image);
        Result result = new Result();
//        List<User> user=userService.getByUsername(username);

        // 删图
        List<User> user = userService.getByUsername(username);
      //  String path = user.get(5).toString();
        String path  = user.get(0).getImage().toString();
        PictureUtil.deletePhoto(path, PictureUtil.filePathUser);

        String url = PictureUtil.uploadImage(image, username, PictureUtil.filePathUser);
        if (url.equals("上传失败，请上传bmp、jpg、jpeg、png、gif文件！")){
            result.setCode(500);
            result.setMsg(url);
            return result;
        }else if (url.equals("图片上传至服务器失败！")){
            result.setCode(500);
            result.setMsg(url);
            return result;
        }
        try {
            userService.updImage(username, url);
            result.setCode(200);
            result.setMsg("上传成功！");
        }
        catch (Exception e) { //上传数据库失败则删除那张图片
//            objService.deletePhoto(uuid, url);
            result.setMsg("上传失败，数据库写入失败！");
            result.setCode(500);
        }

        return result;
    }

    /*测试token  不登录没有token*/
//    @UserLoginToken
//    @GetMapping("/getMessage")
//    public String getMessage(){
//        return "你已通过验证";
//    }



}
