package com.lyq.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 云强 on 2017/11/21.
 */
@RestController
// 在执行refresh时会刷新bean中变量值
@RefreshScope
public class ConfigTestController {

    @Value("${foo}")
    String foo;
    @RequestMapping(value = "/config/hi")
    public String hi(){
        return foo;
    }
}
