package com.example.cattlefeed.service;

import com.example.cattlefeed.model.Feed;
import com.example.cattlefeed.repository.FeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedService {

    @Autowired
    private FeedRepository feedRepository;

    public Feed addFeed(Feed feed){
        return feedRepository.save(feed);
    }

    public List<Feed> getAllFeed(){
        return feedRepository.findByDeletedFalse();
    }

    public Feed getFeedById(Long id){
        return feedRepository.findById(id)
                .filter(feed -> !feed.isDeleted())
                .orElseThrow(() -> new RuntimeException("Feed not found"));
    }

    public Feed updateFeed(Long id, Feed updatedFeed){
        Feed existing = feedRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Feed not found"));

        if(existing.isDeleted()){
            throw new RuntimeException("Cannot update deleted feed");
        }

        existing.setName(updatedFeed.getName());
        existing.setQuantity(updatedFeed.getQuantity());
        existing.setPricePerUnit(updatedFeed.getPricePerUnit());
        existing.setMinThreshold(updatedFeed.getMinThreshold());

        return feedRepository.save(existing);
    }

    public void deleteFeed(Long id){
        Feed feed = feedRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Feed not found"));

        feed.setDeleted(true);
        feedRepository.save(feed);
    }
}