package com.amazingJava.Real.time.social.media.sentiment.anlysis.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import twitter4j.TwitterException;
import twitter4j.Twitter;
import twitter4j.v1.Query;
import twitter4j.v1.Status;

import java.util.List;

@RestController
public class TwitterController {
    @Autowired
    private Twitter twitter;// = Twitter.getInstance();

    //user time line
    @GetMapping("time-line")
    public List<Status> getTimeline() throws TwitterException {
        return twitter.v1().timelines().getHomeTimeline();
    }




}
