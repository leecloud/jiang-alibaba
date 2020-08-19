package com.alibaba.jiangstorage.service;

import com.alibaba.jiangstorage.model.SysFile;

/**
 * @ClassName SysFileService
 * @Description:
 * @Author jiang
 * @Date 2020/8/18 17:09
 **/
public interface SysFileService {
    /**
     * 保存
     * @param sysFile
     */
    Long save(SysFile sysFile);
}
