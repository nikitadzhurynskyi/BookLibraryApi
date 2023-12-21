package com.flamierd.booklibraryapi.domain.auth.service.impl;

import com.flamierd.booklibraryapi.core.exception.UnauthorizedException;
import com.flamierd.booklibraryapi.domain.auth.service.AuthService;
import com.flamierd.booklibraryapi.domain.auth.web.model.LoginRequest;
import com.flamierd.booklibraryapi.domain.auth.web.model.RegisterRequest;
import com.flamierd.booklibraryapi.domain.user.model.User;
import com.flamierd.booklibraryapi.domain.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {
    private final PasswordEncoder passwordEncoder;

    private final UserService userService;

    @Override
    public void prepareRegisterRequest(RegisterRequest request) {
        String encodedPassword = passwordEncoder.encode(request.getPassword());
        request.setPassword(encodedPassword);
    }

    @Override
    public User getUserForLogin(LoginRequest request) {
        User user = userService.findByEmailOrThrow(request.getEmail());
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new UnauthorizedException("Invalid user credentials.");
        }
        return user;
    }
}
