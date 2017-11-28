package com.lyq.service;

import com.lyq.model.UserEntity;

import java.util.List;

/**
 * Created by 云强 on 2017/11/8.
 */
public interface UserService {

    public void saveUser(UserEntity user);

    public UserEntity findUserByUserName(String userName);

    public UserEntity findUserById(Long id);

    public List<UserEntity> findAll();

    public void updateUser(UserEntity user);

    public void deleteUserById(Long id);

    public List<UserEntity> findByPage(int skip,int limit);
}
