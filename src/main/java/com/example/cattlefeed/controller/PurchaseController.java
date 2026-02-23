package com.example.cattlefeed.controller;

import com.example.cattlefeed.model.Purchase;
import com.example.cattlefeed.service.PurchaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchase")
public class PurchaseController {

    private final PurchaseService purchaseService;

    // ✅ Constructor Injection (Best Practice)
    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @PostMapping
    public Purchase addPurchase(@RequestBody Purchase purchase) {
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
                                   @RequestBody Purchase purchase) {
        return purchaseService.updatePurchase(id, purchase);
    }

    @DeleteMapping("/{id}")
    public String deletePurchase(@PathVariable Long id) {
        purchaseService.deletePurchase(id);
        return "Purchase deleted successfully!";
    }
}