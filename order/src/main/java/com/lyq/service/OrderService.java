package com.lyq.service;

import com.lyq.model.OrderEntity;

import java.util.List;

/**
 * Created by 云强 on 2017/11/8.
 */
public interface OrderService {

    public void saveOrder(OrderEntity order);

    public OrderEntity findOrderById(String id);

    public List<OrderEntity> findAll();

    public void updateOrder(OrderEntity order);

    public void deleteOrderById(String id);

}
