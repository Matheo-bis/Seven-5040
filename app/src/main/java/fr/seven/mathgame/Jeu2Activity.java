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
        setQuestion(Debutant.equation());
        if (Debutant.functequation() == 1) {
            qcm();
        }
        if (Debutant.functequation() == 0) {
            Button qcmbutton1 = findViewById(R.id.buttonequation1);
            Button qcmbutton2 = findViewById(R.id.buttonequation2);
            Button qcmbutton3 = findViewById(R.id.buttonequation3);
            View space = findViewById(R.id.Space);
            //qcmbutton1.setVisibility(View.GONE);
            //qcmbutton2.setVisibility(View.GONE);
            //qcmbutton3.setVisibility(View.GONE);
            //space.setVisibility(View.GONE);
        }
    }

        public void qcm () {
            setQuestion(Debutant.equation());
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
            //space.setVisibility(View.VISIBLE);
            //qcmbutton1.setVisibility(View.VISIBLE);
            qcmbutton1.setText(Debutant.funcequationqcm(u));
            equation1 = Debutant.funcequationqcm(u);
            //qcmbutton2.setVisibility(View.VISIBLE);
            qcmbutton2.setText(Debutant.funcequationqcm(x));
            equation2 = Debutant.funcequationqcm(x);
            //qcmbutton3.setVisibility(View.VISIBLE);
            qcmbutton3.setText(Debutant.funcequationqcm(y));
            equation3 = Debutant.funcequationqcm(y);
            qcmbutton4.setText(Debutant.funcequationqcm(z));
            equation4 = Debutant.funcequationqcm(z);

        }
    public void buttonclick(View view) {
        String viewName = view.getResources().getResourceName(view.getId());
        String button = "_";
        switch (viewName) {
            case "fr.seven.mathapp:id/buttonequation1":
                button = equation1;
                break;
            case "fr.seven.mathapp:id/buttonequation2":
                button = equation2;
                break;
            case "fr.seven.mathapp:id/buttonequation3":
                button = equation3;
                break;
        }

        if (Debutant.functequation() == 1) {
            Button qcmbutton1 = findViewById(R.id.buttonequation4);
            Button qcmbutton2 = findViewById(R.id.buttonequation5);
            Button qcmbutton3 = findViewById(R.id.buttonequation6);
            Button qcmbutton4 = findViewById(R.id.buttonequation7);
            View space = findViewById(R.id.Space);
            int comparaison = button.compareTo(Debutant.bonneequation());
            if (comparaison == 0) {
                Intent intent = new Intent(this, EcranFinActivity.class);
                intent.putExtra("action", "win");
                startActivity(intent);
                ScoreActivity.setScore(1);
                //qcmbutton1.setVisibility(View.GONE);
                //qcmbutton2.setVisibility(View.GONE);
                //qcmbutton3.setVisibility(View.GONE);
                //space.setVisibility(View.GONE);
            } else {
                Intent intent = new Intent(this, EcranFinActivity.class);
                intent.putExtra("action", "lose");
                startActivity(intent);
            }
        }
    }

        public void setQuestion (String str){
            ((TextView) findViewById(R.id.textView7)).setText(Html.fromHtml(str));
        }
    }