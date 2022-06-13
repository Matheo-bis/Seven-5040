package fr.seven.mathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FinJeu2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fin_jeu2);
    }

    public void goto_jeu2(View view){
        Intent intent=new Intent(this, LancementJeu2Activity.class);
        startActivity(intent);
    }

    public void goto_menu(View view){
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}