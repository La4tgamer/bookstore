package com.whu.bookstore.entity;

/**
 * @author ：qx.w
 * @description：用户地址实体
 * @modified By：
 * @since ：Created in 2020/3/7 10:39
 */
public class Address {
    /**
     * 编号
     */
    private String uuid;

    /**
     * 用户名
     */
    private String username;

    /**
     * 收件人
     */
    private String name;

    /**
     * 电话
     */
    private String phone;

    /**
     * 具体地址
     */
    private String location;

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
