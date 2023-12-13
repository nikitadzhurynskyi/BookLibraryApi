package com.flamierd.booklibraryapi.domain.auth.usecase;

import com.flamierd.booklibraryapi.domain.auth.web.model.JwtTokens;
import com.flamierd.booklibraryapi.domain.auth.web.model.LoginRequest;

public interface LoginUseCase {
    JwtTokens login(LoginRequest loginRequest);
}
