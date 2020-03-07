package com.whu.bookstore.entity;

/**
 * 订单
 */
public class Order {

    /**
     * 编号
     */
    private String uuid;
    /**
     * 订单号
     */
    private String orderId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 书号
     */
    private String bookId;
    /**
     * 书的数量
     */
    private int num;
    /**
     * 总价
     */
    private double price;
    /**
     * 时间
     */
    private String time;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
