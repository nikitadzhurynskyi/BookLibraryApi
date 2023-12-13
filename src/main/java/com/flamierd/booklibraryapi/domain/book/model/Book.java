package com.flamierd.booklibraryapi.domain.book.model;

import com.flamierd.booklibraryapi.domain.author.model.Author;
import com.flamierd.booklibraryapi.domain.genre.model.Genre;
import jakarta.persistence.*;

import java.util.Set;

@Table(name = "books")
@Entity
public class Book {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(unique = true, nullable = false)
    private String title;

    private String description;

    @ManyToMany
    @JoinTable(
            name = "books_genres",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<Genre> genres;

    @ManyToMany
    @JoinTable(
            name = "books_authors",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<Author> authors;
}
