package edu.se329.client.model;

public class ReturnableModel {

    private ConceptModel conceptModel;
    private HashtagModel hashtagModel;
    private KeywordModel keywordModel;
    private MentionModel mentionmodel;
    private EmotionModel emotionModel;
    private TaxonomyModel taxonomyModel;

    public ReturnableModel() {
        conceptModel = null;
        hashtagModel = null;
        keywordModel = null;
        mentionmodel = null;
        emotionModel = null;
        taxonomyModel = null;
    }

    public ConceptModel getConceptModel() {
        return conceptModel;
    }

    public void setConceptModel(ConceptModel conceptModel) {
        this.conceptModel = conceptModel;
    }

    public HashtagModel getHashtagModel() {
        return hashtagModel;
    }

    public void setHashtagModel(HashtagModel hashtagModel) {
        this.hashtagModel = hashtagModel;
    }

    public KeywordModel getKeywordModel() {
        return keywordModel;
    }

    public void setKeywordModel(KeywordModel keywordModel) {
        this.keywordModel = keywordModel;
    }

    public MentionModel getMentionmodel() {
        return mentionmodel;
    }

    public void setMentionmodel(MentionModel mentionmodel) {
        this.mentionmodel = mentionmodel;
    }

    public EmotionModel getEmotionModel() {
        return emotionModel;
    }

    public void setEmotionModel(EmotionModel emotionModel) {
        this.emotionModel = emotionModel;
    }

    public TaxonomyModel getTaxonomyModel() {
        return taxonomyModel;
    }

    public void setTaxonomyModel(TaxonomyModel taxonomyModel) {
        this.taxonomyModel = taxonomyModel;
    }
}
