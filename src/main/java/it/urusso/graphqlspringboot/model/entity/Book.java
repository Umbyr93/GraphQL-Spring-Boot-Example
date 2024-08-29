package it.urusso.graphqlspringboot.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
}
