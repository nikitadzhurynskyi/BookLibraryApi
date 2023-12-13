package com.flamierd.booklibraryapi.domain.auth.web.model;

public class LoginRequest extends RegisterRequest {
    public LoginRequest(String email, String password) {
        super(email, password);
    }
}
