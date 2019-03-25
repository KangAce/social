package com.social.configuration.spring.security;

import com.social.core.pojo.user.User;
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
 * description :  验证通过之后,第二、三...请求，会调用此类
 * creation Date:  2018-05-02 4:32 PM
 */

@Component
public class BasicDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public BasicDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = null;
        try {
            user = userService.findOneByUserName(username);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (user == null) {
            throw new UsernameNotFoundException("Username  not  found.");
        }

        ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        AuthUser authUser = new AuthUser(username, user.getPassword(), grantedAuthorities);
        authUser.setUser(user);
        return authUser;

    }
}
