package co.edu.unbosque.service;

import co.edu.unbosque.model.dto.AuthorDTO;
import co.edu.unbosque.model.entity.Author;
import co.edu.unbosque.model.persistence.RepositoryAuthor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ServiceAuthor {

    @Autowired
    private RepositoryAuthor repoAuthor;

    @Autowired
    private ModelMapper modelMapper;

   //Agregar un nuevo autor (POST)
    public AuthorDTO addNewAuthor(AuthorDTO authorDTO) {
       return modelMapper.map
               (repoAuthor.save(modelMapper.map(authorDTO, Author.class))
               , AuthorDTO.class);
    }

    //Modificar un Autor Existente(PUT)
    public AuthorDTO editAuthorByid(Integer id, AuthorDTO authorDTO) {
        Optional<Author> author = repoAuthor.findById(id);
        if (author.isPresent()) {
            Author authorToEdit = author.get();
           authorDTO = modelMapper.map(repoAuthor.save(authorToEdit), AuthorDTO.class);
           return authorDTO;
        }else
            return null;
    }

    //Eliminar un autor(DELETE)
    public Boolean deleteAuthor(Integer id) {
        Optional<Author> authorToDelete = repoAuthor.findById(id);
        if (authorToDelete.isPresent()) {
            repoAuthor.delete(authorToDelete.get());
            return true;
        }else
            return false;
    }

    //Listar Todos los Autores(GET)
    public Set<AuthorDTO> getAllAuthors() {
        return repoAuthor.findAll()
                .stream()
                .map(author -> modelMapper.map(author, AuthorDTO.class))
                .collect(Collectors.toSet());
    }

    //Buscar Autor por nombre (GET)
    public List<AuthorDTO> getAuthorsByName(String name) {
        return repoAuthor.findByNameAuthor(name)
                .stream()
                .map(author -> modelMapper.map(author, AuthorDTO.class))
                .collect(Collectors.toList());
    }

}
