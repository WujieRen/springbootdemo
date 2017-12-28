package com.springboot.servlet.exam1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * Created by renwujie on 2017/12/28 at 11:45
 *
 * 通过代码注册Servlet示例。
 */
@SpringBootApplication
public class SpringBootSampleApplication {
    /**
     * 使用代码注册Servlet（不需要@ServletComponentScan注解）
     *
     * @return
     */
    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        return new ServletRegistrationBean(new MyServlet(), "/xs/*");//ServletName默认值为首字母小写，即myServlet
    }

    public static void main(String[] args){
        SpringApplication.run(SpringBootSampleApplication.class, args);
    }
}
