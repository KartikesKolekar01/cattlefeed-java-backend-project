package com.example.cattlefeed.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "purchase")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Cattle ID is required")
    private Long cattleId;

    @NotNull(message = "Feed ID is required")
    private Long feedId;

    @Min(value = 1, message = "Quantity must be at least 1")
    private double quantity;

    @Min(value = 0, message = "Total price cannot be negative")
    private double totalPrice;

    private boolean deleted = false;

    private LocalDateTime purchasedAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Purchase() {}

    // Lifecycle Methods
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.purchasedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getCattleId() { return cattleId; }
    public void setCattleId(Long cattleId) { this.cattleId = cattleId; }

    public Long getFeedId() { return feedId; }
    public void setFeedId(Long feedId) { this.feedId = feedId; }

    public double getQuantity() { return quantity; }
    public void setQuantity(double quantity) { this.quantity = quantity; }

    public double getTotalPrice() { return totalPrice; }
    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }

    public boolean isDeleted() { return deleted; }
    public void setDeleted(boolean deleted) { this.deleted = deleted; }

    public LocalDateTime getPurchasedAt() { return purchasedAt; }
    public void setPurchasedAt(LocalDateTime purchasedAt) { this.purchasedAt = purchasedAt; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}