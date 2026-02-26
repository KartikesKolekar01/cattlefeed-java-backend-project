package com.example.cattlefeed.repository;

import com.example.cattlefeed.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

    List<Purchase> findByDeletedFalse();

}