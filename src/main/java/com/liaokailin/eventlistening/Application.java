package com.liaokailin.eventlistening;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by renwujie on 2018/06/19 at 11:16
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args){
        SpringApplication application = new SpringApplication(Application.class);
        //application.setBannerMode(Banner.Mode.OFF);
        application.addListeners(new MyApplicationFailedEventListener());
        application.run(args);
    }
}
