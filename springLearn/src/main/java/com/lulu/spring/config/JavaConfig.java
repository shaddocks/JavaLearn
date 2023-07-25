package com.lulu.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(value = {"com.lulu.spring"})
@PropertySource("classpath:/jdbc.properties")
public class JavaConfig {
}
