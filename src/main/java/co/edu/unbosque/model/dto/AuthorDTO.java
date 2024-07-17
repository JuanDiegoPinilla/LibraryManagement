package co.edu.unbosque.model.dto;

import co.edu.unbosque.model.entity.Book;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.Set;

@Data
public class AuthorDTO {
    private int idAuthor;
    private String nameAuthor;
    private String nationalityAuthor;
    private Set<Book> books;
}
