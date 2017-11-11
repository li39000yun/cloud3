package com.lyq.dao;

import com.lyq.model.AccTotal;

import java.util.List;

/**
 * 账户余额DAO
 * Created by 云强 on 2017/11/8.
 */
public interface AccTotalDao {

    public void addTotal(AccTotal accTotal);

    public void updateTotal(AccTotal accTotal);

    public void deleteByUserId(Long userId);

    AccTotal findByUserId(Long userId);

    List<AccTotal> findAll();

}
