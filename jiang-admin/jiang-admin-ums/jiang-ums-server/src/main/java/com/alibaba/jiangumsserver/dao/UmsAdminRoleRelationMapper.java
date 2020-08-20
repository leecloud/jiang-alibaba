package com.alibaba.jiangumsserver.dao;

import com.alibaba.jiangumsserver.model.UmsAdminRoleRelation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName UmsAdminRoleRelationMapper
 * @Description: 后台用户和角色关系
 * @Author jiang
 * @Date 2020/8/19 16:06
 **/
@Mapper
public interface UmsAdminRoleRelationMapper extends BaseMapper<UmsAdminRoleRelation> {

}
