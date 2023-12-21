package com.flamierd.booklibraryapi.domain.user.mapper;

import com.flamierd.booklibraryapi.core.mapper.Mapper;
import com.flamierd.booklibraryapi.domain.book.mapper.BookToFavoriteUserBookResponseMapper;
import com.flamierd.booklibraryapi.domain.user.model.User;
import com.flamierd.booklibraryapi.domain.user.model.UserRole;
import com.flamierd.booklibraryapi.domain.user.web.model.UserResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class UserToUserResponseMapper implements Mapper<User, UserResponse> {
    private final BookToFavoriteUserBookResponseMapper bookMapper;

    @Override
    public UserResponse map(User source) {
        return new UserResponse(source.getId(),
                source.getEmail(),
                source.getAuthorities().stream().map(UserRole::getAuthority).collect(Collectors.toSet()),
                source.getFavoriteBooks().stream().map(bookMapper::map).collect(Collectors.toList()),
                source.getCreatedAt(),
                source.getCreatedAt());
    }
}
