package com.example.cattlefeed.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.cattlefeed.model.Cattle;

public interface CattleRepository extends JpaRepository<Cattle, Long> {
}