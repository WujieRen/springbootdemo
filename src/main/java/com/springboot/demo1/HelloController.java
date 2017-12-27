package com.springboot.demo1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by renwujie on 2017/12/27 at 11:05
 *
 * HelloWorldTest
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        System.out.println("这是小猿添加的代码");
        System.out.println("这是小猿添加的代码");
        return "hello SpringBoot!";
    }
}
