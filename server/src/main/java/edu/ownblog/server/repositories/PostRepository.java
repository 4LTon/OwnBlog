package edu.ownblog.server.repositories;

import edu.ownblog.server.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Vladislav Glotov <glotov.vd@yandex.ru>
 * @version 1.0.0
 */

public interface PostRepository extends JpaRepository<Post, Long> {
}
