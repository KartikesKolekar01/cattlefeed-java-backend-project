package com.example.cattlefeed.controller;

import com.example.cattlefeed.model.Feed;
import com.example.cattlefeed.service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feed")
public class FeedController {

    @Autowired
    private FeedService feedService;

    @PostMapping
    public Feed addFeed(@RequestBody Feed feed){
        return feedService.addFeed(feed);
    }

    @GetMapping
    public List<Feed> getAllFeed(){
        return feedService.getAllFeed();
    }

    @GetMapping("/{id}")
    public Feed getFeed(@PathVariable Long id){
        return feedService.getFeedById(id);
    }

    @PutMapping
    public Feed updateFeed(@RequestBody Feed feed){
        return feedService.updateFeed(feed);
    }

    @DeleteMapping("/{id}")
    public String deleteFeed(@PathVariable Long id){
        feedService.deleteFeed(id);
        return "Feed deleted successfully!";
    }
}