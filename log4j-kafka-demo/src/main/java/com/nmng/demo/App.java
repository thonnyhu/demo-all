package com.nmng.demo;

import org.apache.log4j.Logger;
public class App {
    private static final Logger LOGGER = Logger.getLogger(App.class);
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 20; i++) {
            LOGGER.info("Info [" + i + "]");
            Thread.sleep(1000);
        }
    }
}
