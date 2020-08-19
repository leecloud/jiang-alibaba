package com.alibaba.jiangstorage.service.impl;

import com.alibaba.jiangstorage.dao.SysFileMapper;
import com.alibaba.jiangstorage.model.SysFile;
import com.alibaba.jiangstorage.service.SysFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName SysFileServiceImpl
 * @Description:
 * @Author jiang
 * @Date 2020/8/18 17:09
 **/
@Service
public class SysFileServiceImpl implements SysFileService {
    @Autowired
    private SysFileMapper sysFileMapper;
    @Override
    public Long save(SysFile sysFile) {
       return sysFileMapper.save(sysFile);

    }
}
