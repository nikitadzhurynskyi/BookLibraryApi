package com.flamierd.booklibraryapi.domain.book.usecase.impl;

import com.flamierd.booklibraryapi.core.web.model.MessageResponse;
import com.flamierd.booklibraryapi.domain.book.service.BookService;
import com.flamierd.booklibraryapi.domain.book.usecase.DeleteBookUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class DeleteBookUseCaseFacade implements DeleteBookUseCase {
    private final BookService bookService;

    @Override
    public MessageResponse delete(Long id) {
        bookService.deleteById(id);
        return new MessageResponse("Book with id=%d deleted successfully.".formatted(id));
    }
}
