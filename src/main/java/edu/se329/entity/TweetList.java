package edu.se329.entity;

import org.springframework.social.twitter.api.Tweet;

import java.util.List;


public class TweetList {

    private List<Tweet> tweetList;

    public List<Tweet> getTweetList() {
        return tweetList;
    }

    public void setTweetList(List<Tweet> tweetList) {
        this.tweetList = tweetList;
    }
}
