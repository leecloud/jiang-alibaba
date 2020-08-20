package com.alibaba.jiangumsserver.util;

import com.alibaba.jiangumsserver.enums.AdminStatus;
import com.alibaba.jiangumsserver.model.UmsAdmin;
import com.alibaba.jiangumsserver.model.UmsResource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName AdminUserDetails
 * @Description: 用户详情
 * @Author jiang
 * @Date 2020/8/19 15:30
 **/
public class AdminUserDetails implements UserDetails {
    private UmsAdmin umsAdmin;
    private List<UmsResource> resourceList;
    public AdminUserDetails(UmsAdmin umsAdmin,List<UmsResource> resourceList) {
        this.umsAdmin = umsAdmin;
        this.resourceList = resourceList;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //返回当前用户的角色
        return resourceList.stream()
                .map(role ->new SimpleGrantedAuthority(role.getId()+":"+role.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return umsAdmin.getPassword();
    }

    @Override
    public String getUsername() {
        return umsAdmin.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return umsAdmin.getStatus().equals(AdminStatus.ENABLE);
    }
}
