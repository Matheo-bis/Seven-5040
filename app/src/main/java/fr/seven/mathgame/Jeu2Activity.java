package fr.seven.mathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Jeu2Activity extends Jeu {
    private String equation;
    private String equation1;
    private String equation2;
    private String equation3;
    private String equation4;
    private int compteur;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        numeroJeu=2;
        setContentView(R.layout.activity_jeu2);
        compteur = getIntent().getIntExtra("compteur",0);
        qcm();
    }

        public void qcm () {
            setQuestion(DebutantJeu2.equation());
            Random rand = new Random();
            Button qcmbutton1 = findViewById(R.id.buttonequation4);
            Button qcmbutton2 = findViewById(R.id.buttonequation5);
            Button qcmbutton3 = findViewById(R.id.buttonequation6);
            Button qcmbutton4 = findViewById(R.id.buttonequation7);
            View space = findViewById(R.id.Space);
            int u = rand.nextInt(4) + 1;
            int z;
            int y;
            int x;
            switch (u) {
                case 1:
                    z = 4;
                    x = 3;
                    y = 2;
                    break;
                case 2:
                    z = 2;
                    x = 4;
                    y = 3;
                    break;
                default:
                    z = 3;
                    x = 1;
                    y = 4;
                    break;
            }
            qcmbutton1.setText(DebutantJeu2.funcequationqcm(u));
            equation1 = DebutantJeu2.funcequationqcm(u);
            qcmbutton2.setText(DebutantJeu2.funcequationqcm(x));
            equation2 = DebutantJeu2.funcequationqcm(x);
            qcmbutton3.setText(DebutantJeu2.funcequationqcm(y));
            equation3 = DebutantJeu2.funcequationqcm(y);
            qcmbutton4.setText(DebutantJeu2.funcequationqcm(z));
            equation4 = DebutantJeu2.funcequationqcm(z);
        }
    public void buttonclick(View view) {
        String viewName = view.getResources().getResourceName(view.getId());
        String button = "_";
        switch (viewName) {
            case "fr.seven.mathapp:id/buttonequation4":
                button = equation1;
                break;
            case "fr.seven.mathapp:id/buttonequation5":
                button = equation2;
                break;
            case "fr.seven.mathapp:id/buttonequation6":
                button = equation3;
                break;
            case "fr.seven.mathapp:id/buttonequation7":
                button = equation4;
                break;
        }

            int comparaison = button.compareTo(DebutantJeu2.bonneequation());
            if (comparaison == 0) {
                Intent intent = new Intent(this, Jeu2Activity.class);
                intent.putExtra("action", "win");
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("numero",numeroJeu);
                intent.putExtra("compteur",compteur);
                startActivity(intent);
                finish();
            } else {
                Intent intent = new Intent(this, FinJeu2Activity.class);
                intent.putExtra("action", "lose");
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("numero",numeroJeu);
                startActivity(intent);
                finish();
            }
            /**if(compteur==4) {
                Intent intent = new Intent(this, FinJeu2Activity.class);
                intent.putExtra("action", "lose");
                startActivity(intent);
            }**/
            }


        public void setQuestion (String str){
            View textvert = findViewById(R.id.textViewvert);
            ((TextView) findViewById(R.id.textViewvert)).setText(Html.fromHtml(str));
            textvert.setVisibility(View.VISIBLE);
            switch (compteur){
                case 0:
                    compteur++;
                    break;
                case 1:
                    textvert.setBackgroundColor(Color.RED);
                    compteur++;
                    break;
                case 2:
                    textvert.setBackgroundColor(Color.BLUE);
                    compteur++;
                    break;
                case 3:
                    textvert.setBackgroundColor(Color.MAGENTA);
                    compteur++;
                    break;
                default:
                    Intent intent = new Intent(this, FinJeu2Activity.class);
                    intent.putExtra("action", "win");
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
            }

        }
    }