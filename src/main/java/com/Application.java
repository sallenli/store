package com;

import com.alibaba.druid.pool.DruidDataSource;
import com.store.config.DruidDataSourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author sallen
 */
//springBoot 启动类申明
@SpringBootApplication
//注入druid配置信息
@Import(DruidDataSourceConfig.class)
//开启定时器功能
@EnableScheduling
public class Application {
    public  static  void main(String [] args) {
        SpringApplication.run(Application.class);
    }
}
