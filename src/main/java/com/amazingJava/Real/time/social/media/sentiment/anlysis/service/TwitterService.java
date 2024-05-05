package com.amazingJava.Real.time.social.media.sentiment.anlysis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.social.twitter.api.SearchResults;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TwitterService {

    private final Twitter twitter;

    @Autowired
    public TwitterService(Twitter twitter) {
        this.twitter = twitter;
    }

    public SearchResults searchTweets(String keyword) {
        try {
            return twitter.searchOperations().search("#" + keyword);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
