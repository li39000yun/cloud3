package com.lyq.controller;

import com.lyq.model.OrderEntity;
import com.lyq.service.OrderService;
import com.lyq.utils.AjaxJson;
import com.lyq.utils.UuidUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 云强 on 2017/11/8.
 */
@Controller
public class IndexController {

    @Resource
    OrderService orderService;


    @RequestMapping("/")
    public String index() {
        return "redirect:/list";
    }

    @RequestMapping("/list")
    public String list(Model model) {
        List<OrderEntity> orders = orderService.findAll();
        model.addAttribute("orders", orders);
        return "order/list";
    }

    @RequestMapping("/toAdd")
    public String toAdd() {
        return "order/orderAdd";
    }

    @RequestMapping("/add")
    public String add(OrderEntity order) {
        order.setId(UuidUtils.getUuid());
        orderService.saveOrder(order);
        return "redirect:/list";
    }

    @RequestMapping("/toEdit")
    public String toEdit(Model model, String id) {
        OrderEntity order = orderService.findOrderById(id);
        model.addAttribute("order", order);
        return "order/orderEdit";
    }

    @RequestMapping("/edit")
    public String edit(OrderEntity order) {
        orderService.updateOrder(order);
        return "redirect:/list";
    }

    @RequestMapping("/delete")
    public String delete(String id) {
        orderService.deleteOrderById(id);
        return "redirect:/list";
    }

}
