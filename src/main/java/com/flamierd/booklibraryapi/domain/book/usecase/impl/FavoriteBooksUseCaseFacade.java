package com.flamierd.booklibraryapi.domain.book.usecase.impl;

import com.flamierd.booklibraryapi.domain.book.service.BookService;
import com.flamierd.booklibraryapi.domain.book.usecase.FavoriteBooksUseCase;
import com.flamierd.booklibraryapi.domain.book.web.model.AddToFavoriteBookRequest;
import com.flamierd.booklibraryapi.domain.user.mapper.UserToUserResponseMapper;
import com.flamierd.booklibraryapi.domain.user.model.User;
import com.flamierd.booklibraryapi.domain.user.web.model.UserResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class FavoriteBooksUseCaseFacade implements FavoriteBooksUseCase {
    private final BookService bookService;

    private final UserToUserResponseMapper userToUserResponseMapper;

    @Override
    public UserResponse addBookToFavorites(AddToFavoriteBookRequest addToFavoriteBookRequest, User user) {
        return userToUserResponseMapper.map(
                bookService.addToFavorite(addToFavoriteBookRequest.getBookId(), user)
        );
    }

    @Override
    public UserResponse removeBookFromFavorites(Long id, User user) {
        return userToUserResponseMapper.map(bookService.removeFromFavorite(id, user));
    }
}
