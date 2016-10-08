package edu.se329.service;

import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyLanguage;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentSentiment;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Keywords;
import com.ibm.watson.developer_cloud.http.ServiceCall;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AlchemyService {
    String apiKey = "253b52a6f3c79816248b8c24fe80b4cd969f1bbf";
    AlchemyLanguage service = new AlchemyLanguage();

    public AlchemyService(){
        service.setApiKey(apiKey);
    }


    public String getSentiment(Tweet tweet){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(AlchemyLanguage.TEXT, tweet.getText());
//      ServiceCall<Keywords> serviceCall = service.getKeywords(map);
        DocumentSentiment sentiment = service.getSentiment(map).execute();
        return sentiment.toString();
    }

    public String getKeywords(Tweet tweet){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(AlchemyLanguage.TEXT, tweet.getText());
        Keywords keywords = service.getKeywords(map).execute();
        return keywords.toString();
    }
}
