package com.flamierd.booklibraryapi.domain.user.service.impl;

import com.flamierd.booklibraryapi.core.exception.NotFoundException;
import com.flamierd.booklibraryapi.domain.user.dto.CreateUserDto;
import com.flamierd.booklibraryapi.domain.user.model.User;
import com.flamierd.booklibraryapi.domain.user.model.UserRole;
import com.flamierd.booklibraryapi.domain.user.repository.UserRepository;
import com.flamierd.booklibraryapi.domain.user.service.UserRoleService;
import com.flamierd.booklibraryapi.domain.user.service.UserService;
import com.flamierd.booklibraryapi.domain.user.web.model.UpdateRoleRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final UserRoleService userRoleService;

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findByEmailOrThrow(String email) {
        return findByEmail(email).orElseThrow(() ->
                new NotFoundException("User with email=%s has not found".formatted(email)));
    }

    @Override
    public User create(CreateUserDto dto) {
        Set<UserRole> authorities = dto.authorities() != null ? dto.authorities() : userRoleService.getDefaultUserRoles();
        User user = User.builder()
                .email(dto.email())
                .password(dto.password())
                .authorities(authorities)
                .build();
        return userRepository.save(user);
    }

    @Override
    public User loadUserByUsername(String email) {
        return findByEmailOrThrow(email);
    }

    @Override
    public User updateUserRole(UpdateRoleRequest updateRoleRequest) {
        User user = findByEmailOrThrow(updateRoleRequest.getEmail());

        Set<UserRole> roles = user.getAuthorities();
        roles.add(userRoleService.findByAuthorityOrThrow(updateRoleRequest.getRole()));
        user.setAuthorities(roles);

        return userRepository.save(user);
    }
}
