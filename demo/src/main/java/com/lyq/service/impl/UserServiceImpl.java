package com.lyq.service.impl;

import com.lyq.dao.UserDao;
import com.lyq.model.UserEntity;
import com.lyq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 云强 on 2017/11/8.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public void saveUser(UserEntity user) {
        userDao.saveUser(user);
    }

    @Override
    public UserEntity findUserByUserName(String userName) {
        return userDao.findUserByUserName(userName);
    }

    @Override
    public UserEntity findUserById(Long id) {
        return userDao.findUserById(id);
    }

    @Override
    public List<UserEntity> findAll() {
        return userDao.findAll();
    }

    @Override
    public void updateUser(UserEntity user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUserById(Long id) {
        userDao.deleteUserById(id);
    }

    @Override
    public List<UserEntity> findByPage(int skip,int limit) {
        return userDao.findByPage(skip,limit);
    }
}
