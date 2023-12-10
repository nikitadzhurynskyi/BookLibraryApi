package com.flamierd.booklibraryapi.domain.auth.usecase;

import com.flamierd.booklibraryapi.domain.auth.web.model.RegisterRequest;
import com.flamierd.booklibraryapi.domain.user.web.model.UserResponse;

public interface RegisterUseCase {
    UserResponse register(RegisterRequest registerRequest);
}
