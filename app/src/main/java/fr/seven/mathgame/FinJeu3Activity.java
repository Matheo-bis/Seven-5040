package fr.seven.mathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

public class FinJeu3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fin_jeu3);
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

    //public void goto_jeu2(View view){
    //Intent intent=new Intent(this, LancementJeu2Activity.class);
    //startActivity(intent);
    //}

    public void goto_menu(View view){
        finish();
    }
    public void win(View view){
        View imagelose = findViewById(R.id.imageView14);
        View imagewin = findViewById(R.id.imageView6);
        View textewin = findViewById(R.id.textViewfin2jeu);
        View textelose = findViewById(R.id.textView11);
        imagewin.setVisibility(View.VISIBLE);
        imagelose.setVisibility(View.GONE);
        textewin.setVisibility(View.VISIBLE);
        textelose.setVisibility(View.GONE);

    }
    public void lose(View view){
        View textewin = findViewById(R.id.textViewfin2jeu);
        View textelose = findViewById(R.id.textView11);
        View imagelose = findViewById(R.id.imageView14);
        View imagewin = findViewById(R.id.imageView6);
        imagelose.setVisibility(View.VISIBLE);
        imagewin.setVisibility(View.GONE);
        textewin.setVisibility(View.GONE);
        textelose.setVisibility(View.VISIBLE);
    }
}