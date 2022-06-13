package fr.seven.mathgame;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class Jeu1Activity extends AppCompatActivity {
    private ArrayList<String> EquationHistory = new ArrayList<String>();
    private String equation;
    private String equation1;
    private String equation2;
    private String equation3;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeu1);
        //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        //TEMPORAIRE
        Button qcmbutton1 = findViewById(R.id.buttonequation1);
        Button qcmbutton2 = findViewById(R.id.buttonequation2);
        Button qcmbutton3 = findViewById(R.id.buttonequation3);
        View space = findViewById(R.id.Space);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        switch (sharedPreferences.getString("Difficulty", "ERREUR")) {
            case "Intermédiaire":
                setQuestion(Intermédiaire.equation());
                if (Intermédiaire.functequation() == 1) {
                    qcm();
                }
                if (Intermédiaire.functequation() == 0) {
                    qcmbutton1.setVisibility(View.GONE);
                    qcmbutton2.setVisibility(View.GONE);
                    qcmbutton3.setVisibility(View.GONE);
                    space.setVisibility(View.GONE);
                }
                break;
            case "Expert":
                setQuestion(Expert.equation());
                if (Expert.functequation() == 1) {
                    qcm();
                }
                if (Expert.functequation() == 0) {
                    qcmbutton1.setVisibility(View.GONE);
                    qcmbutton2.setVisibility(View.GONE);
                    qcmbutton3.setVisibility(View.GONE);
                    space.setVisibility(View.GONE);
                }
                break;
            default:
                setQuestion(Debutant.equation());
                if (Debutant.functequation() == 1) {
                    qcm();
                }
                if (Debutant.functequation() == 0) {
                    qcmbutton1.setVisibility(View.GONE);
                    qcmbutton2.setVisibility(View.GONE);
                    qcmbutton3.setVisibility(View.GONE);
                    space.setVisibility(View.GONE);
                }
        }

    }

    public void qcm() {
        Random rand = new Random();
        Button qcmbutton1 = findViewById(R.id.buttonequation1);
        Button qcmbutton2 = findViewById(R.id.buttonequation2);
        Button qcmbutton3 = findViewById(R.id.buttonequation3);
        View space = findViewById(R.id.Space);
        int u = rand.nextInt(3) + 1;
        int y;
        int x;
        switch (u) {
            case 1:
                x = 3;
                y = 2;
                break;
            case 2:
                x = 1;
                y = 3;
                break;
            default:
                x = 2;
                y = 1;
                break;
        }
        space.setVisibility(View.VISIBLE);
        qcmbutton1.setVisibility(View.VISIBLE);
        qcmbutton2.setVisibility(View.VISIBLE);
        qcmbutton3.setVisibility(View.VISIBLE);
        if (Intermédiaire.functequation() == 1) {
            qcmbutton1.setText(Intermédiaire.funcequationqcm(u));
            equation1 = Intermédiaire.funcequationqcm(u);
            qcmbutton2.setText(Intermédiaire.funcequationqcm(x));
            equation2 = Intermédiaire.funcequationqcm(x);
            qcmbutton3.setText(Intermédiaire.funcequationqcm(y));
            equation3 = Intermédiaire.funcequationqcm(y);
        }
        if (Expert.functequation() == 1) {
            qcmbutton1.setText(Expert.funcequationqcm(u));
            equation1 = Expert.funcequationqcm(u);
            qcmbutton2.setText(Expert.funcequationqcm(x));
            equation2 = Expert.funcequationqcm(x);
            qcmbutton3.setText(Expert.funcequationqcm(y));
            equation3 = Expert.funcequationqcm(y);
        }
        if (Debutant.functequation() == 1) {
            qcmbutton1.setText(Debutant.funcequationqcm(u));
            equation1 = Debutant.funcequationqcm(u);
            qcmbutton2.setText(Debutant.funcequationqcm(x));
            equation2 = Debutant.funcequationqcm(x);
            qcmbutton3.setText(Debutant.funcequationqcm(y));
            equation3 = Debutant.funcequationqcm(y);
        }
    }

    public void setQuestion(String str) {
        EquationHistory.clear();
        EquationHistory.add(str);
        ((TextView) findViewById(R.id.textView)).setText(Html.fromHtml(str));
    }

    public void buttonclick(View view) {
        String viewName = view.getResources().getResourceName(view.getId());
        String button = "_";
        switch (viewName) {
            case "fr.seven.mathapp:id/button1":
                button = "1";
                break;
            case "fr.seven.mathapp:id/button2":
                button = "2";
                break;
            case "fr.seven.mathapp:id/button3":
                button = "3";
                break;
            case "fr.seven.mathapp:id/button4":
                button = "4";
                break;
            case "fr.seven.mathapp:id/button5":
                button = "5";
                break;
            case "fr.seven.mathapp:id/button6":
                button = "6";
                break;
            case "fr.seven.mathapp:id/button7":
                button = "7";
                break;
            case "fr.seven.mathapp:id/button8":
                button = "8";
                break;
            case "fr.seven.mathapp:id/button9":
                button = "9";
                break;
            case "fr.seven.mathapp:id/button0":
                button = "0";
                break;
            case "fr.seven.mathapp:id/buttonadd":
                button = "+";
                break;
            case "fr.seven.mathapp:id/buttonsub":
                button = "-";
                break;
            case "fr.seven.mathapp:id/buttondiv":
                button = "÷";
                break;
            case "fr.seven.mathapp:id/buttonmult":
                button = "×";
                break;
            case "fr.seven.mathapp:id/buttondot":
                button = ".";
                break;
            case "fr.seven.mathapp:id/buttonfac":
                button = "!";
                break;
            case "fr.seven.mathapp:id/buttonpow":
                button = "^";
                break;
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
        TextView textView = findViewById(R.id.textView);
        String text = EquationHistory.get(EquationHistory.size() - 1);

        if (text.contains("_")) {
            EquationHistory.add(text.replaceFirst("_", button));
            textView.setText(Html.fromHtml(EquationHistory.get(EquationHistory.size() - 1)));
        }
        int comparaison;

        if (Intermédiaire.functequation() == 1) {
            comparaison = button.compareTo(Intermédiaire.bonneequation());
            verif(comparaison);
        }

        if (Expert.functequation() == 1) {
            comparaison = button.compareTo(Expert.bonneequation());
            verif(comparaison);
        }

        if (Debutant.functequation() == 1) {
            comparaison = button.compareTo(Debutant.bonneequation());
            verif(comparaison);
        }


    }

    public void verif(int comparaison) {
        Button qcmbutton1 = findViewById(R.id.buttonequation1);
        Button qcmbutton2 = findViewById(R.id.buttonequation2);
        Button qcmbutton3 = findViewById(R.id.buttonequation3);
        View space = findViewById(R.id.Space);
        if (comparaison == 0) {
            Intent intent = new Intent(this, EcranFinActivity.class);
            intent.putExtra("action", "win");
            startActivity(intent);
            ScoreActivity.setScore(1);
            qcmbutton1.setVisibility(View.GONE);
            qcmbutton2.setVisibility(View.GONE);
            qcmbutton3.setVisibility(View.GONE);
            space.setVisibility(View.GONE);
        } else {
            Intent intent = new Intent(this, EcranFinActivity.class);
            intent.putExtra("action", "lose");
            startActivity(intent);
            buttonCE(null);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void buttonOK(View view) {
        String text = ((TextView) findViewById(R.id.textView)).getText().toString();
        int comparaison;
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        switch (sharedPreferences.getString("Difficulty", "ERREUR")) {
            case "Intermédiaire":
                comparaison = (Intermédiaire.resultat()).compareTo(text);
                break;
            case "Expert":
                comparaison = (Expert.resultat()).compareTo(text);
                break;
            default:
                comparaison = (Debutant.resultat()).compareTo(text);
        }
        if (comparaison == 0) {
            Intent intent = new Intent(this, EcranFinActivity.class);
            intent.putExtra("action", "win");
            startActivity(intent);
            ScoreActivity.setScore(1);
        } else {
            Intent intent = new Intent(this, EcranFinActivity.class);
            intent.putExtra("action", "lose");
            startActivity(intent);
            buttonCE(null);
        }
    }

    public void buttonDEL(View view) {
        if (EquationHistory.size() > 1)
            EquationHistory.remove(EquationHistory.size() - 1);
        TextView textView = findViewById(R.id.textView);
        textView.setText(Html.fromHtml(EquationHistory.get(EquationHistory.size() - 1)));
    }

    public void buttonCE(View view) {
        setQuestion(EquationHistory.get(0));
    }


}
