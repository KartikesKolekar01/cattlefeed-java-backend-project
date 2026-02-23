package com.example.cattlefeed.service;

import com.example.cattlefeed.model.Purchase;
import com.example.cattlefeed.repository.PurchaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;

    // ✅ Constructor Injection
    public PurchaseService(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    public Purchase addPurchase(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }

    public List<Purchase> getAllPurchase() {
        return purchaseRepository.findAll();
    }

    public Purchase getPurchaseById(Long id) {
        return purchaseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Purchase not found with id: " + id));
    }

    public Purchase updatePurchase(Long id, Purchase purchaseDetails) {

        Purchase purchase = purchaseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Purchase not found with id: " + id));

        purchase.setCattleId(purchaseDetails.getCattleId());
        purchase.setFeedId(purchaseDetails.getFeedId());
        purchase.setQuantity(purchaseDetails.getQuantity());
        purchase.setTotalPrice(purchaseDetails.getTotalPrice());

        return purchaseRepository.save(purchase);
    }

    public void deletePurchase(Long id) {

        if (!purchaseRepository.existsById(id)) {
            throw new RuntimeException("Purchase not found with id: " + id);
        }

        purchaseRepository.deleteById(id);
    }
}