package com.whu.bookstore.common;

/**
 * @program: bookstore
 * @description: 一条订单数据，只有username bookId num
 * @author: lyj
 * @create: 2020-03-07 11:51
 **/
public class OneOrder {
    private String username;
    private String bookId;
    private int num;

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
}
