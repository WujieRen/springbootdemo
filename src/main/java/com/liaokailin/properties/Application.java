package com.liaokailin.properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by renwujie on 2018/06/19 at 15:03
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args){
        SpringApplication app = new SpringApplication(Application.class);
        //app.setAdditionalProfiles("development");
        app.run(args);
    }
}
