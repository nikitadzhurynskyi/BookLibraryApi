package com.flamierd.booklibraryapi.domain.book.usecase;

import jakarta.servlet.http.HttpServletResponse;

public interface DownloadBookUseCase {
    void download(HttpServletResponse response);
}
