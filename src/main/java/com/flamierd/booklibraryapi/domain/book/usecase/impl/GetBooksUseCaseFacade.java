package com.flamierd.booklibraryapi.domain.book.usecase.impl;

import com.flamierd.booklibraryapi.domain.book.model.Book;
import com.flamierd.booklibraryapi.domain.book.service.BookService;
import com.flamierd.booklibraryapi.domain.book.usecase.GetBooksUseCase;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class GetBooksUseCaseFacade implements GetBooksUseCase {
    private final BookService bookService;

    @Override
    public List<Book> getMany(Integer pageNumber, Integer pageSize) {
        if (pageSize != null && pageSize > 0) {
            return bookService.findMany(PageRequest.of(pageNumber, pageSize));
        }
        return bookService.findMany();
    }

    @Override
    public Book getById(Long id) {
        return bookService.findByIdOrThrow(id);
    }
}
