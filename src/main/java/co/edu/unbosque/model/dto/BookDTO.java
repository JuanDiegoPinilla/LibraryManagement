package co.edu.unbosque.model.dto;

import lombok.Data;

import java.util.Set;

@Data
public class BookDTO {

    private int id;
    private String title;
    private String genre;
    private int yearOfPublication;
    private Set<String> autores;
}
