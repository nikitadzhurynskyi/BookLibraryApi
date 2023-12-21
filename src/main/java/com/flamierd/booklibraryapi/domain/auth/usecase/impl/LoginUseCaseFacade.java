package com.flamierd.booklibraryapi.domain.auth.usecase.impl;

import com.flamierd.booklibraryapi.domain.auth.service.AuthService;
import com.flamierd.booklibraryapi.domain.auth.service.JwtUtilsService;
import com.flamierd.booklibraryapi.domain.auth.usecase.LoginUseCase;
import com.flamierd.booklibraryapi.domain.auth.web.model.JwtTokens;
import com.flamierd.booklibraryapi.domain.auth.web.model.LoginRequest;
import com.flamierd.booklibraryapi.domain.user.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class LoginUseCaseFacade implements LoginUseCase {
    private final AuthService authService;

    private final JwtUtilsService jwtUtilsService;

    @Override
    public JwtTokens login(LoginRequest loginRequest) {
        User user = authService.getUserForLogin(loginRequest);
        return jwtUtilsService.generateTokens(user);
    }
}
