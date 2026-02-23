package com.example.cattlefeed.repository;

import com.example.cattlefeed.model.Feed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedRepository extends JpaRepository<Feed, Long> { }