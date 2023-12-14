package com.flamierd.booklibraryapi.domain.user.web.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class UpdateRoleRequest {
    private String email;

    private String role;
}
