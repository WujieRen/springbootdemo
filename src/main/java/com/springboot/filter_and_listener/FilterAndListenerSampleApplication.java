package com.springboot.filter_and_listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * Created by renwujie on 2017/12/28 at 14:37
 */
@SpringBootApplication
@ServletComponentScan
public class FilterAndListenerSampleApplication {
    public static void main(String[] args){
        SpringApplication.run(FilterAndListenerSampleApplication.class, args);
    }
}
