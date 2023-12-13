package com.flamierd.booklibraryapi.domain.auth.web;

import com.flamierd.booklibraryapi.core.web.model.MessageResponse;
import com.flamierd.booklibraryapi.domain.auth.usecase.LoginUseCase;
import com.flamierd.booklibraryapi.domain.auth.usecase.RefreshTokensUseCase;
import com.flamierd.booklibraryapi.domain.auth.usecase.RegisterUseCase;
import com.flamierd.booklibraryapi.domain.auth.web.model.JwtTokens;
import com.flamierd.booklibraryapi.domain.auth.web.model.LoginRequest;
import com.flamierd.booklibraryapi.domain.auth.web.model.RegisterRequest;
import com.flamierd.booklibraryapi.domain.user.model.User;
import com.flamierd.booklibraryapi.domain.user.web.model.UserResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RequestMapping("/api/auth")
@RestController
public class AuthController {
    private final RegisterUseCase registerUseCase;
    private final LoginUseCase loginUseCase;
    private final RefreshTokensUseCase refreshTokensUseCase;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/register")
    public UserResponse register(@Valid @RequestBody RegisterRequest registerRequest) {
        return registerUseCase.register(registerRequest);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/login")
    public JwtTokens login(@Valid @RequestBody LoginRequest loginRequest) {
        return loginUseCase.login(loginRequest);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/refresh")
    public JwtTokens refresh(@RequestBody String refreshToken) {
        return refreshTokensUseCase.refresh(refreshToken);
    }

    @GetMapping("/check")
    public MessageResponse checkAuthentication(@AuthenticationPrincipal User principal) {
        return new MessageResponse(principal.getEmail());
    }
}
