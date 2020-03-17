package com.whu.bookstore.dao;

import com.whu.bookstore.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface UserMapper {
    // 通过用户名查找
    List<User> selectByUsername(@Param("username") String username);

    int deleteByUsername(@Param("username") String username);

    // 注册
    int insertUser(@Param("uuid") String uuid, @Param("username") String username, @Param("password") String password, @Param("name") String name,@Param("position") String position,@Param("image") String image,@Param("time") String time);

    // 修改用户信息
    int updateUser(@Param("username") String username, @Param("password") String password, @Param("name") String name,@Param("position") String position,@Param("image") String image);

    // 改昵称
    int updateName(@Param("username") String username, @Param("name") String name);

    // 改图片
    int updateImage(@Param("username") String username, @Param("image") String image);

    /**
     * 查询时间段普通用户注册量
     * @param dateTime1
     * @param dateTime2
     * @return
     */
    int selectByTime(@Param("dateTime1") LocalDateTime dateTime1, @Param("dateTime2") LocalDateTime dateTime2);
}
