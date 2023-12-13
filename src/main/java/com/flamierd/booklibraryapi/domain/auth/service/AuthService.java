package com.flamierd.booklibraryapi.domain.auth.service;

import com.flamierd.booklibraryapi.domain.auth.web.model.LoginRequest;
import com.flamierd.booklibraryapi.domain.auth.web.model.RegisterRequest;
import com.flamierd.booklibraryapi.domain.user.model.User;
public interface AuthService {
    void prepareRegisterRequest(RegisterRequest request);

    User getUserForLogin(LoginRequest request);
}
