package com.flamierd.booklibraryapi.domain.auth.service;

import com.flamierd.booklibraryapi.domain.auth.type.JwtTokenType;
import com.flamierd.booklibraryapi.domain.auth.web.model.JwtTokens;
import com.flamierd.booklibraryapi.domain.user.model.User;

import java.util.Date;

public interface JwtUtilsService {
    JwtTokens generateTokens(User user);

    String extractEmail(String token, JwtTokenType tokenType);

    Long extractUserId(String token, JwtTokenType tokenType);

    Date extractExpiration(String token, JwtTokenType tokenType);

    boolean isValid(String token, User user, JwtTokenType tokenType);

    boolean isValid(String token, JwtTokenType tokenType);
}
