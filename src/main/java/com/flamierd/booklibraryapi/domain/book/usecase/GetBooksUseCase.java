package com.flamierd.booklibraryapi.domain.book.usecase;

import com.flamierd.booklibraryapi.domain.book.model.Book;

import java.util.List;

public interface GetBooksUseCase {
    List<Book> getMany(Integer pageNumber, Integer pageSize);

    Book getById(Long id);
}
