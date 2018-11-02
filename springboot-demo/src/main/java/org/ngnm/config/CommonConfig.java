package org.ngnm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config/conf.properties")
public class CommonConfig {

}
