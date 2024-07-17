package co.edu.unbosque.service;
import co.edu.unbosque.model.dto.BookDTO;
import co.edu.unbosque.model.entity.Book;
import co.edu.unbosque.model.persistence.RepositoryBook;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ServiceBook {
    @Autowired
    private RepositoryBook repositoryBook;

    @Autowired
    private ModelMapper modelMapper;

    // Agregar un Nuevo Libro (POST)
    public BookDTO saveBook(BookDTO bookDTO) {
        return modelMapper.map(repositoryBook.save(modelMapper.map(bookDTO, Book.class)), BookDTO.class);
    }

    // Editar un Libro Mediante su Id (PUT)
    public BookDTO editBook(BookDTO bookDTO, Integer id) {
        Optional<Book> book = repositoryBook.findById(id);
        if (book.isPresent()) {
            Book bookEntity = book.get();
            modelMapper.map(bookDTO, bookEntity);
            return modelMapper.map(repositoryBook.save(bookEntity), BookDTO.class);
        } else {
            return null;
        }
    }

    // Eliminar un libro (DELETE)
    public boolean deleteBook(Integer id) {
        Optional<Book> book = repositoryBook.findById(id);
        if (book.isPresent()) {
            repositoryBook.delete(book.get());
            return true;
        } else {
            return false;
        }
    }

    // Obtener todos los libros (GET)
    public Set<BookDTO> getAllBooks() {
        return repositoryBook.findAll()
                .stream()
                .map(book -> modelMapper.map(book, BookDTO.class))
                .collect(Collectors.toSet());
    }

    // Buscar libro por título (GET)
    public List<BookDTO> getBookByTitle(String title) {
        return repositoryBook.findByTitleContainingIgnoreCase(title)
                .stream()
                .map(book -> modelMapper.map(book, BookDTO.class))
                .collect(Collectors.toList());
    }

    // Buscar un libro por género (GET)
    public List<BookDTO> getBookByGenre(String genre) {
        return repositoryBook.findByGenreContainingIgnoreCase(genre)
                .stream()
                .map(book -> modelMapper.map(book, BookDTO.class))
                .collect(Collectors.toList());
    }

    // Buscar un libro por Autor (GET)
    public List<BookDTO> getBookByAuthor(String author) {
        return repositoryBook.findByAuthors_NameAuthorContainingIgnoreCase(author)
                .stream()
                .map(book -> modelMapper.map(book, BookDTO.class))
                .collect(Collectors.toList());
    }
}
