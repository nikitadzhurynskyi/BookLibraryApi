package com.flamierd.booklibraryapi.domain.user.dto;

import com.flamierd.booklibraryapi.domain.user.model.UserRole;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link com.flamierd.booklibraryapi.domain.user.model.User}
 */
@EqualsAndHashCode(callSuper = true)
@Value
public record CreateUserDto(String email,
                            String password,
                            Set<UserRole> authorities) implements Serializable {
}