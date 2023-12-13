--liquibase formatted sql;

--changeset flamierd:5;
INSERT INTO roles (authority)
values ('USER');
INSERT INTO roles (authority)
values ('ADMIN');
--rollback truncate table roles;