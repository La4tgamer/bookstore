package com.whu.bookstore.service;

import com.whu.bookstore.common.BookVo;
import com.whu.bookstore.dao.BooksMapper;
import com.whu.bookstore.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ：qx.w
 * @description：书籍服务实现类
 * @modified By：
 * @since ：Created in 2020/2/26 17:12
 */
@Service
public class BooksServiceImpl implements IBooksService {
    @Resource
    BooksMapper booksMapper;


    @Override
    public List<Book> getBookByUuid(String uuid) {
        return booksMapper.selectByUuid(uuid);
    }

    @Override
    public List<BookVo> getBookVoBySort(String sort) {
        return booksMapper.selectAllBySort(sort);
    }
}
