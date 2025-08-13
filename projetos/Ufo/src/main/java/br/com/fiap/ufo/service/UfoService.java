package br.com.fiap.ufo.service;

import br.com.fiap.ufo.model.Ufo;
import br.com.fiap.ufo.repository.UfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UfoService {

    private final UfoRepository repository;

    public UfoService(UfoRepository repository) {
        this.repository = repository;
    }

    public List<Ufo> findAll() {
        return repository.findAll();
    }

    public Ufo findById(long id) {
        return repository.findById(id).orElse(null);
    }

    public Ufo save(Ufo ufo) {
        return repository.save(ufo);
    }

    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
