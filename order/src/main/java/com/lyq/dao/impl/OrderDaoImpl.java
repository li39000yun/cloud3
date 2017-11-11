package com.lyq.dao.impl;

import com.lyq.dao.OrderDao;
import com.lyq.model.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 订单dao
 * Created by 云强 on 2017/11/8.
 */
@Component
public class OrderDaoImpl implements OrderDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void saveOrder(OrderEntity order) {
        mongoTemplate.save(order);
    }

    @Override
    public void updateOrder(OrderEntity order) {
        Query query = new Query(Criteria.where("id").is(order.getId()));
        Update update = new Update().set("goodsrName", order.getGoodsName())
                .set("orderNum", order.getOrderNum())
                .set("money", order.getMoney())
                .set("number", order.getNumber());
        //更新查询返回结果集的第一条
        mongoTemplate.updateFirst(query, update, OrderEntity.class);
    }

    @Override
    public void deleteOrderById(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query);
    }

    @Override
    public OrderEntity findOrderById(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        return mongoTemplate.findOne(query, OrderEntity.class);
    }

    @Override
    public List<OrderEntity> findAll() {
        return mongoTemplate.findAll(OrderEntity.class);
    }
}
