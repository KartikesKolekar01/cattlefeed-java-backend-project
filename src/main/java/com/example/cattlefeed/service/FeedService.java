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
        return feedRepository.findAll();
    }

    public Feed getFeedById(Long id){
        return feedRepository.findById(id).orElse(null);
    }

    public Feed updateFeed(Feed feed){
        return feedRepository.save(feed);
    }

    public void deleteFeed(Long id){
        feedRepository.deleteById(id);
    }
}