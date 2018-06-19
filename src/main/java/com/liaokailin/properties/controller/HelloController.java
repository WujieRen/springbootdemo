package com.liaokailin.properties.controller;

import com.liaokailin.properties.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by renwujie on 2018/06/19 at 14:59
 */
@RestController
@RequestMapping("/springboot")
public class HelloController {

    @Autowired
    User user;

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    @ResponseBody
    public String sayHi(@PathVariable("name") String name) {
        return " --- urlName: " + name + user;
    }
}
