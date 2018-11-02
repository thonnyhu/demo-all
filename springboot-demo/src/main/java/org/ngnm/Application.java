package org.ngnm;

import org.ngnm.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan
public class Application {

    @Value("${gender}")
    private String gender;
    @Resource
    Config config;

    @Resource
    Environment environment;

    @RequestMapping("/")
    String home(){
        return config.toString() + "\r\n" + environment.toString()+"\r\n" + gender;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
