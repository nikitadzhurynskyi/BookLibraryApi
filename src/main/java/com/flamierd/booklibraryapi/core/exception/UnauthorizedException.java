package com.flamierd.booklibraryapi.core.exception;

import org.springframework.http.HttpStatus;

public class UnauthorizedException extends BookLibraryException {
    public UnauthorizedException() {
        setStatus(HttpStatus.UNAUTHORIZED);
    }

    public UnauthorizedException(String message) {
        super(message, HttpStatus.UNAUTHORIZED);
    }
}
