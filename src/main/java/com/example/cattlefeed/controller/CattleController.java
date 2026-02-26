package com.example.cattlefeed.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import java.util.List;
import com.example.cattlefeed.model.Cattle;
import com.example.cattlefeed.service.CattleService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cattle")
public class CattleController {

    private final CattleService service;

    public CattleController(CattleService service) {
        this.service = service;
    }

    // ✅ CREATE
    @PostMapping
    public ResponseEntity<Cattle> save(@Valid @RequestBody Cattle cattle) {
        return ResponseEntity.ok(service.save(cattle));
    }

    // ✅ GET ALL
    @GetMapping
    public ResponseEntity<List<Cattle>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    // ✅ GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Cattle> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    // ✅ UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Cattle> update(
            @PathVariable Long id,
            @Valid @RequestBody Cattle cattle) {

        return ResponseEntity.ok(service.update(id, cattle));
    }

    // ✅ SOFT DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("Cattle deleted successfully");
    }

    // ✅ PAGINATION
    @GetMapping("/page")
    public ResponseEntity<Page<Cattle>> getPaginated(
            @RequestParam int page,
            @RequestParam int size) {

        return ResponseEntity.ok(service.getAllPaginated(page, size));
    }

    // ✅ DASHBOARD COUNT
    @GetMapping("/dashboard/total")
    public ResponseEntity<Long> totalCattle() {
        return ResponseEntity.ok(service.totalCattle());
    }


    @GetMapping("/dashboard/healthy")
    public ResponseEntity<Long> healthyCount() {
        return ResponseEntity.ok(service.healthyCount());
    }
}