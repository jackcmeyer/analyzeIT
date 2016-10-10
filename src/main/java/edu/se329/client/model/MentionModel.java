package edu.se329.client.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jack on 10/10/2016.
 */
public class MentionModel {

    Map<String, Integer> mentionCount;

    public MentionModel(Map<String, Integer> mentionCount) {
        this.mentionCount = mentionCount;
    }

    public Map<String, Integer> getMentionCount() {
        return mentionCount;
    }

    public void setMentionCount(HashMap<String, Integer> userCount) {
        this.mentionCount = mentionCount;
    }
}
