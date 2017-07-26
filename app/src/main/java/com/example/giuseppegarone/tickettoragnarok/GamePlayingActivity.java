package com.example.giuseppegarone.tickettoragnarok;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class GamePlayingActivity extends AppCompatActivity {

    public Button popupButton;
    public ImageButton choosePathButton;    // Pulsante SCEGLI PERCORSO
    public ImageButton goButton;            // Pulsante SEGUI PERCORSO
    public TextView currentRound;           // Round attuale
    public TextView totalRound;             // Round totali
    public TextView score;                  // Punteggio
    public Typeface customFont;             // Font

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_playing);

        // Orientamento landscape
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        // Pulsanti
        choosePathButton = (ImageButton)findViewById(R.id.choose_path_button);
        goButton = (ImageButton)findViewById(R.id.go_button);

        // TextViews
        currentRound = (TextView)findViewById(R.id.current_round);
        score = (TextView)findViewById(R.id.score);
        totalRound = (TextView)findViewById(R.id.total_round);
        customFont = Typeface.createFromAsset(getAssets(), "gameplay.ttf");
        currentRound.setTypeface(customFont);
        score.setTypeface(customFont);
        totalRound.setTypeface(customFont);

        // Pulsante provvisorio per far apparire il popup
        popupButton = (Button)findViewById(R.id.popup_btn);
        popupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                if(time>100) {
                    punteggio = 100;
                } else {
                    punteggio = 1000;
                }
                Intent i = new Intent(GamePlayingActivity.this, Popup.class);
                Bundle b = new Bundle();
                b.putInt("punti", punteggio);
                i.putExtras(b);
                startActivity(i);
                */

                startActivity(new Intent(getApplicationContext(), Popup.class));
            }
        });
    }
}
