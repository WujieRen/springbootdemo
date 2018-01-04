package com.springboot.static_resource_handle;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by renwujie on 2018/01/04 at 11:35
 *
 *方式一： 静态资源配置类，通过继承WebMvcConfigurerAdapter来实现。
 *  1.这样使用代码的方式自定义目录映射，并不影响Spring Boot的默认映射，可以同时使用。
 *  2.如果将/myres/* 修改为 /* 与默认的相同时，则会覆盖系统的配置，可以多次使用 addResourceLocations 添加目录，优先级先添加的高于后添加的。
 *  3.其中 addResourceLocations 的参数是动参，可以这样写 addResourceLocations(“classpath:/img1/”, “classpath:/img2/”, “classpath:/img3/”);
 *
 */
@Configuration
public class MyWebAppStaticConfigure extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/myres/**").addResourceLocations("classpath:/myres/");
        super.addResourceHandlers(registry);
    }
}
