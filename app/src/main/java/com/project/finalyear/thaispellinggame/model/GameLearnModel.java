package com.project.finalyear.thaispellinggame.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by Namwan on 1/17/2018.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class GameLearnModel {

    private String word;
    private String type;

    public GameLearnModel() {
    }

    public GameLearnModel(String word, String type) {
        this.word = word;
        this.type = type;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
