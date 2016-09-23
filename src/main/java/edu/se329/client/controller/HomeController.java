package edu.se329.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Jack Meyer jackmeyerdev@gmail.com
 *
 * Controller for the home page.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "index"; // returns the ../../resoures/templates/index.html
    }
}
