package com.whu.bookstore.common;

/**
 * @author ：qx.w
 * @description：简略信息的书籍的实体
 * @modified By：
 * @since ：Created in 2020/2/26 20:10
 */
public class BookVo {
    /**
     * 主键
     */
    private String uuid;

    /**
     * 书名
     */
    private String name;

    /**
     * 图片地址
     */
    private String image;

    /**
     * 类别
     */
    private String sort;

    /**
     * 单价
     */
    private double price;

    public BookVo() {
    }

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}
