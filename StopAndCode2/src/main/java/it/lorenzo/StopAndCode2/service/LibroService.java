package it.lorenzo.StopAndCode2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import it.lorenzo.StopAndCode2.exception.LibroNotFoundException;
import it.lorenzo.StopAndCode2.model.Libro;

@Service
public class LibroService {

  private final List<Libro> libri = new ArrayList<>();

  public List<Libro> getAllLibri() {
    return new ArrayList<>(libri);
  }

  public Libro getLibroById(UUID id) {
    return libri.stream()
        .filter(libro -> libro.getId().equals(id))
        .findFirst()
        .orElseThrow(() -> new RuntimeException("Libro non trovato con id:" + id));
  }

  public Libro addLibro(Libro libro) {
    UUID newid = UUID.randomUUID();
    Libro nuovoLibro = new Libro(newid, libro.getTitolo(), libro.getAutore(), libro.getAnnoPubblicazione());
    libri.add(nuovoLibro);
    return nuovoLibro;
  }

  public Libro updateLibro(UUID id, Libro libro) {
    for (int i = 0; i < libri.size(); i++) {
      if (libri.get(i).getId().equals(id)) {
        Libro updated = new Libro(id, libro.getTitolo(), libro.getAutore(), libro.getAnnoPubblicazione());
        libri.set(i, updated);
        return updated;
      }
    }
    throw new LibroNotFoundException("Libro non trovato con id:" + id);
  }

  public void deleteLibro(UUID id) {
    boolean removed = libri.removeIf(libro -> libro.getId().equals(id));
    if (!removed) {
      throw new LibroNotFoundException("Libro non trovato con id:" + id);
    }
  }
}
