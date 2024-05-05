package com.amazingJava.Real.time.social.media.sentiment.anlysis.controller;
import com.amazingJava.Real.time.social.media.sentiment.anlysis.service.TwitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TwitterController {
    private final TwitterService twitterService;

    @Autowired
    public TwitterController(TwitterService twitterService) {
        this.twitterService = twitterService;
    }

    @GetMapping("/tweets")
    public ResponseEntity<Object> getTweets(@RequestParam String keyword) {
        return ResponseEntity.ok(twitterService.searchTweets(keyword));
    }
}
