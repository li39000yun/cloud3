package com.lyq.controller;

import com.lyq.model.UserEntity;
import com.lyq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * 用户控制层
 * Created by 云强 on 2017/11/8.
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Value("${server.port}")
    String port;

    @RequestMapping("/hello")
    public String home(@RequestParam String name) {
        return "hi " + name + ",i am from port:" + port;
    }

    /**
     * 添加用户
     *
     * @param userName
     * @param passWord
     */
    @RequestMapping("/user/save")
    public void add(@RequestParam("userName") String userName,
                    @RequestParam("passWord") String passWord) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(new Date().getTime());
        userEntity.setUserName(userName);
        userEntity.setPassWord(passWord);
        userService.saveUser(userEntity);
    }

    @RequestMapping("/user/get/{id}")
    public UserEntity userFindOne(@PathVariable("id") Long id) {
        return userService.findUserById(id);
    }

    @RequestMapping("/user/getList")
    public List<UserEntity> userFindAll() {
        return userService.findAll();
    }

    @RequestMapping("/user/getListByPage")
    public List<UserEntity> userFindByPage(@PathVariable("skip") int skip,@PathVariable("limit") int limit) {
        return userService.findByPage(skip,limit);
    }

    @RequestMapping("/user/getByUserName/{userName}")
    public UserEntity userFindOneByUserName(@PathVariable("userName") String userName) {
        return userService.findUserByUserName(userName);
    }

}
