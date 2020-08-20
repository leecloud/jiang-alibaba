package com.alibaba.jiangumsserver.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @ClassName LoginParam
 * @Description: 登录参数
 * @Author jiang
 * @Date 2020/8/19 14:16
 **/
@Data
public class LoginParam {
    @NotEmpty(message = "用户名不能为空")
    private String username;
    @NotEmpty(message = "密码不能为空")
    private String password;
}
