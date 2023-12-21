package com.flamierd.booklibraryapi.domain.book.usecase.impl;

import com.flamierd.booklibraryapi.domain.book.model.Book;
import com.flamierd.booklibraryapi.domain.book.service.BookService;
import com.flamierd.booklibraryapi.domain.book.usecase.CreateBookUseCase;
import com.flamierd.booklibraryapi.domain.book.web.model.CreateBookRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class CreateBookUseCaseFacade implements CreateBookUseCase {
    private final BookService bookService;

    @Override
    public Book create(CreateBookRequest dto) {
        return bookService.create(dto);
    }
}
