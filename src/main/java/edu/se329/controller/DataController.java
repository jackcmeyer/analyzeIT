package edu.se329.controller;

import com.ibm.watson.developer_cloud.service.AlchemyService;
import edu.se329.client.model.*;
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
                                   @RequestParam(value="hashtagCount") boolean hashtagCount,
                                   @RequestParam(value="taxonomyAnalysis") boolean taxonomyAnalysis,
                                   @RequestParam(value="emotionAnalysis") boolean emotionAnalysis,
                                   @RequestParam(value="timeAnalysis") boolean timeAnalysis) {
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

        if(taxonomyAnalysis){
            TaxonomyModel taxonomyModel = new TaxonomyModel(dataService.getTaxonomy());
            returnableModel.setTaxonomyModel(taxonomyModel);
        }
        if(emotionAnalysis){
            EmotionModel emotionModel = new EmotionModel(dataService.getEmotion());
            returnableModel.setEmotionModel(emotionModel);
        }

        if(timeAnalysis) {
            TimeModel timeModel = new TimeModel(dataService.getTimeList());
            returnableModel.setTimeModel(timeModel);
        }

        return returnableModel;
    }

}
