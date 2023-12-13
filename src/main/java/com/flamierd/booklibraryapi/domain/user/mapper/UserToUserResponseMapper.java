package com.flamierd.booklibraryapi.domain.user.mapper;

import com.flamierd.booklibraryapi.core.mapper.Mapper;
import com.flamierd.booklibraryapi.domain.user.model.User;
import com.flamierd.booklibraryapi.domain.user.model.UserRole;
import com.flamierd.booklibraryapi.domain.user.web.model.UserResponse;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UserToUserResponseMapper implements Mapper<User, UserResponse> {
    @Override
    public UserResponse map(User source) {
        return new UserResponse(source.getId(),
                source.getEmail(),
                source.getAuthorities().stream().map(UserRole::getAuthority).collect(Collectors.toSet()),
                source.getCreatedAt(),
                source.getCreatedAt());
    }
}
