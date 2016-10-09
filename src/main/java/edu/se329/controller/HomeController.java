package edu.se329.controller;

import javax.inject.Inject;

import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.twitter.api.CursoredList;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/")
public class HomeController {

    private Twitter twitter;

    private ConnectionRepository connectionRepository;

    @Inject
    public HomeController(Twitter twitter, ConnectionRepository connectionRepository) {
        this.twitter = twitter;
        this.connectionRepository = connectionRepository;
    }

    /**
     * Mapping for the home page. This function will load the contents for "/"
     * @param model
     * @return the name of the home screen html file.,
     */
    @RequestMapping(method=RequestMethod.GET)
    public String helloTwitter(Model model) {
        if (connectionRepository.findPrimaryConnection(Twitter.class) == null) {
            return "redirect:/connect/twitter";
        }


        List<Tweet> tweets = twitter.timelineOperations().getUserTimeline("FoxNews", 200);

        Map<String, Integer> mentionOccurrences = countOccurences(tweets, "@");
        Map<String, Integer> hashtagOccurrences = countOccurences(tweets, "#");
        System.out.println(mentionOccurrences);
        System.out.println(hashtagOccurrences);



        return "index";
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
