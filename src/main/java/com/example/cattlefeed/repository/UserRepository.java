package com.example.cattlefeed.repository;

import com.example.cattlefeed.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}

