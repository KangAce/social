package com.social.configuration.spring.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.social.configuration.SystemCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author alvis
 */
@Component
public class FormAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        if (RestUtil.isJson(request)) {
            RestUtil.response(response, SystemCode.UNAUTHORIZED.getCode(), exception.getMessage());
        } else {
            this.setDefaultFailureUrl("/user/login?error=" + exception.getMessage());
            super.onAuthenticationFailure(request, response, exception);
        }
    }
}
