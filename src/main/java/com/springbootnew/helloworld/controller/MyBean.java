package com.springbootnew.helloworld.controller;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * Created by renwujie on 2018/06/14 at 18:30
 */
@Component
public class MyBean implements ApplicationRunner {

   /* @Override
    public void run(String... args) throws Exception {

    }*/

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("<<<<<<<<<<<<这个是测试CommandLineRunn接口>>>>>>>>>>>>>>");
    }
}
