package com.flamierd.booklibraryapi.domain.auth.service.impl;

import com.flamierd.booklibraryapi.domain.auth.service.AuthService;
import com.flamierd.booklibraryapi.domain.auth.web.model.RegisterRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {
    private final PasswordEncoder passwordEncoder;

    @Override
    public void prepareRegisterRequest(RegisterRequest request) {
        String encodedPassword = passwordEncoder.encode(request.getPassword());
        request.setPassword(encodedPassword);
    }
}
