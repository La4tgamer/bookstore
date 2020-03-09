package com.whu.bookstore.common;

/**
 * @program: bookstore
 * @description: 一条订单数据，前端传来的参数
 * @author: lyj
 * @create: 2020-03-07 11:51
 **/


public class OneOrderVo {
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

    /**
     *
     */
    private boolean choice;

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

    public boolean isChoice() {
        return choice;
    }

    public void setChoice(boolean choice) {
        this.choice = choice;
    }
}
