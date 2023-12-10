package com.flamierd.booklibraryapi.domain.auth.web;

import com.flamierd.booklibraryapi.domain.auth.usecase.RegisterUseCase;
import com.flamierd.booklibraryapi.domain.auth.web.model.RegisterRequest;
import com.flamierd.booklibraryapi.domain.user.web.model.UserResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RequestMapping("/api/auth")
@RestController
public class AuthController {
    private final RegisterUseCase registerUseCase;

    @PostMapping("/register")
    public UserResponse register(@RequestBody RegisterRequest registerRequest) {
        return registerUseCase.register(registerRequest);
    }
}
