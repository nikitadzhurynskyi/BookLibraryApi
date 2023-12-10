package com.flamierd.booklibraryapi.core.exception.handler;

import com.flamierd.booklibraryapi.core.exception.BookLibraryException;
import com.flamierd.booklibraryapi.core.web.model.ExceptionResponse;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class BookLibraryExceptionHandler {
    @ExceptionHandler({BookLibraryException.class})
    public ExceptionResponse handleBookLibraryException(BookLibraryException ex, HttpServletResponse resp) {
        resp.setStatus(ex.getStatus().value());

        return ExceptionResponse.builder()
                .message(ex.getLocalizedMessage())
                .status(ex.getStatus().value())
                .date(LocalDateTime.now())
                .exception(ex.getClass().getSimpleName())
                .build();
    }
}
