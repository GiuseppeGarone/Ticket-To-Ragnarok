package com.example.giuseppegarone.tickettoragnarok;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class Popup extends Activity {

    public Button confirmButton;           // Pulsante CONFERMA RISPOSTA
    public CheckBox risp1;                 // Checkbox risposta 1
    public CheckBox risp2;                 // Checkbox risposta 2
    public CheckBox risp3;                 // Checkbox risposta 3
    public CheckBox risp4;                 // Checkbox risposta 4
    public String risp1Testo = "";         // Testo risposta 1
    public String risp2Testo = "";         // Testo risposta 2
    public String risp3Testo = "";         // Testo risposta 3
    public String risp4Testo = "";         // Testo risposta 4
    public String rispScelta = "";         // Testo risposta giusta
    public String rispGiusta = "";         // Testo risposta scelta
    public TextView testoDomanda;          // Domanda

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_window);

        // Orientamento landscape
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        // Setto dimensioni popup
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int)(width*.8),(int)(height*.8));

        // Prelevo riferimenti
        testoDomanda = (TextView)findViewById(R.id.testo_domanda);
        risp1 = (CheckBox)findViewById(R.id.risposta1);
        risp2 = (CheckBox)findViewById(R.id.risposta2);
        risp3 = (CheckBox)findViewById(R.id.risposta3);
        risp4 = (CheckBox)findViewById(R.id.risposta4);
        confirmButton = (Button)findViewById(R.id.confirm_button);
        confirmButton.setEnabled(false);

        /*
        provaIntent = (TextView)findViewById(R.id.prova_intent);
        Bundle extras = getIntent().getExtras();
        tmpPunti = extras.getInt("punti");
        provaIntent.setText(Integer.toString(tmpPunti));
        */

        // Memorizzo le risposte
        risp1Testo = risp1.getText().toString();
        risp2Testo = risp2.getText().toString();
        risp3Testo = risp3.getText().toString();
        risp4Testo = risp4.getText().toString();
        rispGiusta = "17 Gennaio 1992";

        // Listener pulsante CONFERMA RISPOSTA
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkAnswer(rispScelta, rispGiusta)) {
                    Toast.makeText(getApplicationContext(), "Risposta corretta!", Toast.LENGTH_SHORT).show();
                    //Intent i = new Intent(getApplicationContext(), WinActivity.class);
                    //startActivity(i);
                } else {
                    Toast.makeText(getApplicationContext(), "Risposta errata!", Toast.LENGTH_SHORT).show();
                    //Intent i = new Intent(getApplicationContext(), LoseActivity.class);
                    //startActivity(i);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        // Disabilito tasto INDIETRO
    }

    // Controllo quale checkbox è stata selezionata
    public void onCheckboxClicked(View view) {

        boolean checked = ((CheckBox) view).isChecked();

        switch(view.getId()) {
            case R.id.risposta1:
                if (checked) {
                    rispScelta = risp1Testo;
                    Toast.makeText(getApplicationContext(), "Risposta selezionata: " + rispScelta, Toast.LENGTH_SHORT).show();
                    confirmButton.setEnabled(true);
                    risp2.setChecked(false);
                    risp3.setChecked(false);
                    risp4.setChecked(false);
                } else {
                    confirmButton.setEnabled(false);
                }
                break;

            case R.id.risposta2:
                if (checked) {
                    rispScelta = risp2Testo;
                    Toast.makeText(getApplicationContext(), "Risposta selezionata: " + rispScelta, Toast.LENGTH_SHORT).show();
                    confirmButton.setEnabled(true);
                    risp1.setChecked(false);
                    risp3.setChecked(false);
                    risp4.setChecked(false);
                } else {
                    confirmButton.setEnabled(false);
                }
                break;

            case R.id.risposta3:
                if (checked) {
                    rispScelta = risp3Testo;
                    Toast.makeText(getApplicationContext(), "Risposta selezionata: " + rispScelta, Toast.LENGTH_SHORT).show();
                    confirmButton.setEnabled(true);
                    risp1.setChecked(false);
                    risp2.setChecked(false);
                    risp4.setChecked(false);
                } else {
                    confirmButton.setEnabled(false);
                }
                break;

            case R.id.risposta4:
                if (checked) {
                    rispScelta = risp4Testo;
                    Toast.makeText(getApplicationContext(), "Risposta selezionata: " + rispScelta, Toast.LENGTH_SHORT).show();
                    confirmButton.setEnabled(true);
                    risp1.setChecked(false);
                    risp2.setChecked(false);
                    risp3.setChecked(false);
                } else {
                    confirmButton.setEnabled(false);
                }
                break;
        }
    }

    // Confronto risposta scelta e risposta giusta
    public boolean checkAnswer(String a, String b) {
        if(a.equals(b)) {
            return true;
        } else {
            return false;
        }
    }
}
