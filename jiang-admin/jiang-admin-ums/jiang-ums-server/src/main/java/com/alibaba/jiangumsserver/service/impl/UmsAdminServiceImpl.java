package com.alibaba.jiangumsserver.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.jiangumsserver.dao.UmsAdminLoginLogMapper;
import com.alibaba.jiangumsserver.dao.UmsAdminMapper;
import com.alibaba.jiangumsserver.dao.UmsAdminRoleRelationDao;
import com.alibaba.jiangumsserver.dto.LoginParam;
import com.alibaba.jiangumsserver.model.UmsAdmin;
import com.alibaba.jiangumsserver.model.UmsAdminLoginLog;
import com.alibaba.jiangumsserver.model.UmsResource;
import com.alibaba.jiangumsserver.service.UmsAdminService;
import com.alibaba.jiangumsserver.util.AdminUserDetails;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiang.api.ApiResult;
import com.jiang.exception.ApiException;
import com.jiang.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName UmsAdminServiceImpl
 * @Description: 后台用户业务逻辑层
 * @Author jiang
 * @Date 2020/8/19 14:19
 **/
@Service
public class UmsAdminServiceImpl extends ServiceImpl<UmsAdminMapper, UmsAdmin> implements UmsAdminService {
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    UmsAdminCacheServiceImpl adminCacheService;
    @Autowired
    UmsAdminRoleRelationDao umsAdminRoleRelationDao;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    JwtTokenUtil jwtTokenUtil;
    @Autowired
    UmsAdminLoginLogMapper umsAdminLoginLogMapper;
    @Autowired
    UmsAdminMapper adminMapper;
    @Override
    public ApiResult login(LoginParam param) {
        String token = null;
        UmsAdmin umsAdmin = adminMapper.selectOne(new QueryWrapper<>(new UmsAdmin()).lambda().eq(UmsAdmin::getUsername, param.getUsername()));
        if (umsAdmin == null){
            throw new ApiException("用户不存在");
        }
        List<UmsResource> resourceList = getResourceList(umsAdmin.getId());
        AdminUserDetails details = new AdminUserDetails(umsAdmin, resourceList);
        if(!passwordEncoder.matches(param.getPassword(),details.getPassword())){
            throw new BadCredentialsException("密码不正确");
        }
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(details, null, details.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        token = jwtTokenUtil.generateToken(details);
        adminCacheService.setToken(param.getUsername(), tokenHead+token);
        insertLoginLog(param.getUsername());
        Map<String, Object> map = new HashMap<>();
        map.put("token",token);
        map.put("tokenHead",tokenHead);
        return ApiResult.success(map);
    }

    @Override
    public List<UmsResource> getResourceList(Long adminId) {
        List<UmsResource> resourceList = adminCacheService.getResourceList(adminId);
        if (CollectionUtil.isNotEmpty(resourceList)){
            return resourceList;
        }
        resourceList = umsAdminRoleRelationDao.getResourceList(adminId);
        if (CollectionUtil.isNotEmpty(resourceList)){
            adminCacheService.setResourceList(adminId,resourceList);
        }
        return resourceList;
    }

    /**
     * 添加登录记录
     * @param username 用户名
     */
    private void insertLoginLog(String username) {
        UmsAdmin admin = adminMapper.selectOne(new QueryWrapper<>(new UmsAdmin()).lambda().eq(UmsAdmin::getUsername, username));
        if(admin==null) {
            return;
        }
        UmsAdminLoginLog loginLog = new UmsAdminLoginLog();
        loginLog.setAdminId(admin.getId());
        loginLog.setCreateTime(LocalDateTime.now());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        loginLog.setIp(request.getRemoteAddr());
        umsAdminLoginLogMapper.insert(loginLog);
    }
}
