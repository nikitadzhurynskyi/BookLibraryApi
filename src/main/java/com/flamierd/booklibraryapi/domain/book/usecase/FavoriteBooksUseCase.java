package com.flamierd.booklibraryapi.domain.book.usecase;

import com.flamierd.booklibraryapi.domain.book.web.model.AddToFavoriteBookRequest;
import com.flamierd.booklibraryapi.domain.user.model.User;
import com.flamierd.booklibraryapi.domain.user.web.model.UserResponse;

public interface FavoriteBooksUseCase {
    UserResponse addBookToFavorites(AddToFavoriteBookRequest addToFavoriteBookRequest, User user);

    UserResponse removeBookFromFavorites(Long id, User user);
}
