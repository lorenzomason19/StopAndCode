package it.lorenzo.StopAndCode2.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.lorenzo.StopAndCode2.model.Libro;
import it.lorenzo.StopAndCode2.service.LibroService;

@RestController
@RequestMapping("/api/libri")
public class LibroController {

  private final LibroService libroService;

  public LibroController(LibroService libroService) {
    this.libroService = libroService;
  }

  @GetMapping
  public List<Libro> getAllLibri() {
    return libroService.getAllLibri();
  }

  @GetMapping("/{id}")
  public Libro getLibroById(@PathVariable UUID id) {
    return libroService.getLibroById(id);
  }

  @PostMapping
  public ResponseEntity<Libro> addLibro(@RequestBody Libro libro) {
    Libro nuovoLibro = libroService.addLibro(libro);
    return ResponseEntity.status(HttpStatus.CREATED).body(nuovoLibro);
  }

  @PutMapping("/{id}")
  public Libro updateLibro(@PathVariable UUID id, @RequestBody Libro libro) {
    return libroService.updateLibro(id, libro);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteLibro(@PathVariable UUID id) {
    libroService.deleteLibro(id);
  }

}
