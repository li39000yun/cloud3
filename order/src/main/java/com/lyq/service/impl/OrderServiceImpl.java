package com.lyq.service.impl;

import com.lyq.dao.OrderDao;
import com.lyq.model.OrderEntity;
import com.lyq.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 云强 on 2017/11/8.
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDao orderDao;

    @Override
    public void saveOrder(OrderEntity order) {
        orderDao.saveOrder(order);
    }

    @Override
    public OrderEntity findOrderById(String id) {
        return orderDao.findOrderById(id);
    }

    @Override
    public List<OrderEntity> findAll() {
        return orderDao.findAll();
    }

    @Override
    public void updateOrder(OrderEntity order) {
        orderDao.updateOrder(order);
    }

    @Override
    public void deleteOrderById(String id) {
        orderDao.deleteOrderById(id);
    }
}
