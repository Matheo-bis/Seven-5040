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
        Intent intent=new Intent(this, Jeu2Activity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }

    public void goto_jeu2(View view){
        finish();
    }
    public void win(View view){
        View imagelose = findViewById(R.id.explosion2);
        View imagewin = findViewById(R.id.pouce2);
        View textewin = findViewById(R.id.felicitation2);
        View textelose = findViewById(R.id.oh_non2);
        imagewin.setVisibility(View.VISIBLE);
        imagelose.setVisibility(View.GONE);
        textewin.setVisibility(View.VISIBLE);
        textelose.setVisibility(View.GONE);

    }
    public void lose(View view){
        View textewin = findViewById(R.id.felicitation2);
        View textelose = findViewById(R.id.oh_non2);
        View imagelose = findViewById(R.id.explosion2);
        View imagewin = findViewById(R.id.pouce2);
        imagelose.setVisibility(View.VISIBLE);
        imagewin.setVisibility(View.GONE);
        textewin.setVisibility(View.GONE);
        textelose.setVisibility(View.VISIBLE);
    }
}