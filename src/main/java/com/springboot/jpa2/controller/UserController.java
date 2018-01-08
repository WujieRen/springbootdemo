package com.springboot.jpa2.controller;

import com.springboot.jpa2.entity.User;
import com.springboot.jpa2.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by renwujie on 2018/01/08 at 16:23
 */
@RestController
public class UserController {
    protected static Logger logger= LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/save")
    public User save(String name, String address, Integer age){
        logger.debug("save 开始");
        User user = userRepository.save(new User(null,name,age,address));
        logger.debug("save 结束");
        return user;
    }

    @RequestMapping("/q1")
    public List<User> q1(String address){
        logger.debug("q1 开始");
        logger.debug("q1 接收参数address={}",address);
        List<User> user = userRepository.findByAddress(address);
        return user;
    }

    @RequestMapping("/q2")
    public List<User> q2(String name,String address){
        logger.debug("q2 开始");
        logger.debug("q2接收参数name={},address={}",name,address);
        return userRepository.findByNameAndAddress(name, address);
    }

    @RequestMapping("/q3")
    public List<User> q3(String name,String address){
        logger.debug("q3 开始");
        logger.debug("q3接收参数name={},address={}",name,address);
        return userRepository.withNameAndAddressQuery(name, address);
    }

    @RequestMapping("/sort")
    public List<User> sort(){
        logger.debug("sort 开始");
        List<User> people=userRepository.findAll(new Sort(Sort.Direction.ASC,"age"));
        return people;
    }

    @RequestMapping("/page")
    public Page<User> page(){
        logger.debug("page 开始");
        Page<User> people=userRepository.findAll(new PageRequest(1,2));
        return people;
    }
}
