
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
 * @author alvis
 */

@Component
public class BasicAuthenticationProvider implements AuthenticationProvider {

    private final UserService userService;

    private final AuthenticationService authenticationService;

    @Autowired
    public BasicAuthenticationProvider(UserService userService, AuthenticationService authenticationService) {
        this.userService = userService;
        this.authenticationService = authenticationService;
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
            throw new UsernameNotFoundException("User  not found.");
        }

        boolean result = authenticationService.authUser(username, password);
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
