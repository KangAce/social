package com.social.configuration.spring.security;

import com.social.core.service.user.AuthenticationService;
import com.social.core.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @author :  Alvis
 * Description :  身份验证
 * Creation Date:  2018-05-02 5:00 PM
 */

@Component
public class FormAuthenticationProvider implements AuthenticationProvider {

    private final AuthenticationService authenticationService;

    private final UserService userService;

    @Autowired
    public FormAuthenticationProvider(AuthenticationService authenticationService, UserService userService) {
        this.authenticationService = authenticationService;
        this.userService = userService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();

        com.social.core.pojo.user.User user = null;
        try {
            user = userService.findOneByUserName(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (user == null) {
            throw new UsernameNotFoundException("Username  not found.");
        }

        boolean result = authenticationService.authUser(user, username, password);
        if (!result) {
            throw new BadCredentialsException("Username or Password error.");
        }

/*
        if (true) {
            throw new LockedException("Account Lock .");
        }
*/

        ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        User user1 = new User(user.getUsername(), user.getPassword(), grantedAuthorities);
        return new UsernamePasswordAuthenticationToken(user1, user1.getPassword(), user1.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
