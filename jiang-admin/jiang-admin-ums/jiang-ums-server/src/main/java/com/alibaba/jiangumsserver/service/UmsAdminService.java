package com.alibaba.jiangumsserver.service;

import com.alibaba.jiangumsserver.dto.LoginParam;
import com.alibaba.jiangumsserver.model.UmsAdmin;
import com.alibaba.jiangumsserver.model.UmsResource;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jiang.api.ApiResult;

import java.util.List;

/**
 * @ClassName UmsAdminService
 * @Description:
 * @Author jiang
 * @Date 2020/8/19 14:18
 **/
public interface UmsAdminService extends IService<UmsAdmin> {
    /**
     * 登录
     * @param param
     * @return
     */
    ApiResult login(LoginParam param);

    /**
     * 获取缓存后台用户资源列表
     */
    List<UmsResource> getResourceList(Long adminId);
}
