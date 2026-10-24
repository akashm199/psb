package com.psb.app.repository;

import com.psb.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    default Optional<User> findByUsernameOrEmail(String username, String email) {
        return findByUsername(username).or(() -> findByEmail(email));
    }
}
