package fr.seven.mathgame;

import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.preference.PreferenceManager;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class Jeu3Activity extends Jeu3Timer {
    private final ArrayList<String> EquationHistory = new ArrayList<String>();
    private String equation;
    private String equation1;
    private String equation2;
    private String equation3;
    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_jeu3);
        super.onCreate(savedInstanceState);
        numeroJeu = 3;
        init();
    }

    protected void init(){
        //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        //TEMPORAIRE
        Button qcmbutton1 = findViewById(R.id.buttonequation1);
        Button qcmbutton2 = findViewById(R.id.buttonequation2);
        Button qcmbutton3 = findViewById(R.id.buttonequation3);
        View space = findViewById(R.id.Space);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        switch (sharedPreferences.getString("Difficulty", "ERREUR")) {
            case "Intermédiaire":
                setDifficultyTime(200);
                setQuestion(Intermediaire.equation());
                if (Intermediaire.functequation() == 1) {
                    qcm();
                }
                if (Intermediaire.functequation() == 0) {
                    qcmbutton1.setVisibility(View.GONE);
                    qcmbutton2.setVisibility(View.GONE);
                    qcmbutton3.setVisibility(View.GONE);
                    space.setVisibility(View.GONE);
                }
                break;
            case "Expert":
                setDifficultyTime(800);
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
                setDifficultyTime(100);
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
        ((TextView)findViewById(R.id.textscore3)).setText("Score: "+ scorejeu3);
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
        if (Intermediaire.functequation() == 1) {
            qcmbutton1.setText(Intermediaire.funcequationqcm(u));
            equation1 = Intermediaire.funcequationqcm(u);
            qcmbutton2.setText(Intermediaire.funcequationqcm(x));
            equation2 = Intermediaire.funcequationqcm(x);
            qcmbutton3.setText(Intermediaire.funcequationqcm(y));
            equation3 = Intermediaire.funcequationqcm(y);
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
        int comparaison;
        if (Intermediaire.functequation() == 1) {
            comparaison = button.compareTo(Intermediaire.bonneequation());
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
        if (text.contains("_")) {
            EquationHistory.add(text.replaceFirst("_", button));
            textView.setText(Html.fromHtml(EquationHistory.get(EquationHistory.size() - 1)));
        }


    }

    public void verif(int comparaison) {
        Button qcmbutton1 = findViewById(R.id.buttonequation1);
        Button qcmbutton2 = findViewById(R.id.buttonequation2);
        Button qcmbutton3 = findViewById(R.id.buttonequation3);
        View space = findViewById(R.id.Space);
        if (comparaison == 0) {     //Bonne réponse
            addscorejeu3 += 1;  //set du multiplicateur
            AddScoreJeu3();
            ProgressBar timebar = findViewById(R.id.timebar);
            timebar.setProgress(Math.min(1000,timebar.getProgress()+getDifficultytime()));
            qcmbutton1.setVisibility(View.GONE);
            qcmbutton2.setVisibility(View.GONE);
            qcmbutton3.setVisibility(View.GONE);
            space.setVisibility(View.GONE);
            init();
        } else {                    //Mauvaise réponse
            ProgressBar timebar = findViewById(R.id.timebar);
            timebar.setProgress(Math.min(1000,timebar.getProgress()-150));
            if (addscorejeu3 >3){ addscorejeu3 -= 1; } //set du multiplicateur
            RetScoreJeu3();
            init();
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
                setDifficultyTime(200);
                comparaison = (Intermediaire.resultat()).compareTo(text);
                break;
            case "Expert":
                setDifficultyTime(800);
                comparaison = (Expert.resultat()).compareTo(text);
                break;
            default:
                setDifficultyTime(100);
                comparaison = (Debutant.resultat()).compareTo(text);
        }
        if (comparaison == 0) { //Bonne réponse
            addscorejeu3 += 1;
            AddScoreJeu3();
            ProgressBar timebar = findViewById(R.id.timebar);
            timebar.setProgress(Math.min(1000,timebar.getProgress()+getDifficultytime()));
            init();
        } else {                //Mauvaise reponse
            if (addscorejeu3 >3){ addscorejeu3 -= 1; } //set du multiplicateur
            RetScoreJeu3();
            ProgressBar timebar = findViewById(R.id.timebar);
            timebar.setProgress(Math.min(1000,timebar.getProgress()-150));
            init();
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

    int addscorejeu3 = 1;
    int multiscorejeu3 = 1;
    public void AddScoreJeu3(){
        addscorejeu3 *= multiscorejeu3;
        scorejeu3 = scorejeu3 + addscorejeu3;
    }
    public void RetScoreJeu3(){
        addscorejeu3 *= multiscorejeu3;
        scorejeu3 = scorejeu3 - addscorejeu3;
    }

    int difficultytime;

    public void setDifficultyTime(int x){
        difficultytime = x;
    }

    public int getDifficultytime(){
        return difficultytime;
    }

    @Override
    public void onBackPressed(){
        ProgressBar timebar = findViewById(R.id.timebar);
        ConstraintLayout layout = (ConstraintLayout) timebar.getParent();
        layout.removeView(timebar);
        finish();
    }

}
