package com.flamierd.booklibraryapi.domain.author.model;

import com.flamierd.booklibraryapi.domain.book.model.Book;
import jakarta.persistence.*;

import java.util.Set;

@Table(name = "authors")
@Entity
public class Author {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books;
}
