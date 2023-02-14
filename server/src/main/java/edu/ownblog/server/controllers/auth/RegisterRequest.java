package edu.ownblog.server.controllers.auth;

import lombok.Data;

/**
 * @author Vladislav Glotov <glotov.vd@yandex.ru>
 * @version 1.0.0
 */

@Data
public class RegisterRequest {

    private String firstname;

    private String lastname;

    private String email;

    private String password;
}
