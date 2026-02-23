package com.example.cattlefeed.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Cattle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;
    private String breed;
    private String healthStatus;

    private LocalDateTime createdAt;

    // Constructor
    public Cattle() {
        this.createdAt = LocalDateTime.now();
    }

    // 👇 VERY IMPORTANT — Add Getters & Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getBreed() { return breed; }
    public void setBreed(String breed) { this.breed = breed; }

    public String getHealthStatus() { return healthStatus; }
    public void setHealthStatus(String healthStatus) { this.healthStatus = healthStatus; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}