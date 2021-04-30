package com.example.quizapp;

import java.util.ArrayList;
import java.util.List;

public class QuestionList {
     List<Question> liste;

    public List<Question> getListe() {
        return liste;
    }

    public void setListe(List<Question> liste) {
        this.liste = liste;
    }

    public QuestionList() {
        liste=new ArrayList<Question>();

        Question question0=new Question("What is the name of this King of fighter character  ?", new String[]{"Yashiro Nanakase", "Ryuji Yamazaki", "Iori Yagami"},R.drawable.iori2,3);
        liste.add(question0);

        Question question1=new Question("What is the name of mario's brother ?", new String[]{"Sonic", "Luigi", "Picola"},R.drawable.mario,2);
        liste.add(question1);

        Question question2=new Question("What is the name of this Game ?", new String[]{"World of warcraft", "Dofus", "League of legend"},R.drawable.lol,3);
        liste.add(question2);

        Question question3=new Question("Who is this character ?", new String[]{"Ali zawa", "Carl jhonson", "Lmheydi from wja3 trab"},R.drawable.cj,2);
        liste.add(question3);

        Question question4=new Question("What is the name of this Game ?", new String[]{"Puzzle Bubble", "Metal Slug", "Cadillacs of Dinosors"},R.drawable.mustapha,3);
        liste.add(question4);
    }



}
