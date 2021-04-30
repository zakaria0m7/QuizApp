package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MusicQuiz extends AppCompatActivity {

    MediaPlayer mediaPlayer  ;
    Button bPlay,bStop,bPause;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_quiz);
        mediaPlayer =null;

        bPlay =(Button) findViewById(R.id.bPlay);
        bPause =(Button) findViewById(R.id.bPause);
        bStop =(Button) findViewById(R.id.bStop);

        bPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer==null){
                    mediaPlayer=MediaPlayer.create(MusicQuiz.this,R.raw.billionaire);
                }
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        stopMusic();
                    }
                });
                mediaPlayer.start();
            }
        });

        bStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer !=null)
                mediaPlayer.stop();
                stopMusic();
            }
        });

        bPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer!=null){
                    mediaPlayer.pause();
                }
            }
        });

    }
    private void stopMusic() {
        mediaPlayer.release();
        mediaPlayer =null;
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopMusic();
    }
}