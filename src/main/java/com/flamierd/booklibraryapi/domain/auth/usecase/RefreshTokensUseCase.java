package com.flamierd.booklibraryapi.domain.auth.usecase;

import com.flamierd.booklibraryapi.domain.auth.web.model.JwtTokens;

public interface RefreshTokensUseCase {
    JwtTokens refresh(String refreshToken);
}
