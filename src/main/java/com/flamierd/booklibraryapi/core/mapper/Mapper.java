package com.flamierd.booklibraryapi.core.mapper;

public interface Mapper<T, V> {
    V map(T source);
}
