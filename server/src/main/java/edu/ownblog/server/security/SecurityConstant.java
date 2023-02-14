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

    public static String SECRET_KEY = "703373367639792442264529482B4D6251655468576D5A7134743777217A2543";

    public static Long EXPIRATION_TIME = 600_000L;  // 10 min
}
