package com.amazingJava.Real.time.social.media.sentiment.anlysis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;


@SpringBootApplication
@EnableCaching
public class RealTimeSocialMediaSentimentAnlysisApplication {
	public static void main(String[] args) {
		SpringApplication.run(RealTimeSocialMediaSentimentAnlysisApplication.class, args);

	}

}
