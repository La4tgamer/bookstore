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
}
