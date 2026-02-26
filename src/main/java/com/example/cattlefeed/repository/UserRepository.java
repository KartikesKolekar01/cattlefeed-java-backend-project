package com.example.cattlefeed.repository;

import com.example.cattlefeed.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // ईमेलवरून युझर शोधण्यासाठी ही मेथड गरजेची आहे
    User findByEmail(String email);

    // ईमेल अस्तित्वात आहे की नाही हे तपासण्यासाठी
    boolean existsByEmail(String email);
}