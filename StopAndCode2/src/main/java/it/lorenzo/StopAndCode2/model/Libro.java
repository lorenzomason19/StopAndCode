package it.lorenzo.StopAndCode2.model;

import java.util.UUID;

public class Libro {
  private UUID id;
  private String titolo;
  private String autore;
  private String annoPubblicazione;

  public Libro() {
  }

  public Libro(UUID id, String titolo, String autore, String annoPubblicazione) {
    this.id = id;
    this.titolo = titolo;
    this.autore = autore;
    this.annoPubblicazione = annoPubblicazione;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getTitolo() {
    return titolo;
  }

  public void setTitolo(String titolo) {
    this.titolo = titolo;
  }

  public String getAutore() {
    return autore;
  }

  public void setAutore(String autore) {
    this.autore = autore;
  }

  public String getAnnoPubblicazione() {
    return annoPubblicazione;
  }

  public void setAnnoPubblicazione(String annoPubblicazione) {
    this.annoPubblicazione = annoPubblicazione;
  }

}
