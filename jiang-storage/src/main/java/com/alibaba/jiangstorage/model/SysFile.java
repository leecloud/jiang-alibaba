package com.alibaba.jiangstorage.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @ClassName SysFile
 * @Description: 资源对象
 * @Author jiang
 * @Date 2020/8/18 17:04
 **/
@Data
@TableName("sys_file")
public class SysFile implements Serializable {
    @TableId
    private Long id;
    private String fileName;
    private String url;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
}
