package com.flamierd.booklibraryapi.domain.book.usecase.impl;

import com.flamierd.booklibraryapi.domain.book.model.Book;
import com.flamierd.booklibraryapi.domain.book.service.BookService;
import com.flamierd.booklibraryapi.domain.book.usecase.UpdateBookUseCase;
import com.flamierd.booklibraryapi.domain.book.web.model.UpdateBookRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class UpdateBookUseCaseFacade implements UpdateBookUseCase {
    private final BookService bookService;

    @Override
    public Book update(UpdateBookRequest dto) {
        return bookService.update(dto);
    }
}
