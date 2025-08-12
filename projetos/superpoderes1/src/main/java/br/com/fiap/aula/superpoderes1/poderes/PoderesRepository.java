package br.com.fiap.aula.superpoderes1.poderes;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PoderesRepository extends JpaRepository<Poderes, Long> {

    List<Poderes> findAllByOrderByNivelInutilidadeDesc();
}
