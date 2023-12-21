package com.flamierd.booklibraryapi.domain.user.dto;

import com.flamierd.booklibraryapi.domain.user.model.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Builder
@AllArgsConstructor
@Setter
@Getter
public final class CreateUserDto {
    private String email;

    private String password;

    private Set<UserRole> authorities;
}