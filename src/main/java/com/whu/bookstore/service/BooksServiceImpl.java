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

    @Override
    public List<BookVo> getBookVoLikeName(String name, String sort) {
        return booksMapper.selectLikeName(name, sort);
    }

    @Override
    public int insertBook(String uuid, String name, String author, String press, String sort, double price, int stock, String description, String image) {
        Book book = new Book();
        book.setUuid(uuid);
        book.setName(name);
        book.setAuthor(author);
        book.setPress(press);
        book.setSort(sort);
        book.setPrice(price);
        book.setStock(stock);
        book.setDescription(description);
        book.setImage(image);
        //return booksMapper.insertBook(name, author, press, sort, price, stock, description, image);
        return booksMapper.insertBook(book);
    }

    @Override
    public int updateBook(String uuid, String name, String author, String press, String sort, double price, int stock, String description, String image) {
        Book book = new Book();
        book.setUuid(uuid);
        book.setName(name);
        book.setAuthor(author);
        book.setPress(press);
        book.setSort(sort);
        book.setPrice(price);
        book.setStock(stock);
        book.setDescription(description);
        book.setImage(image);
        //return booksMapper.insertBook(name, author, press, sort, price, stock, description, image);
        return booksMapper.updateBook(book);
    }

    @Override
    public int deleteBook(String uuid) {
        return booksMapper.deleteBook(uuid);
    }


}
