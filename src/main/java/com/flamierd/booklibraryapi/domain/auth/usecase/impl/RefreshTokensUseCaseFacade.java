package com.flamierd.booklibraryapi.domain.auth.usecase.impl;

import com.flamierd.booklibraryapi.core.exception.ForbiddenException;
import com.flamierd.booklibraryapi.domain.auth.service.JwtUtilsService;
import com.flamierd.booklibraryapi.domain.auth.type.JwtTokenType;
import com.flamierd.booklibraryapi.domain.auth.usecase.RefreshTokensUseCase;
import com.flamierd.booklibraryapi.domain.auth.web.model.JwtTokens;
import com.flamierd.booklibraryapi.domain.user.model.User;
import com.flamierd.booklibraryapi.domain.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class RefreshTokensUseCaseFacade implements RefreshTokensUseCase {
    private final JwtUtilsService jwtUtilsService;

    private final UserService userService;

    @Override
    public JwtTokens refresh(String refreshToken) {
        String userEmail = jwtUtilsService.extractEmail(refreshToken, JwtTokenType.REFRESH);
        User user = userService.findByEmailOrThrow(userEmail);
        if (jwtUtilsService.isValid(refreshToken, user, JwtTokenType.REFRESH)) {
            return jwtUtilsService.generateTokens(user);
        }
        throw new ForbiddenException("Invalid refresh token.");
    }
}
