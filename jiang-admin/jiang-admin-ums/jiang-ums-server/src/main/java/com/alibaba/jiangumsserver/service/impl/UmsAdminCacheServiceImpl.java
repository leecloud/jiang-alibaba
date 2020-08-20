package com.alibaba.jiangumsserver.service.impl;

import com.alibaba.jiangumsserver.model.UmsResource;
import com.alibaba.jiangumsserver.service.UmsAdminCacheService;
import com.alibaba.jiangumsserver.service.UmsAdminService;
import com.jiang.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UmsAdminCacheServiceImpl
 * @Description:
 * @Author jiang
 * @Date 2020/8/19 15:59
 **/
@Service
public class UmsAdminCacheServiceImpl implements UmsAdminCacheService {
    @Autowired
    private RedisService redisService;
    @Value("${redis.database}")
    private String REDIS_DATABASE;
    @Value("${redis.expire.common}")
    private Long REDIS_EXPIRE;
    @Value("${redis.key.admin}")
    private String REDIS_KEY_ADMIN;
    @Value("${redis.key.resourceList}")
    private String REDIS_KEY_RESOURCE_LIST;
    @Value("${redis.key.token}")
    private String REDIS_KEY_TOKEN;
    @Value("${jwt.expiration}")
    private Long JWT_EXPIRATION;
    @Override
    public List<UmsResource> getResourceList(Long adminId) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":" + adminId;
        return (List<UmsResource>) redisService.get(key);
    }

    @Override
    public void setResourceList(Long adminId, List<UmsResource> resourceList) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":" + adminId;
        redisService.set(key, resourceList, REDIS_EXPIRE);
    }

    @Override
    public void setToken(String username, String token) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_TOKEN + ":" + username;
        redisService.set(key, token, JWT_EXPIRATION);
    }
}
