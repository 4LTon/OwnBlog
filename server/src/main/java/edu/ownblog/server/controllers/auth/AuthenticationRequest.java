package edu.ownblog.server.controllers.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author Vladislav Glotov <glotov.vd@yandex.ru>
 * @version 1.0.0
 */

@Data
@Builder
@AllArgsConstructor
public class AuthenticationRequest {

    private String email;

    private String password;
}
