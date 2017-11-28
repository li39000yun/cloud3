package com.lyq.dao;

import com.lyq.model.UserEntity;

import java.util.List;

/**
 * Created by 云强 on 2017/11/8.
 */
public interface UserDao {

    public void insertAll(List<UserEntity> users);

    public void saveUser(UserEntity user);

    public UserEntity findUserByUserName(String userName);

    public void updateUser(UserEntity user);

    public void deleteUserById(Long id);

    UserEntity findUserById(Long id);

    List<UserEntity> findAll();

    /**
     * 分页查询
     * @param skip 跳过多少条
     * @param limit 查多少条
     * @return
     */
    List<UserEntity> findByPage(int skip,int limit);
}
