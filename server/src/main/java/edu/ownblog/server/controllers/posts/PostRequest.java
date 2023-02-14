package edu.ownblog.server.controllers.posts;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Vladislav Glotov <glotov.vd@yandex.ru>
 * @version 1.0.0
 */

@Data
@AllArgsConstructor
public class PostRequest {

    private String title;

    private String text;
}
