package com.alibaba.jiangumsserver.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @ClassName UmsResource
 * @Description: 后台资源
 * @Author jiang
 * @Date 2020/8/19 15:42
 **/
@Data
@TableName("ums_resource")
public class UmsResource implements Serializable {
    @TableId
    private Long id;
    private LocalDateTime createTime;
    private String name;
    private String url;
    private String description;
    private Long categoryId;

}
