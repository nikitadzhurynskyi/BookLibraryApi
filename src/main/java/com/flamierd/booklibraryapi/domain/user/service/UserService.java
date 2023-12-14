package com.flamierd.booklibraryapi.domain.user.service;

import com.flamierd.booklibraryapi.domain.user.dto.CreateUserDto;
import com.flamierd.booklibraryapi.domain.user.model.User;
import com.flamierd.booklibraryapi.domain.user.web.model.UpdateRoleRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService extends UserDetailsService {
    Optional<User> findByEmail(String email);

    User findByEmailOrThrow(String email);

    User create(CreateUserDto dto);

    @Override
    User loadUserByUsername(String email);

    User updateUserRole(UpdateRoleRequest updateRoleRequest);
}
