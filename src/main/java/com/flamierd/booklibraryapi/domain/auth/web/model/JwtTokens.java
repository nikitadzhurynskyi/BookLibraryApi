package com.flamierd.booklibraryapi.domain.auth.web.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class JwtTokens {
    private String accessToken;
    private String refreshToken;
}
