package com.flamierd.booklibraryapi.domain.book.usecase;

import com.flamierd.booklibraryapi.domain.book.model.Book;
import com.flamierd.booklibraryapi.domain.book.web.model.UpdateBookRequest;

public interface UpdateBookUseCase {
    Book update(UpdateBookRequest dto);
}
