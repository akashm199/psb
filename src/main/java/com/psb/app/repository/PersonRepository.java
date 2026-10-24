package com.psb.app.repository;

import com.psb.app.entity.Person;
import com.psb.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findByUser(User user);
    Optional<Person> findByEmail(String email);
}
