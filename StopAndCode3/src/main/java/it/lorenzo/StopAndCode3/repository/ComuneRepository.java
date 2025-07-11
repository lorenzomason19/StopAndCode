package it.lorenzo.StopAndCode3.repository;

import it.lorenzo.StopAndCode3.model.Comune;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComuneRepository extends JpaRepository<Comune, String> {

  // Query personalizzata per trovare comuni per provincia (opzionale)
  @Query("SELECT c FROM Comune c WHERE c.provincia = :provincia")
  List<Comune> findByProvincia(@Param("provincia") String provincia);
}
