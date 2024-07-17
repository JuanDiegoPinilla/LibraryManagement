package co.edu.unbosque.controller;

import co.edu.unbosque.model.dto.BookDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping(path = "/book")
public interface ApiBook {

    //Agregar un Nuevo Libro (POST)
    @PostMapping("/newbook")
    @Operation(summary = "Agregar un nuevo libro",
            description = "Se agregará un nuevo libro a la base de datos")
    @ApiResponse(responseCode = "200", description = "Libro agregado correctamente")
    @ApiResponse(responseCode = "404", description = "Error al agregar libro")
    ResponseEntity<BookDTO> addNewBook(
            @Parameter(description = "Objeto del libro a añadir", required = true)
            @RequestBody BookDTO bookDTO);

    //Editar Un Libro
    @PutMapping("/editbook/{id}")
    @Operation(summary = "Editar un libro",
            description = "Se editará un libro mediante su id")
    @ApiResponse(responseCode = "200", description = "Libro editado correctamente")
    @ApiResponse(responseCode = "404", description = "Error al editar el libro")
    ResponseEntity<BookDTO> editBook(
            @Parameter(description = "Objeto del libro a editar", required = true)
            @RequestBody BookDTO bookDTO,
            @Parameter(description = "Id del libro a editar", required = true)
            @PathVariable Integer id);

    //Eliminar un Libro
    @DeleteMapping("/deletebook/{id}")
    @Operation(summary = "Eliminar un libro",
            description = "Se eliminará un libro mediante su id")
    @ApiResponse(responseCode = "200", description = "Libro eliminado correctamente")
    @ApiResponse(responseCode = "404", description = "Error al eliminar el libro")
    ResponseEntity<Boolean> deleteBook(
            @Parameter(description = "Id del libro a eliminar", required = true)
            @PathVariable Integer id);

    //Obtener todos los libros
    @GetMapping("/getBooks")
    @Operation(summary = "Obtener todos los libros",
            description = "Obtenemos todos los libros de la base de datos")
    @ApiResponse(responseCode = "200", description = "Libros obtenidos exitosamente")
    @ApiResponse(responseCode = "404", description = "Error al obtener los libros")
    ResponseEntity<List<BookDTO>> getBooks();

    @GetMapping("/search/title")
    @Operation(summary = "Buscar libro por título",
            description = "Buscar libros cuyo título contenga una cadena específica")
    @ApiResponse(responseCode = "200", description = "Libros encontrados exitosamente")
    @ApiResponse(responseCode = "404", description = "No se encontraron libros")
    ResponseEntity<List<BookDTO>> getBookByTitle(
            @Parameter(description = "Título del libro", required = true)
            @RequestParam String title);

    // Buscar libro por género
    @GetMapping("/search/genre")
    @Operation(summary = "Buscar libro por género",
            description = "Buscar libros cuyo género contenga una cadena específica")
    @ApiResponse(responseCode = "200", description = "Libros encontrados exitosamente")
    @ApiResponse(responseCode = "404", description = "No se encontraron libros")
    ResponseEntity<List<BookDTO>> getBookByGenre(
            @Parameter(description = "Género del libro", required = true)
            @RequestParam String genre);

    // Buscar libro por autor
    @GetMapping("/search/author")
    @Operation(summary = "Buscar libro por autor",
            description = "Buscar libros cuyo autor contenga una cadena específica")
    @ApiResponse(responseCode = "200", description = "Libros encontrados exitosamente")
    @ApiResponse(responseCode = "404", description = "No se encontraron libros")
    ResponseEntity<List<BookDTO>> getBookByAuthor(
            @Parameter(description = "Nombre del autor", required = true)
            @RequestParam String author);
}