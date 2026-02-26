package com.example.cattlefeed.service;

import com.example.cattlefeed.model.Feed;
import com.example.cattlefeed.model.Purchase;
import com.example.cattlefeed.repository.PurchaseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;
    private final FeedService feedService;

    public PurchaseService(PurchaseRepository purchaseRepository, FeedService feedService) {
        this.purchaseRepository = purchaseRepository;
        this.feedService = feedService;
    }

    // ✅ ADD PURCHASE & UPDATE STOCK
    @Transactional
    public Purchase addPurchase(Purchase purchase) {
        // १. आधी तो Feed (चारा) अस्तित्वात आहे का ते तपासा
        Feed feed = feedService.getFeedById(purchase.getFeedId());

        // २. चाऱ्याचा स्टॉक अपडेट करा (Quantity वाढवा)
        double newQuantity = feed.getQuantity() + purchase.getQuantity();
        feed.setQuantity(newQuantity);

        // ३. अपडेट केलेला स्टॉक सेव्ह करा
        feedService.addFeed(feed);

        // ४. खरेदीचा रेकॉर्ड सेव्ह करा
        return purchaseRepository.save(purchase);
    }

    // ✅ GET ALL (Non-deleted)
    public List<Purchase> getAllPurchase() {
        return purchaseRepository.findByDeletedFalse();
    }

    // ✅ GET BY ID
    public Purchase getPurchaseById(Long id) {
        return purchaseRepository.findById(id)
                .filter(p -> !p.isDeleted())
                .orElseThrow(() -> new RuntimeException("Purchase not found with id: " + id));
    }

    // ✅ UPDATE PURCHASE
    @Transactional
    public Purchase updatePurchase(Long id, Purchase purchaseDetails) {
        Purchase existing = getPurchaseById(id);

        // जर स्टॉक क्वांटिटी बदलली असेल, तर ते लॉजिक इथे क्लिष्ट होऊ शकते,
        // सध्या आपण फक्त बेसिक माहिती अपडेट करत आहोत.
        existing.setCattleId(purchaseDetails.getCattleId());
        existing.setFeedId(purchaseDetails.getFeedId());
        existing.setQuantity(purchaseDetails.getQuantity());
        existing.setTotalPrice(purchaseDetails.getTotalPrice());

        return purchaseRepository.save(existing);
    }

    // ✅ SOFT DELETE
    @Transactional
    public void deletePurchase(Long id) {
        Purchase purchase = getPurchaseById(id);
        purchase.setDeleted(true);
        purchaseRepository.save(purchase);
    }
}