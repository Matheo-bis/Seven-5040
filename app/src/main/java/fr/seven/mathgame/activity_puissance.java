package fr.seven.mathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class activity_puissance extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puissance);

        TextView explication = findViewById(R.id.explication_puiss);

        String text = "La puissance d'un nombre est le résultat de la multiplication répétée de ce nombre avec lui-même.";

        explication.setText(text);
    }
}