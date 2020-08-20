package com.alibaba.jiangumsserver.controller;

import com.alibaba.jiangumsserver.dto.LoginParam;
import com.alibaba.jiangumsserver.service.UmsAdminService;
import com.jiang.api.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UmsAdminController
 * @Description: 后台用户控制层
 * @Author jiang
 * @Date 2020/8/19 14:11
 **/
@RestController
@RequestMapping("/admin")
public class UmsAdminController {
    @Autowired(required = true)
    private UmsAdminService umsAdminService;

    @PostMapping(value = "/login")
    public ApiResult login(@RequestBody LoginParam param, BindingResult result){
        return umsAdminService.login(param);
    }
}
