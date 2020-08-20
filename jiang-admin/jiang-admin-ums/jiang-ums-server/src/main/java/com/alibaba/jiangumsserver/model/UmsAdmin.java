package com.alibaba.jiangumsserver.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @ClassName UmsAdmin
 * @Description: 后台用户
 * @Author jiang
 * @Date 2020/8/19 13:41
 **/
@Data
@TableName("ums_admin")
public class UmsAdmin implements Serializable {
    @TableId
    private Long id;

    private String username;
    private String password;
    private String icon;
    private String email;
    private String nickName;
    private String note;
    private LocalDateTime createTime;
    private LocalDateTime loginTime;
    private Integer status;
}
