package co.edu.unbosque.model.persistence;

import co.edu.unbosque.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositoryBook extends JpaRepository<Book, Integer> {

    // Método para buscar un libro por su título
    List<Book> findByTitleContainingIgnoreCase(String title);

    // Método para buscar un libro por su género
    List<Book> findByGenreContainingIgnoreCase(String genre);

    // Método para buscar un libro por el nombre de su autor
    List<Book> findByAuthors_NameAuthorContainingIgnoreCase(String authorName);
}
