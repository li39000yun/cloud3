package com.lyq.service;

import com.lyq.model.AccTotal;

import java.util.List;

/**
 * 账户余额
 * Created by 云强 on 2017/11/8.
 */
public interface AccTotalService {

    public void addTotal(AccTotal accTotal);

    public void updateTotal(AccTotal accTotal);

    public void deleteByUserId(Long userId);

    public AccTotal findByUserId(Long userId);

    public List<AccTotal> findAll();

}
