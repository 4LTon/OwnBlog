package edu.ownblog.server.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Vladislav Glotov <glotov.vd@yandex.ru>
 * @version 1.0.0
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PostNotFoundException extends RuntimeException {
    public PostNotFoundException(String msg) {
        super(msg);
    }
}

