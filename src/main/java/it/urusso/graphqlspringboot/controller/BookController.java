package it.urusso.graphqlspringboot.controller;

import it.urusso.graphqlspringboot.model.dto.BookDto;
import it.urusso.graphqlspringboot.model.entity.Book;
import it.urusso.graphqlspringboot.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @QueryMapping
    public List<Book> findAllBooks() {
        return bookService.findALl();
    }

    @QueryMapping
    public Book findBookById(@Argument long id) {
        return bookService.findById(id);
    }

    @MutationMapping
    public Book createBook(@Argument BookDto book) {
        return bookService.create(book);
    }

    @MutationMapping
    public Book updateBook(@Argument Long id, @Argument String title, @Argument String author) {
        return bookService.update(id, title, author);
    }
}
