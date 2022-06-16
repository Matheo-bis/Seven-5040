package fr.seven.mathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FinJeu3Activity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fin_jeu3);
       ((TextView)findViewById(R.id.textscorefin3)).setText("Score: "+ getIntent().getIntExtra("score",0));
        switch(getIntent().getStringExtra("action")){
            case "win":
                win(null);
                break;
            default:
                // wide(null);
        }
    }

    public void restart(View view){
        Intent intent=new Intent(this, Jeu3Activity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }

    public void goto_menu(View view){
        finish();
    }
    public void win(View view){
        View imagewin = findViewById(R.id.pouce_haut2);
        View textewin = findViewById(R.id.felicitation2);
        imagewin.setVisibility(View.VISIBLE);
        textewin.setVisibility(View.VISIBLE);

    }
}