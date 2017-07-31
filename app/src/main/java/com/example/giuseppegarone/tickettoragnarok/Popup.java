package com.example.giuseppegarone.tickettoragnarok;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Random;

public class Popup extends Activity {

    public Button confirmButton;
    public CheckBox risp1;
    public CheckBox risp2;
    public CheckBox risp3;
    public CheckBox risp4;
    public String risp1Testo = "";
    public String risp2Testo = "";
    public String risp3Testo = "";
    public String risp4Testo = "";
    public String rispScelta = "";
    public String rispGiusta = "";
    public TextView testoDomanda;

    public CountDownTimer countDownTimer;
    public TextView time;

    public double bonus1 = 0.2;
    public double bonus2 = 0.5;
    public int finalScore;
    public int residualTime;
    public int timerDurationSecs = 21;

    //our database reference object
    DatabaseReference databaseDomande;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_window);

        // Orientamento landscape
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        //getting the reference of Domande node
        databaseDomande = FirebaseDatabase.getInstance().getReference("Domande");

        // Setto dimensioni popup
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int)(width*.8),(int)(height*.85));

        // Prelevo riferimenti
        time = (TextView)findViewById(R.id.time_value);
        testoDomanda = (TextView)findViewById(R.id.testo_domanda);
        risp1 = (CheckBox)findViewById(R.id.risposta1);
        risp2 = (CheckBox)findViewById(R.id.risposta2);
        risp3 = (CheckBox)findViewById(R.id.risposta3);
        risp4 = (CheckBox)findViewById(R.id.risposta4);
        confirmButton = (Button)findViewById(R.id.confirm_button);
        confirmButton.setEnabled(false);

        // Avvio timer
        start();

        databaseDomande.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                int n = (int)dataSnapshot.getChildrenCount();

                Random rand = new Random();
                int i = rand.nextInt(n);

                final ArrayList<Question> objects = new ArrayList<>();
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    Question object = child.getValue(Question.class);
                    objects.add(object);
                }
                Question Dscelta = objects.get(i);
                // Memorizzo le risposte
                testoDomanda.setText(Dscelta.getDtext());
                risp1.setText(Dscelta.getR1());
                risp2.setText(Dscelta.getR2());
                risp3.setText(Dscelta.getR3());
                risp4.setText(Dscelta.getR4());
                risp1Testo = Dscelta.getR1();
                risp2Testo = Dscelta.getR2();
                risp3Testo = Dscelta.getR3();
                risp4Testo = Dscelta.getR4();
                rispGiusta = Dscelta.getRgiusta();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        // Listener pulsante CONFERMA RISPOSTA
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkAnswer(rispScelta, rispGiusta)) {
                    scoreBonus(residualTime);
                    cancel();
                    Intent i = new Intent(getApplicationContext(), WinActivity.class);
                    i.putExtra("punti", finalScore);
                    startActivity(i);
                    //Toast.makeText(getApplicationContext(), "Punteggio finale: " + finalScore, Toast.LENGTH_SHORT).show();
                    //Toast.makeText(getApplicationContext(), "Risposta corretta!", Toast.LENGTH_SHORT).show();
                    //Intent i = new Intent(getApplicationContext(), WinActivity.class);
                    //startActivity(i);
                } else {
                    cancel();
                    Intent i = new Intent(getApplicationContext(), LoseActivity.class);
                    startActivity(i);
                    //Toast.makeText(getApplicationContext(), "Risposta errata!", Toast.LENGTH_SHORT).show();
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

    // Partenza timer
    public void start() {

        countDownTimer = new CountDownTimer(timerDurationSecs*1000, 1000) {
            @Override
            public void onTick(long millisUntilFinisched) {
                residualTime = (int)millisUntilFinisched/1000;
                time.setText("" + residualTime);
                if(millisUntilFinisched/1000 < 10) {
                    time.setTextColor(Color.RED);
                }
            }

            // Fine timer
            @Override
            public void onFinish() {
                cancel();
                //Intent i = new Intent(getApplicationContext(), LoseActivity.class);
                //startActivity(i);
            }
        };

        countDownTimer.start();
    }

    // Interruzione timer
    public void cancel() {
        if(countDownTimer != null) {
            countDownTimer.cancel();
            countDownTimer = null;
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

    public int scoreBonus (int n) {
        if(n > 14) {
            finalScore = n + (int)(n * bonus2);
        } else {
            finalScore = n + (int)(n * bonus1);
        }

        return finalScore;
    }
}
