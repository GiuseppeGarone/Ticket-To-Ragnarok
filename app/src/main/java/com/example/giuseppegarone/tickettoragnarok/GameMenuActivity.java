package com.example.giuseppegarone.tickettoragnarok;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class GameMenuActivity extends AppCompatActivity {

    public ImageButton playButton;          // Pulsante PLAY
    public ImageButton tutorialButton;      // Pulsante TUTORIAL
    public ImageButton topPlayersButton;    // Pulsante TOP PLAYERS

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_menu);

        // Orientamento landscape
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        // Pulsanti
        playButton = (ImageButton)findViewById(R.id.play_game_button);
        tutorialButton = (ImageButton)findViewById(R.id.tutorial_button);
        topPlayersButton = (ImageButton)findViewById(R.id.top_players_button);

        // Listener pulsanti
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), GamePlayingActivity.class);
                startActivity(i);
            }
        });

        tutorialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), GameTutorialActivity.class);
                startActivity(i);
            }
        });

        /*
        topPlayersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), TopPlayersActivity.class);
                startActivity(i);
            }
        });
        */
    }
}
