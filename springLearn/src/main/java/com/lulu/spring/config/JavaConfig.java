package com.lulu.spring.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(value = {"com.lulu.spring"})
@PropertySource("classpath:/jdbc.properties")
@EnableAspectJAutoProxy
@EnableTransactionManagement
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

    /**
     * 对JDBC进行封装，方便进行数据库操作
     * @param druidDataSource 数据库连接池
     * @return template
     */
    @Bean
    public JdbcTemplate jdbcTemplate(DruidDataSource druidDataSource) {
        JdbcTemplate template = new JdbcTemplate();
        template.setDataSource(druidDataSource);
        return template;
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DruidDataSource druidDataSource) {
        return new NamedParameterJdbcTemplate(druidDataSource);
    }

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(DruidDataSource druidDataSource) {
        return new DataSourceTransactionManager(druidDataSource);
    }
}
