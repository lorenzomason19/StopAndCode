package it.lorenzo.StopAndCode3.service;

import it.lorenzo.StopAndCode3.model.Comune;
import it.lorenzo.StopAndCode3.repository.ComuneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ComuneService {

  @Autowired
  private ComuneRepository comuneRepository;

  // Ottieni tutti i comuni
  public List<Comune> getAllComuni() {
    return comuneRepository.findAll();
  }

  // Trova comune per codice catastale
  public Optional<Comune> getComuneByCodiceCatastale(String codiceCatastale) {
    return comuneRepository.findById(codiceCatastale); // ← CAMBIATO
  }

  // Crea nuovo comune
  public Comune createComune(Comune comune) {
    // Verifica se il codice catastale esiste già
    if (comuneRepository.existsById(comune.getCodiceCatastale())) { // ← CAMBIATO
      throw new RuntimeException("Comune con codice catastale " + comune.getCodiceCatastale() + " già esistente");
    }
    return comuneRepository.save(comune);
  }

  // Aggiorna comune esistente
  public Comune updateComune(String codiceCatastale, Comune comuneAggiornato) {
    Optional<Comune> comuneEsistente = comuneRepository.findById(codiceCatastale); // ← CAMBIATO

    if (comuneEsistente.isEmpty()) {
      throw new RuntimeException("Comune con codice catastale " + codiceCatastale + " non trovato");
    }

    Comune comune = comuneEsistente.get();

    // Aggiorna i campi
    comune.setNome(comuneAggiornato.getNome());
    comune.setProvincia(comuneAggiornato.getProvincia());
    comune.setCap(comuneAggiornato.getCap());
    comune.setPrefisso(comuneAggiornato.getPrefisso());
    comune.setMail(comuneAggiornato.getMail());
    comune.setPec(comuneAggiornato.getPec());
    comune.setTelefono(comuneAggiornato.getTelefono());
    comune.setFax(comuneAggiornato.getFax());

    // Aggiorna coordinate se presenti
    if (comuneAggiornato.getCoordinate() != null) {
      comune.getCoordinate().setLat(comuneAggiornato.getCoordinate().getLat());
      comune.getCoordinate().setLng(comuneAggiornato.getCoordinate().getLng());
    }

    return comuneRepository.save(comune);
  }

  // Elimina comune
  public void deleteComune(String codiceCatastale) {
    if (!comuneRepository.existsById(codiceCatastale)) { // ← CAMBIATO
      throw new RuntimeException("Comune con codice catastale " + codiceCatastale + " non trovato");
    }

    comuneRepository.deleteById(codiceCatastale); // ← CAMBIATO
  }

  // Verifica se comune esiste
  public boolean comuneExists(String codiceCatastale) {
    return comuneRepository.existsById(codiceCatastale); // ← CAMBIATO
  }
}
