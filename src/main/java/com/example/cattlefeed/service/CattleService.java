package com.example.cattlefeed.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.example.cattlefeed.model.Cattle;
import com.example.cattlefeed.repository.CattleRepository;

@Service
public class CattleService {

    private final CattleRepository repository;

    public CattleService(CattleRepository repository) {
        this.repository = repository;
    }

    public Cattle save(Cattle cattle) {
        return repository.save(cattle);
    }

    public List<Cattle> getAll() {
        return repository.findAll();
    }

    public Cattle getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}