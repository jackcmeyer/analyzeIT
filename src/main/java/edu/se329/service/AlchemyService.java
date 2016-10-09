package edu.se329.service;

import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyLanguage;
import com.ibm.watson.developer_cloud.alchemy.v1.model.*;
import com.ibm.watson.developer_cloud.http.ServiceCall;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AlchemyService {
    String apiKey = "253b52a6f3c79816248b8c24fe80b4cd969f1bbf";
    AlchemyLanguage service = new AlchemyLanguage();


    public AlchemyService(){
        service.setApiKey(apiKey);
    }


    //We're not actually using this one I don't think
    public String getSentiment(List<Tweet> tweets){
        Map<String, Object> map = new HashMap<String, Object>();
        StringBuilder builder = new StringBuilder();
        for(Tweet tweet : tweets){
            builder.append(tweet.getText());
        }
        //Put our arguments in our map which gets sent to Watson
        map.put(AlchemyLanguage.TEXT, builder.toString());

        DocumentSentiment sentiment = service.getSentiment(map).execute();
        return sentiment.toString();
    }

    public String getTaxonomy(List<Tweet> tweets){
        Map<String, Object> map = new HashMap<String, Object>();
        StringBuilder builder = new StringBuilder();

       for(Tweet tweet : tweets){
           builder.append(tweet.getText());
        }

        map.put(AlchemyLanguage.TEXT, builder.toString());

        Taxonomies taxonomies = service.getTaxonomy(map).execute();
        return taxonomies.toString();
    }

    public String getEmotions(List<Tweet> tweets){
        Map<String, Object> map = new HashMap<String, Object>();
        StringBuilder builder = new StringBuilder();

        for(Tweet tweet : tweets){
            builder.append(tweet.getText());
        }

        map.put(AlchemyLanguage.TEXT, builder.toString());

        DocumentEmotion emotion = service.getEmotion(map).execute();
        return emotion.toString();

    }
}
