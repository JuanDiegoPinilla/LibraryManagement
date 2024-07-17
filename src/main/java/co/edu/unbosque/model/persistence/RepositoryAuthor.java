package co.edu.unbosque.model.persistence;

import co.edu.unbosque.model.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositoryAuthor extends JpaRepository<Author, Integer> {
    //Buscar un Autor por su nombre
    List<Author> findByNameAuthor(String name);
}
