package edu.se329.client.model;

import java.util.HashMap;

public class KeywordModel {

    /**
     * The word that is being analyzed.
     */
    private String keyword;

    /**
     * A floating point value between 0 and 1. Multiply it by 100 to get the percentage
     */
    private float relevance;

    /**
     * Sentiment: a view of or attitude toward a situation or event; an opinion.
     * A percentage value between -1 and 1.
     * Negative values mean it is a negative view.
     * Positive values mean it is a positive view
     */
    private float sentimentScore;

    /**
     * Sentiment: a view of or attitude toward a situation or event; an opinion.
     * A string that contains the word positive or negative. This represents the view toward the keyword.
     */
    private String sentimentType;

    /**
     * Holds the emotions for the keyword. This usually appears as a list like this:
     * "anger": "0.131215",
     * "disgust": "0.071907",
     * "fear": "0.180424",
     * "joy": "0.02355",
     * "sadness": "0.696004"
     */
    private HashMap<String, Float> emotions;


    // Getters and setters

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public float getRelevance() {
        return relevance;
    }

    public void setRelevance(float relevance) {
        this.relevance = relevance;
    }

    public float getSentimentScore() {
        return sentimentScore;
    }

    public void setSentimentScore(float sentimentScore) {
        this.sentimentScore = sentimentScore;
    }

    public String getSentimentType() {
        return sentimentType;
    }

    public void setSentimentType(String sentimentType) {
        this.sentimentType = sentimentType;
    }

    public HashMap<String, Float> getEmotions() {
        return emotions;
    }

    public void setEmotions(HashMap<String, Float> emotions) {
        this.emotions = emotions;
    }
}
