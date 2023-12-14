package com.flamierd.booklibraryapi.domain.book.service;

import com.flamierd.booklibraryapi.domain.book.model.Book;
import com.flamierd.booklibraryapi.domain.book.web.model.CreateBookRequest;
import com.flamierd.booklibraryapi.domain.book.web.model.UpdateBookRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Book create(CreateBookRequest createBookDto);

    Book update(UpdateBookRequest updateBookDto);

    Optional<Book> findById(Long id);

    Book findByIdOrThrow(Long id);

    Optional<Book> findByTitle(String title);

    List<Book> findMany();

    List<Book> findMany(Pageable pageable);

    void deleteById(Long id);

}
