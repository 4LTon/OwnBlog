package edu.ownblog.server.repositories;

import edu.ownblog.server.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Vladislav Glotov <glotov.vd@yandex.ru>
 * @version 1.0.0
 */

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
