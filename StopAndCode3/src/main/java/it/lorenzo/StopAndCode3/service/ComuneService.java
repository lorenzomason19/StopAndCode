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

  public List<Comune> getAllComuni() {
    return comuneRepository.findAll();
  }

  public Optional<Comune> getComuneByCodiceCatastale(String codiceCatastale) {
    return comuneRepository.findById(codiceCatastale);
  }

  public Comune createComune(Comune comune) {
    if (comuneRepository.existsById(comune.getCodiceCatastale())) {
      throw new RuntimeException("Comune con codice catastale " + comune.getCodiceCatastale() + " già esistente");
    }

    if (comune.getCoordinate() != null) {
      comune.getCoordinate().setId(null);
    }

    return comuneRepository.save(comune);
  }

  public Comune updateComune(String codiceCatastale, Comune comuneAggiornato) {
    Optional<Comune> comuneEsistente = comuneRepository.findById(codiceCatastale);

    if (comuneEsistente.isEmpty()) {
      throw new RuntimeException("Comune con codice catastale " + codiceCatastale + " non trovato");
    }

    Comune comune = comuneEsistente.get();

    comune.setNome(comuneAggiornato.getNome());
    comune.setProvincia(comuneAggiornato.getProvincia());
    comune.setCap(comuneAggiornato.getCap());
    comune.setPrefisso(comuneAggiornato.getPrefisso());
    comune.setMail(comuneAggiornato.getMail());
    comune.setPec(comuneAggiornato.getPec());
    comune.setTelefono(comuneAggiornato.getTelefono());
    comune.setFax(comuneAggiornato.getFax());

    if (comuneAggiornato.getCoordinate() != null) {
      comune.getCoordinate().setLat(comuneAggiornato.getCoordinate().getLat());
      comune.getCoordinate().setLng(comuneAggiornato.getCoordinate().getLng());
    }

    return comuneRepository.save(comune);
  }

  public void deleteComune(String codiceCatastale) {
    if (!comuneRepository.existsById(codiceCatastale)) {
      throw new RuntimeException("Comune con codice catastale " + codiceCatastale + " non trovato");
    }

    comuneRepository.deleteById(codiceCatastale);
  }

  public boolean comuneExists(String codiceCatastale) {
    return comuneRepository.existsById(codiceCatastale);
  }
}
