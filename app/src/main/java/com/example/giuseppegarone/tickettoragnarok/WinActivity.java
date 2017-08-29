package com.example.giuseppegarone.tickettoragnarok;

/*
 *  Modifiche del 29/08:
 *
 *      - pulsante SAVE SCORE
 *
 */

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class WinActivity extends AppCompatActivity {

    EditText editTextName;
    ImageButton buttonAddScore;
    TextView punti;
    TextView titoloVittoria;
    Typeface customFont;

    public int punteggio;

    //our database reference object
    DatabaseReference databaseClassifica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

        // Orientamento landscape
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        //getting the reference of classifica node
        databaseClassifica = FirebaseDatabase.getInstance().getReference("Classifica");

        punti = (TextView)findViewById(R.id.punteggio);
        titoloVittoria = (TextView)findViewById(R.id.win_activity_title);
        editTextName = (EditText) findViewById(R.id.editTextName);
        buttonAddScore = (ImageButton) findViewById(R.id.buttonAddScore);

        customFont = Typeface.createFromAsset(getAssets(), "gameplay.ttf");
        titoloVittoria.setTypeface(customFont);

        // Prelevo punteggio dall'intent
        Bundle extra = getIntent().getExtras();
        punteggio = extra.getInt("punti");
        punti.setText(Integer.toString(punteggio));

        //list to store scores
        //scores = new ArrayList<>();

        //adding an onclicklistener to button
        buttonAddScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //calling the method addScore()
                //the method is defined below
                //this method is actually performing the write operation
                addScore();
                Intent i = new Intent(getApplicationContext(), TopPlayersActivity.class);
                startActivity(i);
            }
        });
    }

    /*
    * This method is saving a new score to the
    * Firebase Realtime Database
    * */
    private void addScore() {
        //getting the values to save
        String nickname = editTextName.getText().toString().trim();
        String score = Integer.toString(punteggio);

        //checking if the value is provided
        if (!TextUtils.isEmpty(nickname)) {

            //getting a unique id using push().getKey() method
            //it will create a unique id and we will use it as the Primary Key for our Score
            String id = databaseClassifica.push().getKey();

            //creating a Score Object
            Score punteggiodatabase = new Score(nickname, score);

            //Saving the Score
            databaseClassifica.child(id).setValue(punteggiodatabase);

            //setting edittext to blank again
            editTextName.setText("");

            //displaying a success toast
            Toast.makeText(this, "New Score added", Toast.LENGTH_LONG).show();
        } else {
            //if the value is not given displaying a toast
            Toast.makeText(this, "Please enter a name", Toast.LENGTH_LONG).show();
        }
    }
}
