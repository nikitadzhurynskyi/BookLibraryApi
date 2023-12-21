package com.flamierd.booklibraryapi.domain.book.usecase;

import com.flamierd.booklibraryapi.core.web.model.MessageResponse;

public interface DeleteBookUseCase {
    MessageResponse delete(Long id);
}
