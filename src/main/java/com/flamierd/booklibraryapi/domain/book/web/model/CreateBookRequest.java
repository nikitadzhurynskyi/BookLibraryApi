package com.flamierd.booklibraryapi.domain.book.web.model;

import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class CreateBookRequest {
    private String title;

    private String description;

    private Set<String> genres;

    private Set<String> authors;
}
