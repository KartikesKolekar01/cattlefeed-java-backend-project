package com.example.cattlefeed.controller;

import com.example.cattlefeed.model.Purchase;
import com.example.cattlefeed.service.PurchaseService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/purchase")
public class PurchaseController {

    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @PostMapping
    public Purchase addPurchase(@Valid @RequestBody Purchase purchase) {
        return purchaseService.addPurchase(purchase);
    }

    @GetMapping
    public List<Purchase> getAllPurchase() {
        return purchaseService.getAllPurchase();
    }

    @GetMapping("/{id}")
    public Purchase getPurchase(@PathVariable Long id) {
        return purchaseService.getPurchaseById(id);
    }

    @PutMapping("/{id}")
    public Purchase updatePurchase(@PathVariable Long id,
                                   @Valid @RequestBody Purchase purchase) {
        return purchaseService.updatePurchase(id, purchase);
    }

    @DeleteMapping("/{id}")
    public String deletePurchase(@PathVariable Long id) {
        purchaseService.deletePurchase(id);
        return "Purchase soft deleted successfully!";
    }
}