package com.whu.bookstore.service;

import com.whu.bookstore.entity.User;

import java.time.LocalDateTime;
import java.util.List;

public interface IUserService {
    /**
     * 通过用户名得到用户的密码，昵称，身份
     * @param username
     * @return
     */
    List<User> getByUsername(String username);

    // 删除用户
    int delByUsername(String username);

    // 注册用
    String insUser(String uuid, String username, String password, String name, String position,String image,String time);

    // 修改用户信息
    String updUser(String username, String password, String name, String position,String image);

    // 得到token
    String getToken(String username,String password);

    // 改昵称
    String updName(String username, String name);

    // 改图片
    String updImage(String username, String image);

    /**
     * 时间段普通用户注册量
     * @param dateTime1
     * @param dateTime2
     * @return
     */
    int selectByTime(LocalDateTime dateTime1, LocalDateTime dateTime2);
}
