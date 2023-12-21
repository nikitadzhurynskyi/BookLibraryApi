package com.flamierd.booklibraryapi.core.exception;

import org.springframework.http.HttpStatus;

public class UnauthorizedException extends BookLibraryException {
    public UnauthorizedException(String message) {
        super(message, HttpStatus.UNAUTHORIZED);
    }
}
