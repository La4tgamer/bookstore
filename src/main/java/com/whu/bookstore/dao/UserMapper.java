package com.whu.bookstore.dao;

import com.whu.bookstore.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    // 通过用户名查找
    List<User> selectByUsername(@Param("username") String username);

    List<User> deleteByUsername(@Param("username") String username);

    // 注册
    int insertUser(@Param("uuid") String uuid, @Param("username") String username, @Param("password") String password, @Param("name") String name,@Param("position") String position,@Param("image") String image);

    // 修改用户信息
    List<User> updateUser(@Param("username") String username, @Param("password") String password, @Param("name") String name,@Param("position") String position,@Param("image") String image);

    // 改昵称
    List<User> updateName(@Param("username") String username, @Param("name") String name);

    // 改图片
    List<User> updateImage(@Param("username") String username, @Param("image") String image);
}
