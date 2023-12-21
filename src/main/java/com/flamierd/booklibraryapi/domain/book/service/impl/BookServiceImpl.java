package com.flamierd.booklibraryapi.domain.book.service.impl;

import com.flamierd.booklibraryapi.core.exception.NotFoundException;
import com.flamierd.booklibraryapi.domain.book.dto.BookDto;
import com.flamierd.booklibraryapi.domain.book.mapper.CreateBookRequestToBookDtoMapper;
import com.flamierd.booklibraryapi.domain.book.model.Book;
import com.flamierd.booklibraryapi.domain.book.repository.BookRepository;
import com.flamierd.booklibraryapi.domain.book.service.BookService;
import com.flamierd.booklibraryapi.domain.book.web.model.CreateBookRequest;
import com.flamierd.booklibraryapi.domain.book.web.model.UpdateBookRequest;
import com.flamierd.booklibraryapi.domain.user.model.User;
import com.flamierd.booklibraryapi.domain.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    private final UserRepository userRepository;

    private final CreateBookRequestToBookDtoMapper createBookRequestToBookDtoMapper;

    @Override
    public Book create(CreateBookRequest dto) {
        Book book = new Book();
        BookDto bookDto = createBookRequestToBookDtoMapper.map(dto);

        updateBookWithDto(book, bookDto);
        return bookRepository.save(book);
    }

    @Override
    public Book update(UpdateBookRequest dto) {
        Book book = findByIdOrThrow(dto.getId());
        BookDto bookDto = createBookRequestToBookDtoMapper.map(dto);

        updateBookWithDto(book, bookDto);
        return bookRepository.save(book);
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book findByIdOrThrow(Long id) {
        return findById(id).orElseThrow(() ->
                new NotFoundException("Book with id=%d has not found.".formatted(id)));
    }

    @Override
    public Optional<Book> findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    @Override
    public List<Book> findMany() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> findMany(Pageable pageable) {
        return bookRepository.findAll(pageable).getContent();
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public User addToFavorite(Long id, User user) {
        Book book = findByIdOrThrow(id);
        user.getFavoriteBooks().add(book);
        user.setFavoriteBooks(user.getFavoriteBooks());
        return userRepository.save(user);
    }

    @Override
    public User removeFromFavorite(Long id, User user) {
        user.getFavoriteBooks().removeIf(book -> id.equals(book.getId()));
        user.setFavoriteBooks(user.getFavoriteBooks());
        return userRepository.save(user);
    }

    private void updateBookWithDto(Book book, BookDto dto) {
        book.setTitle(dto.getTitle() == null ? book.getTitle() : dto.getTitle());
        book.setDescription(dto.getDescription() == null ? book.getDescription() : dto.getDescription());
        book.setAuthors(dto.getAuthors().isEmpty() ? book.getAuthors() : dto.getAuthors());
        book.setGenres(dto.getGenres().isEmpty() ? book.getGenres() : dto.getGenres());
    }
}
