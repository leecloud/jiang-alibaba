package com.alibaba.jiangstorage.config;

import com.jiang.core.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName ResourcesConfig
 * @Description: 静态资源映射
 * @Author jiang
 * @Date 2020/8/18 16:32
 **/
@Configuration
public class ResourcesConfig implements WebMvcConfigurer {
    @Autowired
    private DfsConfig dfsConfig;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /** 本地文件上传路径 */
        registry.addResourceHandler(Constants.RESOURCE_PREFIX + "/**")
                .addResourceLocations("file:" + dfsConfig.getPath() + "/");
    }
}
