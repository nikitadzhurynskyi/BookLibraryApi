package com.flamierd.booklibraryapi.domain.book.mapper;

import com.flamierd.booklibraryapi.core.mapper.Mapper;
import com.flamierd.booklibraryapi.domain.book.dto.BookDto;
import com.flamierd.booklibraryapi.domain.book.web.model.CreateBookRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@AllArgsConstructor
@Component
public class CreateBookRequestToBookDtoMapper implements Mapper<CreateBookRequest, BookDto> {
    @Override
    public BookDto map(CreateBookRequest source) {
        return BookDto.builder()
                .title(source.getTitle())
                .description(source.getDescription())
                .authors(source.getAuthors() == null ? new HashSet<>() : source.getAuthors())
                .genres(source.getGenres() == null ? new HashSet<>() : source.getGenres())
                .build();
    }
}
