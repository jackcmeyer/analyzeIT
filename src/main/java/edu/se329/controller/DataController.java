package edu.se329.controller;

import edu.se329.client.model.HashtagModel;
import edu.se329.client.model.MentionModel;
import edu.se329.client.model.ReturnableModel;
import edu.se329.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jack on 10/10/2016.
 */
@RestController
public class DataController {

    @Autowired
    private DataService dataService;


    @RequestMapping("api/v1/data/getData")
    public ReturnableModel getData(@RequestParam(value="username") String username,
                                   @RequestParam(value="mentionCount") boolean mentionCount,
                                   @RequestParam(value="hashtagCount") boolean hashtagCount) {
        ReturnableModel returnableModel = new ReturnableModel();


        dataService.getData(username);

        if(mentionCount) {
            MentionModel mentionModel = new MentionModel(dataService.getMentionOccurrences());
            returnableModel.setMentionmodel(mentionModel);
        }

        if(hashtagCount) {
            HashtagModel hashtagModel = new HashtagModel(dataService.getHashtagOccurrences());
            returnableModel.setHashtagModel(hashtagModel);
        }

        return returnableModel;
    }

}
