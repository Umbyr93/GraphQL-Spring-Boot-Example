package it.urusso.graphqlspringboot.controller;

import it.urusso.graphqlspringboot.model.Book;
import it.urusso.graphqlspringboot.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @QueryMapping
    public List<Book> allBooks() {
        return bookService.allBooks();
    }

    @QueryMapping
    public Book findById(@Argument long id) {
        return bookService.findById(id);
    }
}
