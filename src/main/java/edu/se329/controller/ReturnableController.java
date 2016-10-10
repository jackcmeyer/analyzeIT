package edu.se329.controller;

import edu.se329.client.model.Returnable;
import edu.se329.client.model.ReturnableModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Jack on 10/10/2016.
 */
@RestController
public class ReturnableController {

    private ReturnableModel returnableModel;
    public ReturnableController(ReturnableModel returnableModel) {
        this.returnableModel = returnableModel;
    }

    @RequestMapping("/api/v1/data/getData")
    public ArrayList<Returnable> getData(@RequestParam(value="hashtagCount") Boolean hashtagCount,
                                         @RequestParam(value="mentionCount") Boolean mentionCount) {

        ArrayList<Returnable> returnables = new ArrayList<>();
        if(hashtagCount == true) {
            returnables.add(returnableModel.getHashtagModel());
        }

        if(mentionCount == true) {
            returnables.add(returnableModel.getMentionmodel());
        }

        return returnables;
    }

}
