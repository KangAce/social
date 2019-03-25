package com.social.base;

import com.social.configuration.spring.security.AuthUser;
import com.social.core.pojo.user.User;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author alvis
 */

public abstract class BaseController {

    protected final static String DEFAULT_PAGE_SIZE = "10";

    protected User getCurrentUser() {
        AuthUser authUser = (AuthUser) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        return authUser.getUser();
    }
}
