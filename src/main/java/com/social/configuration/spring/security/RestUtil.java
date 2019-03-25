package com.social.configuration.spring.security;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.social.base.RestResponse;
import com.social.configuration.SystemCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author alvis
 */
class RestUtil {
    private static final Logger logger = LoggerFactory.getLogger(RestUtil.class);
    private static final ObjectMapper MAPPER = new ObjectMapper();

    static boolean isJson(HttpServletRequest request) {
        String contentType = request.getContentType();
        return null != contentType && (contentType.equals(MediaType.APPLICATION_JSON_UTF8_VALUE) || contentType.equals(MediaType.APPLICATION_JSON_VALUE));
    }

    static void response(HttpServletResponse response, SystemCode systemCode) {
        response(response, systemCode.getCode(), systemCode.getMessage());
    }

    static void response(HttpServletResponse response, int systemCode, String msg) {
        try {
            RestResponse res = new RestResponse(systemCode, msg);
            String resStr = MAPPER.writeValueAsString(res);
            response.getWriter().write(resStr);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }
}
