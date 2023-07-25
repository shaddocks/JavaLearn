package com.lulu.spring.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(value = {"com.lulu.spring"})
@PropertySource("classpath:/jdbc.properties")
@EnableAspectJAutoProxy
public class JavaConfig {
    @Value("${prop.userName}")
    String userName;
    @Value("${prop.password}")
    String password;
    @Value("${prop.url}")
    String url;
    @Value("${prop.driverClass}")
    String driver;

    @Bean
    public DruidDataSource druidDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername(userName);
        druidDataSource.setPassword(password);
        druidDataSource.setUrl(url);
        druidDataSource.setDriverClassName(driver);
        return druidDataSource;
    }
}
