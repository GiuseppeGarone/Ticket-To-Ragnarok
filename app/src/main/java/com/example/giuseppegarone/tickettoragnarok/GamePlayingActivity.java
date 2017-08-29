package com.example.giuseppegarone.tickettoragnarok;

/*
 *  Modifiche del 29/08:
 *
 *      - pulsanti aggiornati
 *
 */

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class GamePlayingActivity extends AppCompatActivity {

    public Canvas c = new Canvas();
    public ImageButton movimentoOrario;
    public ImageButton movimentoAntiOrario;
    public ImageButton movimentoInterno;
    public ImageButton movimentoEsterno;

    public boolean controllo = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_playing);

        // Orientamento landscape
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        // Aggiungo la ragnatela sopra il layout .xml
        final DrawView v = new DrawView(this);
        final AccensioneRagnatela a = new AccensioneRagnatela();
        a.popola();
        addContentView(v, new ViewGroup.LayoutParams(600, 600));
        v.setX(100);
        v.draw(c);

        movimentoInterno = (ImageButton)findViewById(R.id.movimento2_btn);
        movimentoInterno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(v.i < 10){
                    a.accendere(v.i+15);
                    v.i = v.i + 5;
                } else {
                    v.i = v.i;
                }

                if(v.finito == true) {
                    // a.accendere(tutto);
                    Intent i = new Intent(getApplicationContext(), Popup.class);
                    startActivity(i);
                }

                v.invalidate();
            }
        });

        movimentoEsterno = (ImageButton)findViewById(R.id.movimento3_btn);
        movimentoEsterno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(v.i > 4){
                    a.accendere(v.i+10);
                    v.i = v.i - 5;
                } else {
                    v.i = v.i;
                }

                if(v.finito == true) {
                    // a.accendere(tutto);
                    Intent i = new Intent(getApplicationContext(), Popup.class);
                    startActivity(i);
                }

                v.invalidate();
            }
        });

        movimentoOrario = (ImageButton)findViewById(R.id.movimento1_btn);
        movimentoOrario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(v.i == 4 || v.i == 9 || v.i == 14) {
                    if(v.i == 4) {
                        a.accendere(0);
                        v.i = 0;
                    }
                    if(v.i == 9) {
                        a.accendere(5);
                        v.i = 5;
                    }
                    if(v.i == 14) {
                        a.accendere(10);
                        v.i = 10;
                    }
                } else {
                    if(v.i == 0 || v.i == 1 || v.i == 2 || v.i == 3 || v.i == 5 || v.i == 6 || v.i == 7 || v.i == 8 || v.i == 10 || v.i == 11 || v.i == 12 || v.i == 13) {
                        a.accendere(v.i+1);
                        v.i = v.i + 1;
                    }
                }

                if(v.finito == true) {
                    Intent i = new Intent(getApplicationContext(), Popup.class);
                    startActivity(i);
                }

                v.invalidate();
            }
        });

        movimentoAntiOrario = (ImageButton)findViewById(R.id.change_color_btn);
        movimentoAntiOrario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(v.i == 0 || v.i == 5 || v.i == 10) {
                    if(v.i == 0) {
                        a.accendere(0);
                        v.i = 4;
                    }
                    if(v.i == 5){
                        a.accendere(5);
                        v.i = 9;
                    }
                    if(v.i == 10){
                        a.accendere(10);
                        v.i = 14;
                    }
                } else {
                    if(v.i == 1 || v.i == 2 || v.i == 3 || v.i == 4 || v.i == 6 || v.i == 7 || v.i == 8 || v.i == 9 || v.i == 11 || v.i == 12 || v.i == 13 || v.i == 14) {
                        a.accendere(v.i);
                        v.i = v.i - 1;
                    }
                }

                if(v.finito == true) {
                    Intent i = new Intent(getApplicationContext(), Popup.class);
                    startActivity(i);
                }

                v.invalidate();
            }
        });

    }
}
