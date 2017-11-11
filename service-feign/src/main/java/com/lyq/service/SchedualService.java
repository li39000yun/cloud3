package com.lyq.service;

import com.lyq.model.UserEntity;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 调用接口类
 * Created by 云强 on 2017/11/10.
 */
@FeignClient(value = "service-demo")
public interface SchedualService {

    @RequestMapping("/user/getList")
    public List<UserEntity> userFindAll();

    @RequestMapping("hello")
    public String hello(@RequestParam(value = "name") String name);

}
