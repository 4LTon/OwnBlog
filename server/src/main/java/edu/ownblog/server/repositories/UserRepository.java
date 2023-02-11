package edu.ownblog.server.repositories;

import edu.ownblog.server.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Vladislav Glotov <glotov.vd@yandex.ru>
 * @version 1.0.0
 */

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
