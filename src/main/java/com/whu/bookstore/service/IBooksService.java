package com.whu.bookstore.service;

import com.whu.bookstore.common.BookVo;
import com.whu.bookstore.entity.Book;

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
}
