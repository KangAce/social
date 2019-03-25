package com.social.configuration.spring.security;

import com.social.core.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @author :  Alvis
 * Description :  验证通过之后,第二、三...请求，会调用此类
 * Creation Date:  2018-05-02 4:32 PM
 */

@Component
public class FormDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public FormDetailsServiceImpl(UserService userService) {
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

        if (user == null) {
            throw new UsernameNotFoundException("Username  not found.");
        }

        ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        AuthUser authUser = new AuthUser(user.getUsername(), user.getPassword(), grantedAuthorities);
        authUser.setUser(user);
        return authUser;
    }
}
