package com.alibaba.jiangbootadmin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class JiangBootAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(JiangBootAdminApplication.class, args);
    }

}
