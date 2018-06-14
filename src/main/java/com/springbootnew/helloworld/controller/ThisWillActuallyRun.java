package com.springbootnew.helloworld.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by renwujie on 2018/06/12 at 14:14
 */
@RestController
@EnableAutoConfiguration
@ComponentScan
//@SpringBootApplication
public class ThisWillActuallyRun {

    @RequestMapping("/")
    //String home(@RequestParam String param) {
    String home(String param) {
        return "Hello " + param;
    }
    public static void main(String[] args){
        SpringApplication.run(ThisWillActuallyRun.class, args);
    }
}
