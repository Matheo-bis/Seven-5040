package fr.seven.mathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FinJeu3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fin_jeu3);
       //((TextView)findViewById(R.id.textscorefin3)).setText("Score: "+ getIntent().getIntExtra("score",0));
        switch(getIntent().getStringExtra("action")){
            case "lose":
                lose(null);
                break;
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
        View imagelose = findViewById(R.id.pouce_bas3);
        View imagewin = findViewById(R.id.pouce_haut2);
        View textewin = findViewById(R.id.felicitation2);
        View textelose = findViewById(R.id.oh_non2);
        imagewin.setVisibility(View.VISIBLE);
        imagelose.setVisibility(View.GONE);
        textewin.setVisibility(View.VISIBLE);
        textelose.setVisibility(View.GONE);

    }
    public void lose(View view){
        View imagelose = findViewById(R.id.pouce_bas3);
        View imagewin = findViewById(R.id.pouce_haut2);
        View textewin = findViewById(R.id.felicitation2);
        View textelose = findViewById(R.id.oh_non2);
        imagelose.setVisibility(View.VISIBLE);
        imagewin.setVisibility(View.GONE);
        textewin.setVisibility(View.GONE);
        textelose.setVisibility(View.VISIBLE);
    }
}