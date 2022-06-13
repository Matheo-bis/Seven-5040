package fr.seven.mathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Jeu2Activity extends AppCompatActivity {
    private String equation;
    private String equation1;
    private String equation2;
    private String equation3;
    private String equation4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeu2);
        setQuestion(DebutantJeu2.equation());
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

            Button qcmbutton1 = findViewById(R.id.buttonequation4);
            Button qcmbutton2 = findViewById(R.id.buttonequation5);
            Button qcmbutton3 = findViewById(R.id.buttonequation6);
            Button qcmbutton4 = findViewById(R.id.buttonequation7);
            View space = findViewById(R.id.Space);
            int comparaison = button.compareTo(DebutantJeu2.bonneequation());
            if (comparaison == 0) {
                Intent intent = new Intent(this, EcranFinActivity.class);
                intent.putExtra("action", "win");
                startActivity(intent);
                ScoreActivity.setScore(1);
            } else {
                Intent intent = new Intent(this, EcranFinActivity.class);
                intent.putExtra("action", "lose");
                startActivity(intent);
            }
        }


        public void setQuestion (String str){
            ((TextView) findViewById(R.id.textView7)).setText(Html.fromHtml(str));
        }
    }