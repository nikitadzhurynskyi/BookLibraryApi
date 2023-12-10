package com.flamierd.booklibraryapi.domain.auth.service;

import com.flamierd.booklibraryapi.domain.auth.web.model.RegisterRequest;

public interface AuthService {
    void prepareRegisterRequest(RegisterRequest request);
}
