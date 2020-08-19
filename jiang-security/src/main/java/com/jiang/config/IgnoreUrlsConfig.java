package com.jiang.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;


/**
 * @ClassName IgnoreUrlsConfig
 * @Description: 用于配置不需要保护的资源路径
 * @Author jiang
 * @Date 2020/8/18 13:47
 **/
@Getter
@Setter
@ConfigurationProperties(prefix = "secure.ignored")
public class IgnoreUrlsConfig {
    private List<String> urls = new ArrayList<>();
}
