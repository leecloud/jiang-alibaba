package com.alibaba.jiangumsserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(scanBasePackages = {"com.jiang.service.*"})
public class JiangUmsServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(JiangUmsServerApplication.class, args);
    }

}
