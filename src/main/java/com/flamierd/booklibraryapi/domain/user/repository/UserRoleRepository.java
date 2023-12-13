package com.flamierd.booklibraryapi.domain.user.repository;

import com.flamierd.booklibraryapi.domain.user.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, String> {
}
