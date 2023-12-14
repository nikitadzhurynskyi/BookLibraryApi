package com.flamierd.booklibraryapi.domain.book.web;

import com.flamierd.booklibraryapi.core.web.model.MessageResponse;
import com.flamierd.booklibraryapi.domain.book.model.Book;
import com.flamierd.booklibraryapi.domain.book.service.BookService;
import com.flamierd.booklibraryapi.domain.book.web.model.CreateBookRequest;
import com.flamierd.booklibraryapi.domain.book.web.model.UpdateBookRequest;
import com.opencsv.CSVWriter;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@AllArgsConstructor
@RequestMapping("/api/books")
@RestController
public class BookController {
    private final BookService bookService;

    @PostMapping
    public Book create(@RequestBody CreateBookRequest dto) {
        return bookService.create(dto);
    }

    @PutMapping
    public Book update(@RequestBody UpdateBookRequest dto) {
        return bookService.update(dto);
    }

    @GetMapping
    public List<Book> getMany(@RequestParam(name = "page", defaultValue = "0", required = false) Integer pageNumber,
                              @RequestParam(name = "page_size", required = false) Integer pageSize) {
        if (pageSize != null && pageSize > 0) {
            return bookService.findMany(PageRequest.of(pageNumber, pageSize));
        }
        return bookService.findMany();
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable Long id) {
        return bookService.findByIdOrThrow(id);
    }

    @GetMapping(value = "/download")
    public void downloadBooks(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=books.csv";
        response.setHeader(headerKey, headerValue);

        List<Book> books = bookService.findMany();
        CSVWriter csvWriter = new CSVWriter(response.getWriter());

        csvWriter.writeNext(new String[]{"Id", "Title", "Description", "Genres", "Authors"});
        csvWriter.writeAll(books.stream().map(Book::toFlatArray).toList());
        csvWriter.close();
    }

    @DeleteMapping("/{id}")
    public MessageResponse delete(@PathVariable Long id) {
        bookService.deleteById(id);
        return new MessageResponse("Book with id=%d deleted successfully.".formatted(id));
    }
}
