package com.ngnm.demo.elk;

import org.apache.log4j.Logger;

/**
 * Created by Mirana on 2017/7/19.
 */
public class Application {
    private static final Logger LOGGER = Logger.getLogger(Application.class);
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            LOGGER.error("Info log [" + i + "].");
            Thread.sleep(5000);
        }
    }
}
