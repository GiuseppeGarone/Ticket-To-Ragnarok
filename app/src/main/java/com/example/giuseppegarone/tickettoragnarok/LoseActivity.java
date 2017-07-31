package com.example.giuseppegarone.tickettoragnarok;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoseActivity extends AppCompatActivity {

    public Button tryAgainBtn;
    public Button backToMenuBtn;
    public TextView titoloPerdita;
    public Typeface customFont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose);

        // Orientamento landscape
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        tryAgainBtn = (Button)findViewById(R.id.try_again_btn);
        backToMenuBtn = (Button)findViewById(R.id.back_to_menu_btn);
        titoloPerdita = (TextView)findViewById(R.id.lose_activty_title);

        customFont = Typeface.createFromAsset(getAssets(), "gameplay.ttf");
        titoloPerdita.setTypeface(customFont);

        // Listener pulsanti
        tryAgainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), GamePlayingActivity.class);
                startActivity(i);
            }
        });

        backToMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), GameMenuActivity.class);
                startActivity(i);
            }
        });
    }
}
