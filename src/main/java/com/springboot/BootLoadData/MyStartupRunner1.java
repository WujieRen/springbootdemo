package com.springboot.BootLoadData;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by renwujie on 2018/01/04 at 15:59
 */
@Component
@Order(value=2)
//可以使用@order设置启动顺序
public class MyStartupRunner1 implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println(">>>>>>>>>>>>>>>服务启动执行，执行加载数据等操作 11111111 <<<<<<<<<<<<<");
    }
}
