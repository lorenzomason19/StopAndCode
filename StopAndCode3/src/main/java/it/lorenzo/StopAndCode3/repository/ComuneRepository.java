package it.lorenzo.StopAndCode3.repository;

import it.lorenzo.StopAndCode3.model.Comune;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ComuneRepository extends JpaRepository<Comune, Long> {

  Optional<Comune> findByCodiceCatastale(String codiceCatastale);

  boolean existsByCodiceCatastale(String codiceCatastale);

  @Query("SELECT c FROM Comune c WHERE c.provincia = :provincia")
  List<Comune> findByProvincia(@Param("provincia") String provincia);
}
