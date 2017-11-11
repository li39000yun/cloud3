package com.lyq.controller;

import com.lyq.model.OrderEntity;
import com.lyq.service.AccTotalService;
import com.lyq.service.OrderService;
import com.lyq.utils.AjaxJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户控制层
 * Created by 云强 on 2017/11/8.
 */
@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    AccTotalService accTotalService;

    @Value("${server.port}")
    String port;

    @RequestMapping("/hello")
    public String home(@RequestParam String name) {
        return "hi " + name + ",i am from port:" + port;
    }


    @RequestMapping("/order/get/{id}")
    public OrderEntity orderFindOne(@PathVariable("id") String id) {
        return orderService.findOrderById(id);
    }

    @RequestMapping("/order/getList")
    public List<OrderEntity> orderFindAll() {
        return orderService.findAll();
    }

    @RequestMapping("/submit/{id}")
    public AjaxJson sumbit(@PathVariable("id") String id) {
        AjaxJson j = new AjaxJson();
        try {
            OrderEntity orderEntity = orderService.findOrderById(id);
            return accTotalService.updateAccTotal(orderEntity.getUserId(), orderEntity.getMoney());
        } catch (Exception e) {
            j.setSuccess(false);
            j.setMsg(e.getMessage());
        }
        return j;
    }

}
