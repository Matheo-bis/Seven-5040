package fr.seven.mathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LancementJeu2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lancement_jeu2);
    }
    public void launchGame2(View v) {
        Intent intent=new Intent(this, Jeu2Activity.class);
        startActivity(intent);
    }
}