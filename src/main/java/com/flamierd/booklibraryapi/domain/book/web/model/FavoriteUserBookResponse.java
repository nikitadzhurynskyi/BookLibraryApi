package com.flamierd.booklibraryapi.domain.book.web.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Setter
@Getter
public class FavoriteUserBookResponse {
    private Long id;
    private String title;
}
