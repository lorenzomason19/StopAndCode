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
    return comuneRepository.findByCodiceCatastale(codiceCatastale);
  }

  public Comune createComune(Comune comune) {

    if (comuneRepository.existsByCodiceCatastale(comune.getCodiceCatastale())) {
      throw new RuntimeException("Comune con codice catastale " + comune.getCodiceCatastale() + " già esistente");
    }
    return comuneRepository.save(comune);
  }

  public Comune updateComune(String codiceCatastale, Comune comuneAggiornato) {
    Optional<Comune> comuneEsistente = comuneRepository.findByCodiceCatastale(codiceCatastale);

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
    Optional<Comune> comune = comuneRepository.findByCodiceCatastale(codiceCatastale);

    if (comune.isEmpty()) {
      throw new RuntimeException("Comune con codice catastale " + codiceCatastale + " non trovato");
    }

    comuneRepository.delete(comune.get());
  }

  public boolean comuneExists(String codiceCatastale) {
    return comuneRepository.existsByCodiceCatastale(codiceCatastale);
  }
}
