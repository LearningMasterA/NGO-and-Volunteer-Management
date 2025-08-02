package com.ngo.management;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.IOException;
import java.util.Properties;

@Configuration
@PropertySource("classpath:mail.properties")
public class AppConfig {

    @Bean
    public Properties mailProperties() throws IOException {
        Properties props = new Properties();
        props.load(getClass().getClassLoader().getResourceAsStream("mail.properties"));
        return props;
    }
}

