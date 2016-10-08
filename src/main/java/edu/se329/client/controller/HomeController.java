package edu.se329.client.controller;

import javax.inject.Inject;

import edu.se329.service.AlchemyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    private Twitter twitter;

    private ConnectionRepository connectionRepository;

    @Autowired
    private AlchemyService alchemyService;


    @Inject
    public HomeController(Twitter twitter, ConnectionRepository connectionRepository) {
        this.twitter = twitter;
        this.connectionRepository = connectionRepository;
    }

    @RequestMapping(method=RequestMethod.GET)
    public String helloTwitter(Model model) {
        if (connectionRepository.findPrimaryConnection(Twitter.class) == null) {
            return "redirect:/connect/twitter";
        }


        List<Tweet> tweets = twitter.timelineOperations().getUserTimeline("FoxNews", 200);

        for(Tweet tweet : tweets) {
            //tweet.
            //System.out.println(tweet.getText());
            //System.out.println();
            System.out.println("Tweet text: "+tweet.getText());
            System.out.println("AlchemyTxt: "+alchemyService.getKeywords(tweet));
        }

        System.out.println(tweets.size());


        return "index";
    }

}
