package com.jdbc;

import com.jdbc.common.MyMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;


/**
 * "exclude = {DataSourceAutoConfiguration.class}"
 * 此配置解决DataSourceAutoConfiguration 和自己配置的数据源的循环引用问题
 */
@MapperScan(markerInterface = MyMapper.class, basePackages = "com.jdbc.dao")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class JdbcApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(JdbcApplication.class, args);
    }
}
