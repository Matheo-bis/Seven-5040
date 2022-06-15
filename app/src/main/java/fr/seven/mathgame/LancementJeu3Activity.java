package fr.seven.mathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LancementJeu3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lancement_jeu3);
    }
    public void launchGame3(View v) {
        Intent intent=new Intent(this, Jeu3Activity.class);
        startActivity(intent);
        finish();
    }
}