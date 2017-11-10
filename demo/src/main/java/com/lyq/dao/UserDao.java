package com.lyq.dao;

import com.lyq.model.UserEntity;

import java.util.List;

/**
 * Created by 云强 on 2017/11/8.
 */
public interface UserDao {

    public void saveUser(UserEntity user);

    public UserEntity findUserByUserName(String userName);

    public void updateUser(UserEntity user);

    public void deleteUserById(Long id);

    UserEntity findUserById(Long id);

    List<UserEntity> findAll();
}
