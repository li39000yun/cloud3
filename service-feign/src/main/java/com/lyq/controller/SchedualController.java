package com.lyq.controller;

import com.lyq.model.UserEntity;
import com.lyq.service.SchedualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 云强 on 2017/11/10.
 */
@RestController
public class SchedualController {

    @Value("${server.port}")
    String port;

    @Autowired
    SchedualService schedualService;

    @RequestMapping(value = "/user/getList")
    public List<UserEntity> getList() {
        return schedualService.userFindAll();
    }

    @RequestMapping(value = "/hello")
    public String hello(@RequestParam(value = "name") String name) {
        return "feign port:" + port + "  " + schedualService.hello(name);
    }

}
