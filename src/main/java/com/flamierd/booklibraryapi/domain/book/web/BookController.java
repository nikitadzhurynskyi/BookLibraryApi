package com.flamierd.booklibraryapi.domain.book.web;

import com.flamierd.booklibraryapi.core.web.model.MessageResponse;
import com.flamierd.booklibraryapi.domain.book.model.Book;
import com.flamierd.booklibraryapi.domain.book.usecase.*;
import com.flamierd.booklibraryapi.domain.book.web.model.AddToFavoriteBookRequest;
import com.flamierd.booklibraryapi.domain.book.web.model.CreateBookRequest;
import com.flamierd.booklibraryapi.domain.book.web.model.UpdateBookRequest;
import com.flamierd.booklibraryapi.domain.user.model.User;
import com.flamierd.booklibraryapi.domain.user.web.model.UserResponse;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("/api/books")
@RestController
public class BookController {
    private final CreateBookUseCase createBookUseCase;

    private final GetBooksUseCase getBooksUseCase;

    private final UpdateBookUseCase updateBookUseCase;

    private final DeleteBookUseCase deleteBookUseCase;

    private final DownloadBookUseCase downloadBookUseCase;

    private final FavoriteBooksUseCase favoriteBooksUseCase;

    @PostMapping
    public Book create(@RequestBody CreateBookRequest dto) {
        return createBookUseCase.create(dto);
    }

    @PutMapping
    public Book update(@RequestBody UpdateBookRequest dto) {
        return updateBookUseCase.update(dto);
    }

    @GetMapping
    public List<Book> getMany(@RequestParam(name = "page", defaultValue = "0", required = false) Integer pageNumber,
                              @RequestParam(name = "page_size", required = false) Integer pageSize) {
        return getBooksUseCase.getMany(pageNumber, pageSize);
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable Long id) {
        return getBooksUseCase.getById(id);
    }

    @GetMapping(value = "/download")
    public void downloadBooks(HttpServletResponse response) {
        downloadBookUseCase.download(response);
    }

    @DeleteMapping("/{id}")
    public MessageResponse delete(@PathVariable Long id) {
        return deleteBookUseCase.delete(id);
    }

    @PostMapping("/favorite")
    public UserResponse addBookToFavorites(@RequestBody AddToFavoriteBookRequest addToFavoriteBookRequest,
                                           @AuthenticationPrincipal User user) {
        return favoriteBooksUseCase.addBookToFavorites(addToFavoriteBookRequest, user);
    }

    @DeleteMapping("/favorite/{id}")
    public UserResponse removeBookFromFavorites(@PathVariable Long id,
                                                @AuthenticationPrincipal User user) {
        return favoriteBooksUseCase.removeBookFromFavorites(id, user);
    }
}
