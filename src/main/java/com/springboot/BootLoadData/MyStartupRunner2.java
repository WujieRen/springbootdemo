package com.springboot.BootLoadData;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by renwujie on 2018/01/04 at 16:01
 */
@Component
@Order(value=1)
public class MyStartupRunner2 implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println(">>>>>>>>>>>>>>>服务启动执行，执行加载数据等操作 22222222 <<<<<<<<<<<<<");
    }
}
