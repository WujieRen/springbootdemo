package com.liaokailin.eventlistening;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;


/**
 * Created by renwujie on 2018/06/19 at 11:05
 *
 * ApplicationStartedEvent：
 *  spring boot启动开始时执行的事件
 */
public class MyApplicationStartedEventListener implements ApplicationListener<ApplicationStartedEvent> {

    private Logger logger = LoggerFactory.getLogger(MyApplicationStartedEventListener.class);

    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
        //在该事件中可以获取到SpringApplication对象，可做一些执行前的设置.
        SpringApplication app = applicationStartedEvent.getSpringApplication();
        //TODO:为何没生效？猜测是因为已经加载完后
        app.setBannerMode(Banner.Mode.OFF);
        logger.info("==MyApplicationStartedEventListener==");
    }
}
