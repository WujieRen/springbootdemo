package com.springboot.servlet.exam2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Created by renwujie on 2017/12/28 at 14:09
 *
 * 使用注解注册Servlet示例
 */
@SpringBootApplication
@ServletComponentScan
public class SpringBootSampleApplication {

    /**
     * 修改DispatcherServlet默认配置
     *
     * @param dispatcherServlet
     * @return
     */
    @Bean
    public ServletRegistrationBean dispatcherRegistration(DispatcherServlet dispatcherServlet){
        ServletRegistrationBean registration  = new ServletRegistrationBean(dispatcherServlet);
        registration.getUrlMappings().clear();
        registration.addUrlMappings("*.do");
        registration.addUrlMappings("*.json");
        return registration;
    }


    public static void main(String[] args){
        SpringApplication.run(SpringBootSampleApplication.class, args);
    }
}
