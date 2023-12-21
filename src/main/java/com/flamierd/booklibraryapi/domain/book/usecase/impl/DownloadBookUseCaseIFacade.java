package com.flamierd.booklibraryapi.domain.book.usecase.impl;

import com.flamierd.booklibraryapi.core.exception.BookLibraryException;
import com.flamierd.booklibraryapi.domain.book.model.Book;
import com.flamierd.booklibraryapi.domain.book.service.BookService;
import com.flamierd.booklibraryapi.domain.book.usecase.DownloadBookUseCase;
import com.opencsv.CSVWriter;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@AllArgsConstructor
@Component
public class DownloadBookUseCaseIFacade implements DownloadBookUseCase {
    private BookService bookService;

    @Override
    public void download(HttpServletResponse response) {
        try {
            response.setContentType("text/csv");

            String headerKey = "Content-Disposition";
            String headerValue = "attachment; filename=books.csv";
            response.setHeader(headerKey, headerValue);

            List<Book> books = bookService.findMany();
            CSVWriter csvWriter = new CSVWriter(response.getWriter());

            csvWriter.writeNext(new String[]{"Id", "Title", "Description", "Genres", "Authors"});
            csvWriter.writeAll(books.stream().map(Book::toFlatArray).toList());
            csvWriter.close();
        } catch (IOException ex) {
            throw new BookLibraryException("Failed to download", HttpStatus.BAD_REQUEST);
        }
    }
}
