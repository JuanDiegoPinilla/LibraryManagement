package co.edu.unbosque.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_author")
    private int id;

    @Column(name = "name_author")
    private String nameAuthor;

    @Column(name = "nationality_author")
    private String nationalityAuthor;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books;
}