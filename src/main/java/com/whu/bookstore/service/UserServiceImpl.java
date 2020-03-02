package com.whu.bookstore.service;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.whu.bookstore.dao.UserMapper;
import com.whu.bookstore.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Resource
    UserMapper userMapper;

    @Override
    // 得到用户信息
    public List<User> getByUsername(String username) {
        return userMapper.selectByUsername(username);
    }

    // 删除用户，这个现在没用
    public List<User> delByUsername(String username) {
        return userMapper.deleteByUsername(username);
    }

    // 添加用户，注册
    public String insUser(String uuid, String username, String password, String name, String position,String image) {
        userMapper.insertUser(uuid,username,password,name,position,image);
        return "注册成功";
    }

    // 修改用户信息
    public String updUser(String username, String password, String name, String position,String image) {
        userMapper.updateUser(username,password,name,position,image);
        return "修改成功";
    }

    // 修改昵称
    public String updName(String username, String name) {
        userMapper.updateName(username,name);
        return "修改成功";
    }

    // 生成token
    public String getToken(String username, String password) {
        // 需要加密的字符串
        String src = username + password;
        try {
            // 加密对象，指定加密方式
            MessageDigest md5 = MessageDigest.getInstance("md5");
            // 准备要加密的数据
            byte[] b = src.getBytes();
            // 加密：MD5加密一种被广泛使用的密码散列函数，
            // 可以产生出一个128位（16字节）的散列值（hash value），用于确保信息传输完整一致
            byte[] digest = md5.digest(b);
            // 十六进制的字符
            char[] chars = new char[]{'0', '1', '2', '3', '4', '5',
                    '6', '7', 'A', 'B', 'C', 'd', 'o', '*', '#', '/'};
            StringBuffer sb = new StringBuffer();
            // 处理成十六进制的字符串(通常)
            // 遍历加密后的密码，将每个元素向右位移4位，然后与15进行与运算(byte变成数字)
            for (byte bb : digest) {
                sb.append(chars[(bb >> 4) & 15]);
                sb.append(chars[bb & 15]);
            }
            // 打印加密后的字符串
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;

//        Date start = new Date();
//        long currentTime = System.currentTimeMillis() + 60* 60 * 1000;//一小时有效时间
//        Date end = new Date(currentTime);
//        String token = "";
//
//        token = JWT.create().withAudience(username).withIssuedAt(start).withExpiresAt(end).sign(Algorithm.HMAC256(password));
//        return token;
    }


}
