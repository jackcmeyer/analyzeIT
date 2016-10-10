package edu.se329.client.model;

public class ConceptModel implements Returnable{

    /**
     * The keyword being analyzed.
     */
    private String keyword;

    /**
     * The relevance of the keyword between 0 and 1.
     */
    private float relevance;

    /**
     * AKA - dbpedia in the json array
     */
    private String envidenceUrl;

    /**
     * Some url that I am not sure the usage of.
     */
    private String opencyc;


    // Getters and Setters
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

    public String getEnvidenceUrl() {
        return envidenceUrl;
    }

    public void setEnvidenceUrl(String envidenceUrl) {
        this.envidenceUrl = envidenceUrl;
    }

    public String getOpencyc() {
        return opencyc;
    }

    public void setOpencyc(String opencyc) {
        this.opencyc = opencyc;
    }
}
