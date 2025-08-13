package br.com.fiap.ufo.repository;

import br.com.fiap.ufo.model.Ufo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UfoRepository extends JpaRepository<Ufo, Long> {
}
