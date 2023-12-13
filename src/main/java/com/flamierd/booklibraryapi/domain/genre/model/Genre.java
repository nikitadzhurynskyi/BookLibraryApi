package com.flamierd.booklibraryapi.domain.genre.model;

import com.flamierd.booklibraryapi.domain.book.model.Book;
import jakarta.persistence.*;

import java.util.Set;

@Table(name = "genres")
@Entity
public class Genre {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @ManyToMany(mappedBy = "genres")
    private Set<Book> books;
}
