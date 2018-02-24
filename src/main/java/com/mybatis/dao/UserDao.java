package com.mybatis.dao;

import com.mybatis.pojo.User;

import java.util.List;

/**
 * Created by renwujie on 2018/02/24 at 11:30
 *
 * UserDao为操作接口，函数名和mybatis的xml配置文件中的操作id相对应
 */
public interface UserDao {
    public User findUserById(int id);

    public List<User> selectUsersByName(String userName);

    public void addUser(User user);

    public void updateUser(User user);

    public void deleteUser(int id);

}
