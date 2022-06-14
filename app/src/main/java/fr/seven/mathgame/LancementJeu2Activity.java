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
        Button buttonJouer =(Button) findViewById(R.id.buttonJouer);
    }
    public void launchGame(View view){
        Intent intent=new Intent(this, Jeu2_1Activity.class);
        startActivity(intent);
    }
}