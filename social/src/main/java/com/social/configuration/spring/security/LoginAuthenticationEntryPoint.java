package com.social.configuration.spring.security;

import com.social.configuration.SystemCode;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author alvis
 */
@Component
public final class LoginAuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint {

    public LoginAuthenticationEntryPoint() {
        super("/user/login");
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        if (RestUtil.isJson(request)) {
            RestUtil.response(response, SystemCode.UNAUTHORIZED);
        } else {
            super.commence(request, response, authException);
        }
    }

}
