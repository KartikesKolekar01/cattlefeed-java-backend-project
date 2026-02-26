package com.example.cattlefeed.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.example.cattlefeed.model.Cattle;

public interface CattleRepository extends JpaRepository<Cattle, Long> {

    // Only fetch non-deleted records
    List<Cattle> findByDeletedFalse();
}