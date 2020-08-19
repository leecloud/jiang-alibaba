package com.alibaba.jiangstorage.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName DfsConfig
 * @Description: 文件配置
 * @Author jiang
 * @Date 2020/8/18 16:07
 **/
@Data
@Component
@ConfigurationProperties(prefix = "dfs")
public class DfsConfig {
    /**
     * 路径
     */
    private String path;

    /**
     * 域名,生产环境建议用nginx绑定域名映射
     */
    private String domain;
}
