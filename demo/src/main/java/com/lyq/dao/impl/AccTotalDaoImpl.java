package com.lyq.dao.impl;

import com.lyq.dao.AccTotalDao;
import com.lyq.dao.UserDao;
import com.lyq.model.AccTotal;
import com.lyq.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 账户余额
 * Created by 云强 on 2017/11/8.
 */
@Component
public class AccTotalDaoImpl implements AccTotalDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void addTotal(AccTotal accTotal) {
        mongoTemplate.save(accTotal);
    }

    @Override
    public void updateTotal(AccTotal accTotal) {
        Query query = new Query(Criteria.where("userId").is(accTotal.getUserId()));
        Update update = new Update().set("accTotal",accTotal.getAccTotal());
        mongoTemplate.updateFirst(query, update, AccTotal.class);
    }

    @Override
    public void deleteByUserId(Long userId) {
        Query query = new Query(Criteria.where("userId").is(userId));
        mongoTemplate.remove(query, AccTotal.class);
    }

    @Override
    public AccTotal findByUserId(Long userId) {
        Query query = new Query(Criteria.where("userId").is(userId));
        return mongoTemplate.findOne(query,AccTotal.class);
    }

    @Override
    public List<AccTotal> findAll() {
        return mongoTemplate.findAll(AccTotal.class);
    }

}
