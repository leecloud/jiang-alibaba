package com.alibaba.jiangstorage.dao;

import com.alibaba.jiangstorage.model.SysFile;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName SysFileMapper
 * @Description:
 * @Author jiang
 * @Date 2020/8/18 17:05
 **/
@Mapper
public interface SysFileMapper extends BaseMapper<SysFile> {
    /**
     * 新增返回id
     * @param sysFile 对象
     * @return id
     */
    Long save(SysFile sysFile);
}
