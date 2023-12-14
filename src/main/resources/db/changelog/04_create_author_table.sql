CREATE TABLE book_authors
(
    book_id BIGINT NOT NULL,
    authors VARCHAR(255)
);

CREATE TABLE book_genres
(
    book_id BIGINT NOT NULL,
    genres  VARCHAR(255)
);

ALTER TABLE book_authors
    ADD CONSTRAINT fk_book_authors_on_book FOREIGN KEY (book_id) REFERENCES books (id);

ALTER TABLE book_genres
    ADD CONSTRAINT fk_book_genres_on_book FOREIGN KEY (book_id) REFERENCES books (id);
