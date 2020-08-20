package com.alibaba.jiangumsserver.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @ClassName UmsRole
 * @Description:
 * @Author jiang
 * @Date 2020/8/19 16:18
 **/
@Data
@TableName("ums_role")
public class UmsRole implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private String description;
    private Integer adminCount;
    private LocalDateTime createTime;
    private Integer status;
    private Integer sort;
}
