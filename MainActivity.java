package com.example.pranathi_v_2_12_2021;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    Button play,pause,stop,reset,forward,backward;
    int starttime = 0 ; // startime is 0s
    int stopttime = 0; // stoptime is 0s by default
    int forwardtime = 5000 ; // 5s for forward
    int backwardtime = 5000 ; // 5s for backwardtime

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.kusu) ;
        play = findViewById(R.id.play);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mediaPlayer.start();
                Toast.makeText(MainActivity.this, "Playing song", Toast.LENGTH_SHORT).show();
            }
        });

        pause = findViewById(R.id.pause);
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.pause();
                Toast.makeText(MainActivity.this, "Pausing song", Toast.LENGTH_SHORT).show();
            }
        });

        stop = findViewById(R.id.end);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
                Toast.makeText(MainActivity.this, "Song stopped", Toast.LENGTH_SHORT).show();
            }
        });

        reset = findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.seekTo(0);
                mediaPlayer.start();
                Toast.makeText(MainActivity.this, "Song restarted", Toast.LENGTH_SHORT).show();
            }
        });

        forward = findViewById(R.id.forward);
        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentpos = mediaPlayer.getCurrentPosition() ;
                if((currentpos+forwardtime) <= (stopttime =
                        mediaPlayer.getDuration())){
                    mediaPlayer.seekTo(currentpos+forwardtime);
                    Toast.makeText(MainActivity.this, "Song forwarded ", Toast.LENGTH_SHORT).show();
                }
            }
        });


        backward = findViewById(R.id.backward);
        backward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentpos1 = mediaPlayer.getCurrentPosition() ;
                if((currentpos1-backwardtime) >= (0)){
                    mediaPlayer.seekTo(currentpos1-backwardtime);
                    Toast.makeText(MainActivity.this, "Success ", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}