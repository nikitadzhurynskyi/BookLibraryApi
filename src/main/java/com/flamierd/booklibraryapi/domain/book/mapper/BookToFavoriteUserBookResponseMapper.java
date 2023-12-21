package com.flamierd.booklibraryapi.domain.book.mapper;

import com.flamierd.booklibraryapi.core.mapper.Mapper;
import com.flamierd.booklibraryapi.domain.book.model.Book;
import com.flamierd.booklibraryapi.domain.book.web.model.FavoriteUserBookResponse;
import org.springframework.stereotype.Component;

@Component
public class BookToFavoriteUserBookResponseMapper implements Mapper<Book, FavoriteUserBookResponse> {
    @Override
    public FavoriteUserBookResponse map(Book source) {
        return new FavoriteUserBookResponse(source.getId(), source.getTitle());
    }
}
