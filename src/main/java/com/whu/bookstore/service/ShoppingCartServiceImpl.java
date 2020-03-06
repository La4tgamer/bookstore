package com.whu.bookstore.service;

import com.whu.bookstore.dao.ShoppingCartMapper;
import com.whu.bookstore.entity.ShoppingCart;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ：qx.w
 * @description：
 * @modified By：
 * @since ：Created in 2020/2/25 11:13
 */
@Service
public class ShoppingCartServiceImpl implements IShoppingCartService {
    @Resource
    ShoppingCartMapper shoppingCartMapper;


    @Override
    public List<ShoppingCart> getByUser(String username) {
        return shoppingCartMapper.selectByUser(username);
    }

    @Override
    public int insertBook(String uuid, String username, String name, String bookId, int num, double singlePrice, String image) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUuid(uuid);
        shoppingCart.setUsername(username);
        shoppingCart.setName(name);
        shoppingCart.setBookId(bookId);
        shoppingCart.setNum(num);
        shoppingCart.setSinglePrice(singlePrice);
        shoppingCart.setImage(image);
        return shoppingCartMapper.insertBook(shoppingCart);
    }

    @Override
    public int updateBook(String uuid, String username, String name, String bookId, int num, double singlePrice, String image) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUuid(uuid);
        shoppingCart.setUsername(username);
        shoppingCart.setName(name);
        shoppingCart.setBookId(bookId);
        shoppingCart.setNum(num);
        shoppingCart.setSinglePrice(singlePrice);
        shoppingCart.setImage(image);
        return shoppingCartMapper.updateBook(shoppingCart);
    }

    @Override
    public int updateBookNum(String uuid, int num) {
        return shoppingCartMapper.updateBookNum(uuid, num);
    }

    @Override
    public int deleteBook(String uuid) {
        return shoppingCartMapper.deleteBook(uuid);
    }

    @Override
    public int deleteAllBook(String username) {
        return shoppingCartMapper.deleteAllBook(username);
    }
}
