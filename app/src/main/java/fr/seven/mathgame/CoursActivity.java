package fr.seven.mathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CoursActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cours);
    }

    public void goto_addition(View view){
        Intent intent = new Intent(this, activity_addition.class);
        startActivity(intent);
    }
    public void goto_soustraction(View view){
        Intent intent = new Intent(this, activity_soustraction.class);
        startActivity(intent);
    }
    public void goto_multiplication(View view){
        Intent intent = new Intent(this, activity_multiplication.class);
        startActivity(intent);
    }
    public void goto_division(View view){
        Intent intent = new Intent(this, activity_division.class);
        startActivity(intent);
    }

    public void goto_factorielle(View view){
        Intent intent = new Intent(this, activity_factorielle.class);
        startActivity(intent);
    }
    public void goto_puissance(View view) {
        Intent intent = new Intent(this, activity_puissance.class);
        startActivity(intent);
    }
}