package com.charlie.mhl.domain;

/**
 * 这是一个javabean 和 diningTable相对应
 * CREATE TABLE diningTable (
 * 	id INT PRIMARY KEY AUTO_INCREMENT,	# 餐桌编号
 * 	state VARCHAR(16) NOT NULL DEFAULT '', 	# 餐桌的状态
 * 	orderName VARCHAR(16) NOT NULL DEFAULT '', # 预定人名字
 * 	orderTel VARCHAR(16) NOT NULL DEFAULT ''   # 预定人手机号
 * ) CHARSET=utf8;
 */
public class DiningTable {
    private Integer id;
    private String state;
    private String orderName;
    private String orderTel;

    public DiningTable() {  // 无参构造函数
    }

    public DiningTable(Integer id, String state, String orderName, String orderTel) {
        this.id = id;
        this.state = state;
        this.orderName = orderName;
        this.orderTel = orderTel;
    }

    @Override
    public String toString() {
        return  id + "\t\t\t" + state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderTel() {
        return orderTel;
    }

    public void setOrderTel(String orderTel) {
        this.orderTel = orderTel;
    }
}
