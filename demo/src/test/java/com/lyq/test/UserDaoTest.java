package com.lyq.test;

import com.lyq.dao.UserDao;
import com.lyq.model.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 云强 on 2017/11/8.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

//    @Test
    public void testSaveManyUser() throws Exception {
        List<UserEntity> users = new ArrayList<UserEntity>();
        UserEntity user;
        Long begin = System.currentTimeMillis();
        for (long i = 300000; i < 400000; i++) {
            user = new UserEntity();
            user.setId(i);
            user.setUserName("小酷" + i);
            user.setPassWord(i + "");
            users.add(user);
        }
        userDao.insertAll(users);
        Long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - begin) + "毫秒");
    }

//    @Test
    public void testSaveUser() throws Exception {
        UserEntity user = new UserEntity();
        user.setId(2L);
        user.setUserName("小明222");
        user.setPassWord("fff12");
        userDao.saveUser(user);
    }

//    @Test
    public void findUserByUserName() {
        UserEntity user = userDao.findUserByUserName("小明");
        System.out.println("user is " + user);
    }

//    @Test
    public void findByPage() {
        List<UserEntity> users = userDao.findByPage(0, 100);
        for (int i = 0; i < users.size(); i++) {
            System.out.println(i + "user is " + users.get(i).getUserName());
        }
    }

//    @Test
    public void updateUser() {
        UserEntity user = new UserEntity();
        user.setId(21l);
        user.setUserName("天空");
        user.setPassWord("fffxxxx");
        userDao.updateUser(user);
    }

//    @Test
    public void deleteUserById() {
        userDao.deleteUserById(1l);
    }

}
