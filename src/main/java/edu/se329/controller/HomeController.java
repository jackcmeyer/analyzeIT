package edu.se329.controller;

import javax.inject.Inject;

import edu.se329.service.AlchemyService;
import org.springframework.beans.factory.annotation.Autowired;
import edu.se329.client.model.HashtagModel;
import edu.se329.client.model.MentionModel;
import edu.se329.client.model.ReturnableModel;
import edu.se329.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
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

    @Autowired
    private ConnectionRepository connectionRepository;


    @Inject
    public HomeController(/*Twitter twitter,*/ ConnectionRepository connectionRepository) {
/*        this.twitter = twitter;*/
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

        return "index";
    }




}
