package fr.seven.mathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class activity_factorielle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factorielle);

        TextView factorielle_explication = findViewById(R.id.explication_fact);

        String text = "La factorielle d'un entier naturel n, notée n!, ce qui se lit soit \" factorielle de n \" soit \" factorielle n \", est le produit des nombres entiers strictement positifs inférieurs ou égaux à n."+
                "Soit n un entier naturel. Sa factorielle est formellement définie par :\n";

        factorielle_explication.setText(text);
    }
}