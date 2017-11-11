package com.lyq.service.impl;

import com.lyq.dao.AccTotalDao;
import com.lyq.model.AccTotal;
import com.lyq.service.AccTotalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 云强 on 2017/11/8.
 */
@Service
public class AccTotalServiceImpl implements AccTotalService {
    @Autowired
    AccTotalDao accTotalDao;

    @Override
    public void addTotal(AccTotal accTotal) {
        accTotalDao.addTotal(accTotal);
    }

    @Override
    public void updateTotal(AccTotal accTotal) {
        accTotalDao.updateTotal(accTotal);
    }

    @Override
    public void deleteByUserId(Long userId) {
        accTotalDao.deleteByUserId(userId);
    }

    @Override
    public AccTotal findByUserId(Long userId) {
        return accTotalDao.findByUserId(userId);
    }

    @Override
    public List<AccTotal> findAll() {
        return accTotalDao.findAll();
    }
}
