package com.flamierd.booklibraryapi.domain.user.web.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@AllArgsConstructor
@Setter
@Getter
public class UserResponse {
    private Long id;

    private String email;

    private Set<String> authorities;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
