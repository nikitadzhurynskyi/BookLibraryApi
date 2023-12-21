package com.flamierd.booklibraryapi.domain.book.usecase;

import com.flamierd.booklibraryapi.domain.book.model.Book;
import com.flamierd.booklibraryapi.domain.book.web.model.CreateBookRequest;

public interface CreateBookUseCase {
    Book create(CreateBookRequest dto);
}
