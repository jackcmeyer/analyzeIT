package edu.se329.client.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jack on 10/10/2016.
 */
public class HashtagModel {

    Map<String, Integer> hashtagCount;

    public HashtagModel(Map<String, Integer> hashtagCount) {
        this.hashtagCount = hashtagCount;
    }

    public Map<String, Integer> getHashtagCount() {
        return hashtagCount;
    }

    public void setHashtagCount(HashMap<String, Integer> userCount) {
        this.hashtagCount = userCount;
    }
}
