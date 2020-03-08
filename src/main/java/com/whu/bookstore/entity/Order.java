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

    /**
     * 收件人
     */
    private String name;

    /**
     * 电话
     */
    private String phone;

    /**
     * 收货地址
     */
    private String location;



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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
