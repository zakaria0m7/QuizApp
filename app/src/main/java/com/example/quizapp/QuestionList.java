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

        Question question0=new Question("Que faire lorsque le feu de signalisation passe au orange ?", new String[]{"se preparer pour arreter", "traverser attentivement", "accelerer"},R.drawable.feurouge,1);
        liste.add(question0);

        Question question1=new Question("Comment allez-vous faire face à cette situation ?", new String[]{"tourner rapidement a droite", "continue tout droit", "augmenter la vitesse"},R.drawable.retro,2);
        liste.add(question1);

        Question question2=new Question("Que signifie le panneau de signalisation ?", new String[]{"Virage", "succession de virages", "Fin de la route"},R.drawable.retro2,2);
        liste.add(question2);

        Question question3=new Question("Vous etes en retard, et vous voulez aller a gauche ?", new String[]{"passer rapidement avant le tramway", "attendre un petit peu", "Actionner le klaxon"},R.drawable.tram,2);
        liste.add(question3);

        Question question4=new Question("est ce que c'est bien de répandre au telephone pendant la conduite ?", new String[]{"Non c'est interdit", "oui si c'est urgent", "oui sans aucun soucis"},R.drawable.boitevitesse,1);
        liste.add(question4);
    }



}
