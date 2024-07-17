package co.edu.unbosque.controller;


import co.edu.unbosque.model.dto.AuthorDTO;
import co.edu.unbosque.service.ServiceAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Set;

@RestController
public class ControllerAuthor implements ApiAuthor {

    @Autowired
    private ServiceAuthor authorService;

    @Override
    public ResponseEntity<AuthorDTO> addNewAuthor(AuthorDTO authorDTO) {
        AuthorDTO addedAuthor = authorService.addNewAuthor(authorDTO);
        if (addedAuthor == null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } else {
            return new ResponseEntity<>(addedAuthor, HttpStatus.CREATED);
        }
    }

    @Override
    public ResponseEntity<AuthorDTO> editAuthor(Integer id, AuthorDTO authorDTO) {
        AuthorDTO editedAuthor = authorService.editAuthorByid(id, authorDTO);
        if (editedAuthor == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(editedAuthor, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<Void> deleteAuthor(Integer id) {
        if (authorService.deleteAuthor(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Set<AuthorDTO>> getAllAuthors() {
        Set<AuthorDTO> authors = authorService.getAllAuthors();
        if (authors.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(authors, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<List<AuthorDTO>> getAuthorsByName(String name) {
        List<AuthorDTO> authorsByName = authorService.getAuthorsByName(name);
        if (authorsByName.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(authorsByName, HttpStatus.OK);
        }
    }
}