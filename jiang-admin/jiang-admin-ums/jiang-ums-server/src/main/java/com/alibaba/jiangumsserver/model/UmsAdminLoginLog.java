package com.alibaba.jiangumsserver.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @ClassName UmsAdminLoginLog
 * @Description:
 * @Author jiang
 * @Date 2020/8/19 16:44
 **/
@Data
@TableName("ums_admin_login_log")
public class UmsAdminLoginLog implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Long adminId;
    private LocalDateTime createTime;
    private String ip;
    private String address;
    private String userAgent;
}
