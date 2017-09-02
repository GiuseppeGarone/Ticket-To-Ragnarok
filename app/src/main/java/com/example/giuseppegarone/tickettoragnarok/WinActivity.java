package com.example.giuseppegarone.tickettoragnarok;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class WinActivity extends AppCompatActivity {

    EditText editTextName;
    ImageButton buttonAddScore;
    TextView punti;
    TextView titoloVittoria;
    Typeface customFont;

    public int punteggio;
    public String nomeInserito = "";    // Stringa di prova, ma inutile...

    //our database reference object
    DatabaseReference databaseClassifica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

        //getting the reference of classifica node
        databaseClassifica = FirebaseDatabase.getInstance().getReference("Classifica");

        punti = (TextView)findViewById(R.id.punteggio);
        titoloVittoria = (TextView)findViewById(R.id.win_activity_title);
        editTextName = (EditText) findViewById(R.id.editTextName);
        buttonAddScore = (ImageButton) findViewById(R.id.buttonAddScore);

        buttonAddScore.setImageResource(R.drawable.savescore_btn);
        //buttonAddScore.setEnabled(false);

        customFont = Typeface.createFromAsset(getAssets(), "gameplay.ttf");
        titoloVittoria.setTypeface(customFont);

        // Prelevo punteggio dall'intent
        Bundle extra = getIntent().getExtras();
        punteggio = extra.getInt("punti");
        punti.setText(String.valueOf(punteggio));

        nomeInserito = editTextName.getText().toString();
        Log.d("Nome inserito: ", nomeInserito);

        /*
        if(editTextName.getText().toString().trim().length() == 0) {
            buttonAddScore.setImageResource(R.drawable.savescore_btn);
            buttonAddScore.setEnabled(true);
        }
        */

        nomeInserito = editTextName.getText().toString();
        Log.d("Nome inserito 2: ", nomeInserito);

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
        Log.d("Nome: ", nickname);
        int score = punteggio;
        Log.d("Punti: ", Integer.toString(score));

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

    private boolean isEmpty(EditText etText) {
        if (etText.getText().toString().trim().length() > 0)
            return false;

        return true;
    }
}
