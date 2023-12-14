package com.flamierd.booklibraryapi.domain.book.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Builder
@AllArgsConstructor
@Setter
@Getter
public class BookDto implements Serializable {
    private Long id;

    private String title;

    private String description;

    private Set<String> genres;

    private Set<String> authors;
}