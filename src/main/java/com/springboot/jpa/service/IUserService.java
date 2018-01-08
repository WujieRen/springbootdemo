package com.springboot.jpa.service;

import com.springboot.jpa.domain.User;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by renwujie on 2018/01/08 at 14:30
 */
public interface IUserService {

    public List<User> findAll();

    public void saveUser(User user);

    public User findOne(int id);

    public void delete(int id);

    public List<User> findByName(String name);

    public List<User> findByNameAndId(String name, Long id);

    public List<User> withNameAndIdQuery(String name, Integer age);

    public List<User> sort();

    public Page<User> page();
}
