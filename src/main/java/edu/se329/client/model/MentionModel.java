package edu.se329.client.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jack on 10/10/2016.
 */
public class MentionModel implements Returnable {

    Map<String, Integer> userCount;

    public MentionModel(Map<String, Integer> userCount) {
        this.userCount = userCount;
    }

    public Map<String, Integer> getUserCount() {
        return userCount;
    }

    public void setUserCount(HashMap<String, Integer> userCount) {
        this.userCount = userCount;
    }
}
