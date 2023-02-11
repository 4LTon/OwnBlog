package edu.ownblog.server.security;

import org.springframework.stereotype.Component;

/**
 * @author Vladislav Glotov <glotov.vd@yandex.ru>
 * @version 1.0.0
 */

@Component
public class SecurityConstant {

    public static String HEADER_STRING = "Authorization";

    public static String TOKEN_PREFIX = "Bearer ";

    public static String SECRET_KEY = "SecretKey";

    public static Long EXPIRATION_TIME = 600_000L;  // 10 min
}
