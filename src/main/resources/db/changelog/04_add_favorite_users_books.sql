--liquibase formatted sql;

--changeset flamierd:10;
CREATE TABLE IF NOT EXISTS users_books
(
    book_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL
);
--rollback drop table if exists users_books;

--changeset flamierd:11;
ALTER TABLE users_books
    ADD CONSTRAINT fk_useboo_on_book FOREIGN KEY (book_id) REFERENCES books (id);

ALTER TABLE users_books
    ADD CONSTRAINT fk_useboo_on_user FOREIGN KEY (user_id) REFERENCES users (id);
--rollback alter table users_books drop constraint fk_useboo_on_book;
--rollback alter table users_books drop constraint fk_useboo_on_user;