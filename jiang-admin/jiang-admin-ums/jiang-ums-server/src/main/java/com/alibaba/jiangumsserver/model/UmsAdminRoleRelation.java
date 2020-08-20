package com.alibaba.jiangumsserver.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName UmsAdminRoleRelation
 * @Description:
 * @Author jiang
 * @Date 2020/8/19 16:05
 **/
@Data
@TableName(value = "ums_admin_role_relation")
public class UmsAdminRoleRelation implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Long adminId;
    private Long roleId;
}
