package com.alibaba.jianggateway;

import com.alibaba.jianggateway.config.IgnoreUrlsConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(IgnoreUrlsConfig.class)
public class JiangGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(JiangGatewayApplication.class, args);
    }

}
