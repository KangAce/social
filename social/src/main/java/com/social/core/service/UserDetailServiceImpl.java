package com.social.core.service;
import com.social.core.pojo.user.Permission;
import com.social.core.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author kang
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private UserService userService;

    public UserService getUserService() {
        return userService;
    }
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.social.core.pojo.user.User user = null;
        try {
            user = userService.findOneByUserName(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
///        System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
        if (user == null) {
            return null;
        } else if ("0".equals(user.getStatus())) {
            throw new UsernameNotFoundException("用户处于非正常状态");
        } else {
            ///创建权限集合
            List<GrantedAuthority> grantedList = new ArrayList<>();
            ///向权限集合中添加权限
            List<Permission> permissionByUserId = null;
            try {
                permissionByUserId = userService.findPermissionByUserId(user.getId());
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (permissionByUserId != null) {
                for (Permission aPermissionByUserId : permissionByUserId) {
                    System.out.println(aPermissionByUserId.getName());
                    grantedList.add(new SimpleGrantedAuthority(aPermissionByUserId.getName()));
                }
            }
///            System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
            ///更新用户登录时间
            try {
                user.setLastLoginTime(new Date());
                userService.saveUser(user);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return new User(username, user.getPassword(), grantedList);
        }
    }

}
