package com.liaokailin.eventlistening;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by renwujie on 2018/06/19 at 11:37
 *
 * ApplicationPreparedEvent:
 *  Sspring boot上下文context创建完成，但此时spring中的bean是没有完全加载完成的。
 */
public class MyApplicationPreparedEventListener implements ApplicationListener<ApplicationPreparedEvent> {

    private Logger logger = LoggerFactory.getLogger(MyApplicationPreparedEventListener.class);


    @Override
    public void onApplicationEvent(ApplicationPreparedEvent event) {
        ConfigurableApplicationContext cac = event.getApplicationContext();
        passContextInfo(cac);
    }

    /**
     * 在获取完上下文后，可以将上下文传递出去做一些额外的操作
     * @param cac ConfigurableApplicationContext
     */
    private void passContextInfo(ConfigurableApplicationContext cac) {
        logger.info("~~传递上下文，ConfigurableApplicatonContext is active? ~~" + cac.isActive());
    }
}
