package com.springboot.mybaits.controller;

import com.springboot.mybaits.domain.User;
import com.springboot.mybaits.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by renwujie on 2018/01/09 at 11:48
 */
@RestController
@RequestMapping("/home")
public class UserController {

    @Autowired
    UserMapper userMapper;

    @RequestMapping(value = "/user")
    @ResponseBody
    public String user(){
        User user = userMapper.findByName("aa");
        return user.getName() + " : " + user.getAddress();
    }

}
