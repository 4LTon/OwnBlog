package edu.ownblog.server.controllers.posts;

import edu.ownblog.server.model.Post;
import edu.ownblog.server.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author Vladislav Glotov <glotov.vd@yandex.ru>
 * @version 1.0.0
 */

@Getter @Setter
public class PostResponse {

    private Long id;

    private String title;

    private String text;

    private int viewsCount;

    private String author;

    private LocalDateTime createdDate;

    public PostResponse(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.text = post.getText();
        this.viewsCount = post.getViewsCount();
        User user = post.getAuthor();
        this.author = String.format("%s.%s", user.getFirstname(), user.getLastname());
        this.createdDate = post.getCreatedDate();
    }
}
