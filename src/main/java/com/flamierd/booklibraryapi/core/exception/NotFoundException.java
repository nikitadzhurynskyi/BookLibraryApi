package com.flamierd.booklibraryapi.core.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends BookLibraryException {
    public NotFoundException() {
        setStatus(HttpStatus.NOT_FOUND);
    }

    public NotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
