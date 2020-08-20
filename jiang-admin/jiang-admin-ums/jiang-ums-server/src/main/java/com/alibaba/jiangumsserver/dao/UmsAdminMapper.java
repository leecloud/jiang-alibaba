package com.alibaba.jiangumsserver.dao;

import com.alibaba.jiangumsserver.model.UmsAdmin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName UmsAdminMapper
 * @Description: 后台用户持久层
 * @Author jiang
 * @Date 2020/8/19 13:49
 **/
@Mapper
public interface UmsAdminMapper extends BaseMapper<UmsAdmin> {
}
