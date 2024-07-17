package co.edu.unbosque.controller;

import co.edu.unbosque.model.dto.AuthorDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RequestMapping(path = "/author")
public interface ApiAuthor {
    // Agregar un nuevo autor
    @PostMapping("/newauthor")
    @Operation(summary = "Agregar un nuevo Autor",
            description = "Se va agregar un nuevo autor a la base de datos")
    @ApiResponse(responseCode = "200", description = "Autor agregado correctamente")
    @ApiResponse(responseCode = "404", description = "Error al agregar un Autor")
    ResponseEntity<AuthorDTO> addNewAuthor(
            @Parameter(description = "Objeto Autor al añadir", required = true)
            @RequestBody AuthorDTO authorDTO);

    // Editar un Autor
    @PutMapping("/editauthor/{id}")
    @Operation(summary = "Editar Autor",
            description = "Se editará un autor mediante su id")
    @ApiResponse(responseCode = "200", description = "Autor editado correctamente")
    @ApiResponse(responseCode = "404", description = "Error al editar el Autor")
    ResponseEntity<AuthorDTO> editAuthor(
            @Parameter(description = "ID del autor a editar", required = true)
            @PathVariable Integer id,
            @Parameter(description = "Datos del autor a editar", required = true)
            @RequestBody AuthorDTO authorDTO);

    // Eliminar un autor
    @DeleteMapping("/deleteauthor/{id}")
    @Operation(summary = "Eliminar Autor",
            description = "Se eliminará un autor mediante su id")
    @ApiResponse(responseCode = "200", description = "Autor eliminado correctamente")
    @ApiResponse(responseCode = "404", description = "Error al eliminar el Autor")
    ResponseEntity<Void> deleteAuthor(
            @Parameter(description = "ID del autor a eliminar", required = true)
            @PathVariable Integer id);
    // Listar todos los autores
    @GetMapping("/allauthors")
    @Operation(summary = "Listar todos los Autores",
            description = "Se listarán todos los autores de la base de datos")
    @ApiResponse(responseCode = "200", description = "Lista de autores obtenida correctamente")
    ResponseEntity<Set<AuthorDTO>> getAllAuthors();

    // Buscar autores por nombre
    @GetMapping("/findbyname")
    @Operation(summary = "Buscar Autor por nombre",
            description = "Se buscarán autores por su nombre")
    @ApiResponse(responseCode = "200", description = "Autor(es) encontrado(s) correctamente")
    @ApiResponse(responseCode = "404", description = "Error al buscar el Autor")
    ResponseEntity<List<AuthorDTO>> getAuthorsByName(
            @Parameter(description = "Nombre del autor a buscar", required = true)
            @RequestParam String name);
}
