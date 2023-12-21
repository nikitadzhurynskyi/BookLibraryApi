package com.flamierd.booklibraryapi.domain.user.web.model;

import com.flamierd.booklibraryapi.domain.book.web.model.FavoriteUserBookResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Setter
@Getter
public class UserResponse {
    private Long id;

    private String email;

    private Set<String> authorities;

    private List<FavoriteUserBookResponse> favoriteBooks;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
