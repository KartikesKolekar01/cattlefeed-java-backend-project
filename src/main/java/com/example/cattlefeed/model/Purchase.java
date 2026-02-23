package com.example.cattlefeed.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "purchase")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long cattleId;
    private Long feedId;
    private double quantity;
    private double totalPrice;

    private LocalDateTime purchasedAt = LocalDateTime.now();

    // 🔹 Default Constructor
    public Purchase() {
    }

    // 🔹 Getters

    public Long getId() {
        return id;
    }

    public Long getCattleId() {
        return cattleId;
    }

    public Long getFeedId() {
        return feedId;
    }

    public double getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public LocalDateTime getPurchasedAt() {
        return purchasedAt;
    }

    // 🔹 Setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setCattleId(Long cattleId) {
        this.cattleId = cattleId;
    }

    public void setFeedId(Long feedId) {
        this.feedId = feedId;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setPurchasedAt(LocalDateTime purchasedAt) {
        this.purchasedAt = purchasedAt;
    }
}