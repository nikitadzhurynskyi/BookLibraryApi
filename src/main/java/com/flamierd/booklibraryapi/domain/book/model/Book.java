package com.flamierd.booklibraryapi.domain.book.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
@Table(name = "books")
@Entity
public class Book {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(unique = true, nullable = false)
    private String title;

    private String description;

    @ElementCollection
    private Set<String> genres;

    @ElementCollection
    private Set<String> authors;
}
