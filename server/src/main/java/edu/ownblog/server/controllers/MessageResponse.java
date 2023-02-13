package edu.ownblog.server.controllers;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Vladislav Glotov <glotov.vd@yandex.ru>
 * @version 1.0.0
 */

@Data
@AllArgsConstructor
public class MessageResponse {

    private String message;
}
