package fr.seven.mathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

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
        View imagelose = findViewById(R.id.explosion3);
        View imagewin = findViewById(R.id.pouce3);
        View textewin = findViewById(R.id.felicitation3);
        View textelose = findViewById(R.id.oh_non3);
        imagewin.setVisibility(View.VISIBLE);
        imagelose.setVisibility(View.GONE);
        textewin.setVisibility(View.VISIBLE);
        textelose.setVisibility(View.GONE);

    }
    public void lose(View view){
        View textewin = findViewById(R.id.felicitation3);
        View textelose = findViewById(R.id.oh_non3);
        View imagelose = findViewById(R.id.explosion3);
        View imagewin = findViewById(R.id.pouce3);
        imagelose.setVisibility(View.VISIBLE);
        imagewin.setVisibility(View.GONE);
        textewin.setVisibility(View.GONE);
        textelose.setVisibility(View.VISIBLE);
    }
}