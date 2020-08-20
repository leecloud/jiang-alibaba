package com.alibaba.jiangumsserver.service;



import com.alibaba.jiangumsserver.model.UmsResource;

import java.util.List;

/**
 * @ClassName UmsAdminCacheService
 * @Description:
 * @Author jiang
 * @Date 2020/8/19 15:59
 **/
public interface UmsAdminCacheService {
    /**
     * 获取缓存后台用户资源列表
     */
    List<UmsResource> getResourceList(Long adminId);
    /**
     * 设置后台后台用户资源列表
     */
    void setResourceList(Long adminId, List<UmsResource> resourceList);
    /**
     * 设置 token
     */
    void setToken(String username,String token);
}
