package com.whu.bookstore.entity;

import java.time.LocalDateTime;

/**
 * @author ：qx.w
 * @description：一种书的书实体类
 * @modified By：
 * @since ：Created in 2020/2/26 17:05
 */
public class Book {
    /**
     * 编号
     */
    private String uuid;

    /**
     * 书名
     */
    private String name;

    /**
     * 作者
     */
    private String author;

    /**
     * 出版社
     */
    private String press;

    /**
     * 种类
     */
    private String sort;

    /**
     * 单价
     */
    private double price;

    /**
     * 存量
     */
    private int stock;

    /**
     * 描述
     */
    private String description;

    /**
     * 图片地址
     */
    private String image;

    /**
     * 时间
     */
    private LocalDateTime createTime;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}
