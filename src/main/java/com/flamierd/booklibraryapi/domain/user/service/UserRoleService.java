package com.flamierd.booklibraryapi.domain.user.service;

import com.flamierd.booklibraryapi.domain.user.model.UserRole;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserRoleService {
    Optional<UserRole> findByAuthority(String authority);

    UserRole findByAuthorityOrThrow(String authority);

    List<UserRole> getAllRoles();

    Set<UserRole> getDefaultUserRoles();
}
