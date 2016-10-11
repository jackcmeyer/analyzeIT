package edu.se329.client.model;

import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentEmotion;

public class EmotionModel {
    private DocumentEmotion emotionAnalysis;

    public EmotionModel(DocumentEmotion emotionAnalysis) {
        this.emotionAnalysis = emotionAnalysis;
    }

    public DocumentEmotion getEmotionAnalysis() {
        return emotionAnalysis;
    }

    public void setEmotionAnalysis(DocumentEmotion emotionAnalysis) {
        this.emotionAnalysis = emotionAnalysis;
    }
}
