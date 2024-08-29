package it.urusso.graphqlspringboot.service;

import it.urusso.graphqlspringboot.model.dto.BookDto;
import it.urusso.graphqlspringboot.model.entity.Book;
import it.urusso.graphqlspringboot.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> findALl() {
        return bookRepository.findAll();
    }

    public Book findById(long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Book create(BookDto dto) {
        var entity = new Book(dto.getTitle(), dto.getAuthor());
        return bookRepository.save(entity);
    }

    public Book update(Long id, String title, String author) {
        var book = bookRepository.findById(id);

        if (book.isPresent()) {
            var found = book.get();

            if (title != null && !title.isBlank())
                found.setTitle(title);
            if (author != null && !author.isBlank())
                found.setAuthor(author);

            return bookRepository.save(found);
        }

        throw new RuntimeException("Book not found for ID: " + id);
    }
}
