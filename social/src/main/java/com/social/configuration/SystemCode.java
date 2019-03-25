package com.social.configuration;

/**
 * @author alvis
 */
public enum SystemCode {
    /**
     * OK
     */
    OK(1, "Ok!"),
    /**
     * AccessTokenError
     */
    AccessTokenError(400, "AccessToken Unvalidated!"),
    /**
     * UNAUTHORIZED
     */
    UNAUTHORIZED(401, "User UNAUTHORIZED!"),
    /**
     * InnerError
     */
    InnerError(500, "Api Inner Exception!"),
    /**
     * RestFulInnerError
     */
    RestFulInnerError(501, "Web Api Inner Exception!");

    int code;
    String message;

    SystemCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
