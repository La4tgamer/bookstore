package com.whu.bookstore.service;

import com.whu.bookstore.common.BookVo;
import com.whu.bookstore.entity.Book;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author ：qx.w
 * @description：书籍服务接口类
 * @modified By：
 * @since ：Created in 2020/2/26 17:11
 */
public interface IBooksService {
    /**
     * uuid查询一本书详细信息
     * @param uuid
     * @return
     */
    List<Book> getBookByUuid(String uuid);

    /**
     * 通过种类得到书大致信息
     * @param sort
     * @return
     */
    List<BookVo> getBookVoBySort(String sort);

    /**
     * 模糊查询书名
     * @param name
     * @param sort
     * @return
     */
    List<BookVo> getBookVoLikeName(String name, String sort);

    /**
     * 时间段之间的书
     * @param dateTime1
     * @param dateTime2
     * @return
     */
    List<BookVo> getBookVoByTime(LocalDateTime dateTime1, LocalDateTime dateTime2);

    /**
     * 时间段书数量
     * @param dateTime1
     * @param dateTime2
     * @return
     */
    int getBookNumByTime(LocalDateTime dateTime1, LocalDateTime dateTime2);

    /**
     * 插入一本书
     * @param name
     * @param author
     * @param press
     * @param sort
     * @param price
     * @param stock
     * @param description
     * @param image
     * @return
     */
    int insertBook(String uuid,
                   String name,
                   String author,
                   String press,
                   String sort,
                   double price,
                   int stock,
                   String description,
                   String image);

    /**
     * 更新书
     * @param uuid
     * @param name
     * @param author
     * @param press
     * @param sort
     * @param price
     * @param stock
     * @param description
     * @param image
     * @return
     */
    int updateBook(String uuid,
                   String name,
                   String author,
                   String press,
                   String sort,
                   double price,
                   int stock,
                   String description,
                   String image);

    /**
     * 删除一本书
     * @param uuid
     * @return
     */
    int deleteBook(String uuid);

    /**
     * 更新库存
     * @param uuid
     * @param num
     * @return
     */
    int updateStock(String uuid,int num);
}

