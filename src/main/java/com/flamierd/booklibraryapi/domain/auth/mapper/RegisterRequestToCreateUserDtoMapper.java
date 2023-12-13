package com.flamierd.booklibraryapi.domain.auth.mapper;

import com.flamierd.booklibraryapi.core.mapper.Mapper;
import com.flamierd.booklibraryapi.domain.auth.web.model.RegisterRequest;
import com.flamierd.booklibraryapi.domain.user.dto.CreateUserDto;
import org.springframework.stereotype.Component;

@Component
public class RegisterRequestToCreateUserDtoMapper implements Mapper<RegisterRequest, CreateUserDto> {
    @Override
    public CreateUserDto map(RegisterRequest source) {
        return new CreateUserDto(source.getEmail(), source.getPassword(), null);
    }
}
