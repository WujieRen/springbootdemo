package com.liaokailin.eventlistening;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.context.ApplicationListener;

/**
 * Created by renwujie on 2018/06/19 at 11:43
 */
public class MyApplicationFailedEventListener implements ApplicationListener<ApplicationFailedEvent> {

    private Logger logger = LoggerFactory.getLogger(MyApplicationFailedEventListener.class);

    @Override
    public void onApplicationEvent(ApplicationFailedEvent event) {
        Throwable throwable = event.getException();
        handleThrowable(throwable);
    }

    //在异常发生时，最好是添加虚拟机对应的钩子进行资源的回收与释放，能友善的处理异常信息。
    private void handleThrowable(Throwable throwable) {
        logger.info("!!处理异常!!");
    }
}
