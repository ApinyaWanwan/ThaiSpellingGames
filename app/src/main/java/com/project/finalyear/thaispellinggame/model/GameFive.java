package com.project.finalyear.thaispellinggame.model;


public class GameFive {
    private String word;

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

    private String type;


    public GameFive() {

    }

    public GameFive(String word, String type) {
        this.word = word;
        this.type = type;
    }
}
