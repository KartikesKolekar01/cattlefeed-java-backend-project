package com.example.cattlefeed.service;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.*;
import java.util.List;
import com.example.cattlefeed.model.Cattle;
import com.example.cattlefeed.repository.CattleRepository;
import com.example.cattlefeed.exception.ResourceNotFoundException;

@Service
public class CattleService {

    private final CattleRepository repository;

    public CattleService(CattleRepository repository) {
        this.repository = repository;
    }

    // ✅ CREATE
    public Cattle save(Cattle cattle) {
        return repository.save(cattle);
    }

    // ✅ GET ALL (Only non-deleted)
    public List<Cattle> getAll() {
        return repository.findByDeletedFalse();
    }

    // ✅ PAGINATION SUPPORT
    public Page<Cattle> getAllPaginated(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        return repository.findAll(pageable);
    }

    // ✅ GET BY ID
    public Cattle getById(Long id) {
        return repository.findById(id)
                .filter(cattle -> !cattle.isDeleted())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Cattle not found with id: " + id));
    }

    // ✅ UPDATE
    public Cattle update(Long id, Cattle updatedCattle) {
        Cattle existing = getById(id);

        existing.setName(updatedCattle.getName());
        existing.setAge(updatedCattle.getAge());
        existing.setBreed(updatedCattle.getBreed());
        existing.setHealthStatus(updatedCattle.getHealthStatus());

        return repository.save(existing);
    }

    // ✅ SOFT DELETE
    public void delete(Long id) {
        Cattle cattle = getById(id);
        cattle.setDeleted(true);
        repository.save(cattle);
    }

    // ✅ DASHBOARD LOGIC
    public long totalCattle() {
        return repository.findByDeletedFalse().size();
    }

    public long healthyCount() {
        return repository.findByDeletedFalse()
                .stream()
                .filter(c -> "Healthy".equalsIgnoreCase(c.getHealthStatus()))
                .count();
    }
}