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
     *用户名
     */
    private String username;

    /**
     * 书名
     */
    private String name;

    /**
     * 书主键
     */
    private String bookId;

    /**
     * 数量
     */
    private int num;

    /**
     * 单价
     */
    private double singlePrice;

    /**
     * 图片地址
     */
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
