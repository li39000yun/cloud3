package com.lyq.model;

/**
 * 账户余额
 * Created by 云强 on 2017/11/11.
 */
public class AccTotal {

    private Long userId;// 用户id关联
    private double accTotal = 0L;// 账户余额

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public double getAccTotal() {
        return accTotal;
    }

    public void setAccTotal(double accTotal) {
        this.accTotal = accTotal;
    }
}
