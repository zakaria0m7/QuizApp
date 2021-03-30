package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import az.plainpie.PieView;
import az.plainpie.animation.PieAngleAnimation;


public class Score extends AppCompatActivity {
    int score;
    Button bRetry,bExit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        Button bRetry=(Button) findViewById(R.id.bRetry);
        Button bExit=(Button) findViewById(R.id.bExit);

        Intent intent = getIntent();
        score=intent.getIntExtra("score",0);

        PieView pieView = (PieView) findViewById(R.id.pieView);
        pieView.setInnerText(String.valueOf(score*100/5)+"%");
        pieView.setPieAngle(score*360/5);
        PieView animatedPie = (PieView) findViewById(R.id.pieView);

        PieAngleAnimation animation = new PieAngleAnimation(animatedPie);

        animation.setDuration(5000); //This is the duration of the animation in millis
        animatedPie.startAnimation(animation);


        bRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Quiz1.class));
                finish();
            }
        });

        bExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}