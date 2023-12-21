package com.flamierd.booklibraryapi.domain.auth.usecase.impl;

import com.flamierd.booklibraryapi.core.exception.ForbiddenException;
import com.flamierd.booklibraryapi.domain.auth.mapper.RegisterRequestToCreateUserDtoMapper;
import com.flamierd.booklibraryapi.domain.auth.service.AuthService;
import com.flamierd.booklibraryapi.domain.auth.usecase.RegisterUseCase;
import com.flamierd.booklibraryapi.domain.auth.web.model.RegisterRequest;
import com.flamierd.booklibraryapi.domain.user.mapper.UserToUserResponseMapper;
import com.flamierd.booklibraryapi.domain.user.model.User;
import com.flamierd.booklibraryapi.domain.user.service.UserService;
import com.flamierd.booklibraryapi.domain.user.web.model.UserResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class RegisterUseCaseFacade implements RegisterUseCase {
    private final AuthService authService;

    private final UserService userService;

    private final RegisterRequestToCreateUserDtoMapper registerRequestToCreateUserDtoMapper;

    private final UserToUserResponseMapper userToUserResponseMapper;

    @Override
    public UserResponse register(RegisterRequest registerRequest) {
        authService.prepareRegisterRequest(registerRequest);

        if (userService.findByEmail(registerRequest.getEmail()).isPresent()) {
            throw new ForbiddenException("User with email=%s has already registered".formatted(registerRequest.getEmail()));
        }

        User user = userService.create(registerRequestToCreateUserDtoMapper.map(registerRequest));
        return userToUserResponseMapper.map(user);
    }
}
