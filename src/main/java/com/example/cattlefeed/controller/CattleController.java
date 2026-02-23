package com.example.cattlefeed.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.cattlefeed.model.Cattle;
import com.example.cattlefeed.service.CattleService;

@RestController
@RequestMapping("/cattle")
public class CattleController {

    private final CattleService service;

    public CattleController(CattleService service) {
        this.service = service;
    }

    // ✅ POST - Save Cattle
    @PostMapping
    public Cattle save(@RequestBody Cattle cattle) {
        return service.save(cattle);
    }

    // ✅ GET - Get All
    @GetMapping
    public List<Cattle> getAll() {
        return service.getAll();
    }

    // ✅ GET - By Id
    @GetMapping("/{id}")
    public Cattle getById(@PathVariable Long id) {
        return service.getById(id);
    }

    // ✅ DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Deleted Successfully";
    }
    @PutMapping("/{id}")
    public Cattle update(@PathVariable Long id, @RequestBody Cattle cattle) {
        cattle.setId(id);
        return service.save(cattle);
    }
}