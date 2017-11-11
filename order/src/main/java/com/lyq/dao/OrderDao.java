package com.lyq.dao;

import com.lyq.model.OrderEntity;

import java.util.List;

/**
 * 订单DAO
 * Created by 云强 on 2017/11/8.
 */
public interface OrderDao {

    public void saveOrder(OrderEntity order);

    public void updateOrder(OrderEntity order);

    public void deleteOrderById(String id);

    OrderEntity findOrderById(String id);

    List<OrderEntity> findAll();
}
