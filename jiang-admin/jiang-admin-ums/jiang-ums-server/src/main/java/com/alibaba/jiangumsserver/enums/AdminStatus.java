package com.alibaba.jiangumsserver.enums;

/**
 * @ClassName AdminStatus
 * @Description: 帐号启用状态：0->禁用；1->启用
 * @Author jiang
 * @Date 2020/8/19 15:52
 **/
public enum AdminStatus {
    ENABLE(1,"启用"),
    NOENABLE(0,"禁用");

    private Integer code;
    private String message;

    AdminStatus(Integer code, String message){
        this.code = code;
        this.message = message;
    }
}
