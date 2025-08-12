package br.com.fiap.aula.superpoderes1.poderes;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoderesService {

    private final PoderesRepository repository;

    public PoderesService(PoderesRepository repository) {
        this.repository = repository;
    }

    public List<Poderes> getAllPoderes(){
        return repository.findAllByOrderByNivelInutilidadeDesc();
    }
}