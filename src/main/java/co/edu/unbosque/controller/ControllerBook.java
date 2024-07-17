package co.edu.unbosque.controller;

import co.edu.unbosque.model.dto.BookDTO;
import co.edu.unbosque.service.ServiceBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@RestController
public class ControllerBook implements ApiBook {

    @Autowired
    private ServiceBook serviceBook;

    @Override
    public ResponseEntity<BookDTO> addNewBook(BookDTO bookDTO) {
        BookDTO addBook = serviceBook.saveBook(bookDTO);
        if (addBook == null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } else {
            return new ResponseEntity<>(addBook, HttpStatus.CREATED);
        }
    }

    @Override
    public ResponseEntity<BookDTO> editBook(BookDTO bookDTO, Integer id) {
        BookDTO editBook = serviceBook.editBook(bookDTO, id);
        if (editBook == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(editBook, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<Boolean> deleteBook(Integer id) {
        if (serviceBook.deleteBook(id)) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<List<BookDTO>> getBooks() {
        Set<BookDTO> bookSet = serviceBook.getAllBooks();
        List<BookDTO> books = new ArrayList<>(bookSet);
        if (books.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(books, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<List<BookDTO>> getBookByTitle(String title) {
        List<BookDTO> getBooksByTitle = serviceBook.getBookByTitle(title);
        if (getBooksByTitle.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(getBooksByTitle, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<List<BookDTO>> getBookByGenre(String genre) {
        List<BookDTO> getBooksByGenre = serviceBook.getBookByGenre(genre);
        if (getBooksByGenre.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(getBooksByGenre, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<List<BookDTO>> getBookByAuthor(String author) {
        List<BookDTO> getBooksByAuthor = serviceBook.getBookByAuthor(author);
        if (getBooksByAuthor.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(getBooksByAuthor, HttpStatus.OK);
        }
    }
}
