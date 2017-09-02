package com.example.giuseppegarone.tickettoragnarok;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class GameTutorialActivity extends AppCompatActivity {

    public ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_tutorial);

        GifImageView gifImageView = (GifImageView)findViewById(R.id.GifImageView);
        gifImageView.setGifImageResource(R.drawable.tutorial_p1);
        gifImageView.setScaleX(1.2f);
        gifImageView.setScaleY(1.2f);

        backButton = (ImageButton)findViewById(R.id.back_button);

        //adding an onclicklistener to button
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), GameMenuActivity.class);
                i.putExtra("sender", "winactivity");
                startActivity(i);
            }
        });
    }
}
