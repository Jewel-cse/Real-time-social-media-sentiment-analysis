package com.amazingJava.Real.time.social.media.sentiment.anlysis.model;

public class TwitterPost {

    private String username;
    private String content;

    public TwitterPost(String username, String content) {
        this.username = username;
        this.content = content;
    }

    // Getters and setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "TwitterPost{" +
                "username='" + username + '\'' +
                ": content='" + content + '\'' +
                '}';
    }
}