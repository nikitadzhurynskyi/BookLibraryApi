package com.flamierd.booklibraryapi.core.exception;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
public class BookLibraryException extends RuntimeException {
    private HttpStatus status;

    @Getter(AccessLevel.NONE)
    private final HttpStatus DEFAULT_HTTP_STATUS = HttpStatus.BAD_REQUEST;


    public BookLibraryException() {
        super();
        this.status = DEFAULT_HTTP_STATUS;
    }

    public BookLibraryException(String message) {
        super(message);
        this.status = DEFAULT_HTTP_STATUS;
    }

    public BookLibraryException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
