package com.example.quizapp;

import java.util.ArrayList;
import java.util.List;

public class Question {
    private int idPicture;
    private String quest;
    private String[] choices;
    private int answer;

    public Question(String quest, String[] choices,int idPicture, int answer) {
        this.idPicture=idPicture;
        this.quest = quest;
        this.choices = choices;
        this.answer = answer;
    }



    public int getPicture() {
        return idPicture;
    }

    public void setPicture(int idPicture) {
        this.idPicture = idPicture;
    }

    public String getQuest() {
        return quest;
    }

    public void setQuest(String quest) {
        this.quest = quest;
    }

    public String[] getChoices() {
        return choices;
    }

    public void setChoices(String[] choices) {
        this.choices = choices;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }
}
