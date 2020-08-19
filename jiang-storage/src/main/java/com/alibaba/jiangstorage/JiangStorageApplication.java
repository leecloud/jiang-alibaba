package com.alibaba.jiangstorage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class JiangStorageApplication {

    public static void main(String[] args) {
        SpringApplication.run(JiangStorageApplication.class, args);
    }

}
