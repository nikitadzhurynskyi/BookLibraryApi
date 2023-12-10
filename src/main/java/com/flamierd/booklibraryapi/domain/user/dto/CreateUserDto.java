package com.flamierd.booklibraryapi.domain.user.dto;

import com.flamierd.booklibraryapi.domain.user.model.UserRole;
import lombok.Builder;

import java.io.Serializable;
import java.util.Set;


@Builder
public record CreateUserDto(String email,
                            String password,
                            Set<UserRole> authorities) implements Serializable {
}