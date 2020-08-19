package com.jiang.component;

import org.springframework.security.access.ConfigAttribute;

import java.util.Map;

/**
 * @ClassName DynamicSecurityService
 * @Description: 动态权限相关业务类
 * @Author jiang
 * @Date 2020/8/18 13:56
 **/
public interface DynamicSecurityService {
    /**
     * 加载资源ANT通配符和资源对应MAP
     * @return
     */
    Map<String, ConfigAttribute> loadDataSource();
}
