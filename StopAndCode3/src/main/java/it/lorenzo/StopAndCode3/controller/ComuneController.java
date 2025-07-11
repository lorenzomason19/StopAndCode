package it.lorenzo.StopAndCode3.controller;

import it.lorenzo.StopAndCode3.model.Comune;
import it.lorenzo.StopAndCode3.service.ComuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comuni")
@CrossOrigin(origins = "*")
public class ComuneController {

  @Autowired
  private ComuneService comuneService;

  // GET /comuni - Restituisce tutti i comuni
  @GetMapping
  public ResponseEntity<List<Comune>> getAllComuni() {
    List<Comune> comuni = comuneService.getAllComuni();
    return ResponseEntity.ok(comuni);
  }

  // GET /comuni/{codiceCatastale} - Restituisce comune specifico
  @GetMapping("/{codiceCatastale}")
  public ResponseEntity<Comune> getComuneByCodiceCatastale(@PathVariable String codiceCatastale) {
    Optional<Comune> comune = comuneService.getComuneByCodiceCatastale(codiceCatastale);

    if (comune.isPresent()) {
      return ResponseEntity.ok(comune.get());
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  // POST /comuni - Registra nuovo comune
  @PostMapping
  public ResponseEntity<?> createComune(@RequestBody Comune comune) {
    try {
      Comune nuovoComune = comuneService.createComune(comune);
      return ResponseEntity.status(HttpStatus.CREATED).body(nuovoComune);
    } catch (RuntimeException e) {
      return ResponseEntity.badRequest().body("Errore: " + e.getMessage());
    }
  }

  // PUT /comuni/{codiceCatastale} - Modifica comune esistente
  @PutMapping("/{codiceCatastale}")
  public ResponseEntity<?> updateComune(@PathVariable String codiceCatastale, @RequestBody Comune comune) {
    try {
      Comune comuneAggiornato = comuneService.updateComune(codiceCatastale, comune);
      return ResponseEntity.ok(comuneAggiornato);
    } catch (RuntimeException e) {
      return ResponseEntity.notFound().build();
    }
  }

  // DELETE /comuni/{codiceCatastale} - Cancella comune
  @DeleteMapping("/{codiceCatastale}")
  public ResponseEntity<?> deleteComune(@PathVariable String codiceCatastale) {
    try {
      comuneService.deleteComune(codiceCatastale);
      return ResponseEntity.ok().body("Comune eliminato con successo");
    } catch (RuntimeException e) {
      return ResponseEntity.notFound().build();
    }
  }

  // GET /comuni/exists/{codiceCatastale} - Verifica esistenza comune
  @GetMapping("/exists/{codiceCatastale}")
  public ResponseEntity<Boolean> comuneExists(@PathVariable String codiceCatastale) {
    boolean exists = comuneService.comuneExists(codiceCatastale);
    return ResponseEntity.ok(exists);
  }
}
