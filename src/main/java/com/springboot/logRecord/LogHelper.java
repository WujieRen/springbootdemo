package com.springboot.logRecord;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by renwujie on 2018/01/04 at 16:39
 */
public class LogHelper {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    public void helpMethod(){
        logger.debug(" debug message");
        logger.info("info message");
        logger.warn("warn message");
        logger.error("error message");
    }
}
