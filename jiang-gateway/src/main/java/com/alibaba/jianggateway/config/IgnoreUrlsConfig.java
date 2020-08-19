package com.alibaba.jianggateway.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName IgnoreUrlsConfig
 * @Description: 用于配置不需要保护的资源路径
 * @Author jiang
 * @Date 2020/8/19 11:17
 **/
@ConfigurationProperties(prefix = "secure.ignored")
@Getter
@Setter
public class IgnoreUrlsConfig {
    private List<String> urls = new ArrayList<>();
}
