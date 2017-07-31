package com.example.giuseppegarone.tickettoragnarok;

import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class WinActivity extends AppCompatActivity {

    public TextView punti;
    public TextView titolo;
    public Typeface customFont;

    public int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

        // Orientamento landscape
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        punti = (TextView)findViewById(R.id.punteggio);
        titolo = (TextView)findViewById(R.id.win_activity_title);

        customFont = Typeface.createFromAsset(getAssets(), "gameplay.ttf");
        titolo.setTypeface(customFont);

        // Prelevo punteggio
        Bundle extra = getIntent().getExtras();
        score = extra.getInt("punti");
        punti.setText(Integer.toString(score));
    }
}
