package com.amazingJava.Real.time.social.media.sentiment.anlysis.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import twitter4j.Twitter;


@Configuration
public class TwitterConfig {
//    private final String consumerKey = System.getenv("TWITTER_CONSUMER_KEY");
//    private final String consumerSecret = System.getenv("TWITTER_CONSUMER_SECRET");
//    private final String accessToken =System.getenv("TWITTER_ACCESS_TOKEN");
//    private final String accessTokenSecret =System.getenv("TWITTER_ACCESS_TOKEN_SECRET");

    @Value("${twitter.consumerKey}")
    private String consumerKey;

    @Value("${twitter.consumerSecret}")
    private String consumerSecret;

    @Value("${twitter.accessToken}")
    private String accessToken;

    @Value("${twitter.accessTokenSecret}")
    private String accessTokenSecret;

    private Logger logger = LoggerFactory.getLogger(TwitterConfig.class);

    @Bean
    public Twitter getTwitter() {
        logger.info("Consumer key :: "+consumerKey);
        logger.info("consumerSecret :: "+consumerSecret);
        logger.info("accessToken :: "+accessToken);
        logger.info("accessTokenSecret :: "+accessTokenSecret);
        return Twitter.newBuilder()
                .oAuthConsumer(consumerKey, consumerSecret)
                .oAuthAccessToken(accessToken, accessTokenSecret)
                .build();
    }
}

