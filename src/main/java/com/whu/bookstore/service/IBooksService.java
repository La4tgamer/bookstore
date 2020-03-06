package com.whu.bookstore.service;

import com.whu.bookstore.common.BookVo;
import com.whu.bookstore.entity.Book;
import org.apache.ibatis.annotations.Param;

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
}
