package it.urusso.graphqlspringboot.service;

import it.urusso.graphqlspringboot.model.Book;
import it.urusso.graphqlspringboot.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> allBooks() {
        return bookRepository.findAll();
    }

    public Book findById(@Argument long id) {
        return bookRepository.findById(id).orElse(null);
    }
}
