package com.flamierd.booklibraryapi.domain.user.service.impl;

import com.flamierd.booklibraryapi.core.exception.NotFoundException;
import com.flamierd.booklibraryapi.domain.user.model.UserRole;
import com.flamierd.booklibraryapi.domain.user.repository.UserRoleRepository;
import com.flamierd.booklibraryapi.domain.user.service.UserRoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
@Service
public class UserRoleServiceImpl implements UserRoleService {
    private final UserRoleRepository userRoleRepository;

    @Override
    public Optional<UserRole> findByAuthority(String authority) {
        return userRoleRepository.findById(authority);
    }

    @Override
    public UserRole findByAuthorityOrThrow(String authority) {
        return findByAuthority(authority).orElseThrow(() ->
                new NotFoundException("Role with authority=%s has not found".formatted(authority)));
    }

    @Override
    public List<UserRole> getAllRoles() {
        return userRoleRepository.findAll();
    }

    @Override
    public Set<UserRole> getDefaultUserRoles() {
        Set<UserRole> defaultRoles = new HashSet<>();
        defaultRoles.add(findByAuthorityOrThrow("USER"));
        return defaultRoles;
    }
}
