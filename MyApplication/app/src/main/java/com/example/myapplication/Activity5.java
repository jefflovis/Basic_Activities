package com.example.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Activity5 extends AppCompatActivity {

    MediaPlayer mediaPlayer; // Variável de membro para o MediaPlayer

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity5);

        mediaPlayer = MediaPlayer.create(this, R.raw.saiki_lmfo);
        mediaPlayer.setLooping(true);
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (!mediaPlayer.isPlaying()) {
            mediaPlayer.start();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mediaPlayer.release();
    }

    public void goBackToActivity4(View view) {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }

        Intent intent = new Intent(this, Activity4.class);
        startActivity(intent);
    }
}

