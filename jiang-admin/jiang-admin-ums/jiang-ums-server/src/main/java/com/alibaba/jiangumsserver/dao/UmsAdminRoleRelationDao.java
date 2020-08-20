package com.alibaba.jiangumsserver.dao;


import com.alibaba.jiangumsserver.model.UmsResource;
import com.alibaba.jiangumsserver.model.UmsRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName UmsAdminRoleRelationDao
 * @Description: 自定义后台用户与角色管理Dao
 * @Author jiang
 * @Date 2020/8/19 16:24
 **/
@Mapper
public interface UmsAdminRoleRelationDao {
    /**
     * 获取用于所有角色
     */
    List<UmsRole> getRoleList(@Param("adminId") Long adminId);
    /**
     * 获取用户所有可访问资源
     */
    List<UmsResource> getResourceList(@Param("adminId") Long adminId);
}
