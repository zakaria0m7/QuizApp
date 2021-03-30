package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Quiz1 extends AppCompatActivity {
    TextView tvQuestion,tvTest;
    ImageView imageView;
    RadioButton radioButton1,radioButton2,radioButton3;
    RadioGroup radioGroup;
    Button bNext;
    QuestionList qList = new QuestionList();
    int score=0,r=0;
    int index=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz1);


        imageView = (ImageView) findViewById(R.id.ivPicture);
        tvQuestion = (TextView) findViewById(R.id.tvQuestion);
        radioGroup = (RadioGroup) findViewById(R.id.rgroup);
        radioButton1 = (RadioButton) findViewById(R.id.rb1);
        radioButton2 = (RadioButton) findViewById(R.id.rb2);
        radioButton3 = (RadioButton) findViewById(R.id.rb3);
        bNext = (Button) findViewById(R.id.bNext);



        imageView.setImageResource(qList.liste.get(0).getPicture());
        tvQuestion.setText(qList.liste.get(0).getQuest());
        radioButton1.setText(qList.liste.get(0).getChoices()[0]);
        radioButton2.setText(qList.liste.get(0).getChoices()[1]);
        radioButton3.setText(qList.liste.get(0).getChoices()[2]);





            bNext.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View v) {

                    if (radioGroup.getCheckedRadioButtonId() == -1) {
                        Toast.makeText(getApplicationContext(), "You must chose a answer ", Toast.LENGTH_SHORT).show();
                    } else
                        {

                        if (qList.liste.size() > index) {
                            r = 0;

                            if (radioGroup.getCheckedRadioButtonId() == -1) {
                                Toast.makeText(getApplicationContext(), "You must chose a answer ", Toast.LENGTH_SHORT).show();
                            } else {
                                if (radioButton1.isChecked())
                                    r = 1;
                                if (radioButton2.isChecked())
                                    r = 2;
                                if (radioButton3.isChecked())
                                    r = 3;

                                if ((r == 1) && (qList.liste.get(index - 1).getAnswer() == 1))
                                    score++;
                                else if ((r == 2) && (qList.liste.get(index - 1).getAnswer() == 2))
                                    score++;
                                else if ((r == 3) && (qList.liste.get(index - 1).getAnswer() == 3))
                                    score++;


                                imageView.setImageResource(qList.liste.get(index).getPicture());
                                tvQuestion.setText(qList.liste.get(index).getQuest());
                                radioButton1.setText(qList.liste.get(index).getChoices()[0]);
                                radioButton2.setText(qList.liste.get(index).getChoices()[1]);
                                radioButton3.setText(qList.liste.get(index).getChoices()[2]);

                                radioGroup.clearCheck();


                                index++;
                            }

                        } else {
                            r=0;
                            if (radioButton1.isChecked())
                                r = 1;
                            if (radioButton2.isChecked())
                                r = 2;
                            if (radioButton3.isChecked())
                                r = 3;

                            if ((r == 1) && (qList.liste.get(index - 1).getAnswer() == 1))
                                score++;
                            else if ((r == 2) && (qList.liste.get(index - 1).getAnswer() == 2))
                                score++;
                            else if ((r == 3) && (qList.liste.get(index - 1).getAnswer() == 3))
                                score++;

                            Toast.makeText(getApplicationContext(), "Quiz Finished ", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), Score.class).putExtra("score", score));
                            finish();
                        }
                    }
                }
            });

        }
    }



