package com.whu.bookstore.entity;

import java.io.Serializable;

/**
 * @author ：qx.w
 * @description：购物车表
 * @modified By：
 * @since ：Created in 2020/2/25 10:49
 */
public class ShoppingCart {

    /**
     * 编号
     */
    private String uuid;

    /**
     *
     */
    private String username;

    private String bookId;

    private int num;

    private double singlePrice;

    private String image;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String book_id) {
        this.bookId = book_id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getSinglePrice() {
        return singlePrice;
    }

    public void setSinglePrice(double single_price) {
        this.singlePrice = single_price;
    }

    @Override
    public String toString() {
        return username + "," + bookId + "," + num + "," + singlePrice;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
