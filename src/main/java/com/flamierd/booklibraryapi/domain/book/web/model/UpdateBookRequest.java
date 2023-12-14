package com.flamierd.booklibraryapi.domain.book.web.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UpdateBookRequest extends CreateBookRequest {
    private Long id;
}
