package edu.se329.service;

import edu.se329.client.model.HashtagModel;
import edu.se329.client.model.MentionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class DataService {

    @Autowired
    private Twitter twitter;

    private Map<String, Integer> mentionOccurrences;
    private Map<String, Integer> hashtagOccurrences;

    public void getData(String username) {
        List<Tweet> tweets = twitter.timelineOperations().getUserTimeline(username, 200);

        for(Tweet tweet : tweets) {
            System.out.println(tweet.getText());
        }

        mentionOccurrences = countOccurences(tweets, "@");
        hashtagOccurrences = countOccurences(tweets, "#");
    }

    public Map<String, Integer> getMentionOccurrences() {
        return mentionOccurrences;
    }

    public void setMentionOccurrences(Map<String, Integer> mentionOccurrences) {
        this.mentionOccurrences = mentionOccurrences;
    }

    public Map<String, Integer> getHashtagOccurrences() {
        return hashtagOccurrences;
    }

    public void setHashtagOccurrences(Map<String, Integer> hashtagOccurrences) {
        this.hashtagOccurrences = hashtagOccurrences;
    }



    /**
     * Count the number of occurences which for words that start with a certain character. This is useful for counting
     * the number of times a twitter user mentions another user or uses a hashtag.
     * @param tweets the list of tweets for a given user
     * @param delimiter the starting character to look for (eg. '#' or '@')
     * @return occurences a HashMap which has the word as a key and the count as a
     */
    public Map<String, Integer> countOccurences(List<Tweet> tweets, String delimiter) {
        Map<String, Integer> occurences =  new HashMap<String, Integer>();
        for(Tweet tweet : tweets) {
            String tweetText = tweet.getText();

            Pattern pattern = Pattern.compile(delimiter + "\\w+");
            Matcher matcher = pattern.matcher(tweetText);
            while(matcher.find()) {
                if(occurences.containsKey(matcher.group())) {
                    occurences.put(matcher.group(), occurences.get(matcher.group()) + 1);
                } else {
                    occurences.put(matcher.group(), 1);
                }
            }
        }

        return occurences;
    }
}
