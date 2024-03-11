package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;

public class Home extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private boolean isPlaying = false;

    Button requestbtn;
    private String streamUrl = "https://southsidefmkzn.out.airtime.pro/southsidefmkzn_a";
    private ImageView playPauseImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        requestbtn = findViewById(R.id.requestButton);
        playPauseImageView = findViewById(R.id.playPauseImageView);

        // Set up MediaPlayer
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.setDataSource(streamUrl);
            mediaPlayer.prepareAsync();
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    // Media player is prepared, you can start playing here if needed
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        playPauseImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isPlaying) {
                    startPlaying();
                } else {
                    pausePlaying();
                }
            }
        });

        requestbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, MainActivity4.class));
            }
        });
    }

    private void startPlaying() {
        if (!mediaPlayer.isPlaying()) {
            mediaPlayer.start();
            isPlaying = true;
            playPauseImageView.setImageResource(R.drawable.pause_icon); // Change to your pause icon
        }
    }

    private void pausePlaying() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            isPlaying = false;
            playPauseImageView.setImageResource(R.drawable.play_icon); // Change to your play icon
        }
        // request a song
        requestbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, MainActivity4.class));
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    // onClick method for Location Traffic Update icon
    public void onLocationIconClicked(View view) {
        // Open Location Page
        startActivity(new Intent(Home.this, MainActivity.class));
    }
    // onClick method for About icon
    public void onAboutClicked(View view) {
        // Open About Page
        startActivity(new Intent(Home.this, About.class));
    }
    // onClick method for About icon
    public void onNewsIconClicked(View view) {
        // Open About Page
        startActivity(new Intent(Home.this, MainActivity7.class));
    }
    // onClick method for Shows icon
    public void onShowsIconClicked(View view) {
        // Open Schedules Page
        startActivity(new Intent(Home.this, Schedule.class));
    }
    // onClick method for Weather icon
    public void onWeatherClicked(View view) {
        // Open Weather Page
        startActivity(new Intent(Home.this, MainActivity2.class));
    }
}
