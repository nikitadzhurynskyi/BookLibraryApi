package com.flamierd.booklibraryapi.domain.user.repository;

import com.flamierd.booklibraryapi.domain.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

}
