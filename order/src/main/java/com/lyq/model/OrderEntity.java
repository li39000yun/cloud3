package com.lyq.model;

import java.io.Serializable;

/**
 * 订单实体类
 * Created by 云强 on 2017/11/8.
 */
public class OrderEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    private String orderNum;// 订单号
    private String goodsName;// 商品名称
    private int number;// 数量
    private double money;// 金额
    private Long userId;// 用户id

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
