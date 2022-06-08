package fr.seven.mathgame;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.ArrayList;

public class Jeu1Activity extends AppCompatActivity {
    private ArrayList<String> EquationHistory = new ArrayList<String>();
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeu1);
        //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        //TEMPORAIRE
        setQuestion(Debutant.equation());

    }

    public void setQuestion(String str){
        EquationHistory.clear();
        EquationHistory.add(str);
        ((TextView)findViewById(R.id.textView)).setText(str);
    }


    public void buttonclick(View view){
        String viewName = view.getResources().getResourceName(view.getId());
        String button = "_";
        switch(viewName) {
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
        }
        TextView textView = findViewById(R.id.textView);
        String text = textView.getText().toString();
        if(text.contains("_")) {
            EquationHistory.add(text.replaceFirst("_", button));
            textView.setText(EquationHistory.get(EquationHistory.size() - 1));
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void buttonOK(View view){
        String text = ((TextView) findViewById(R.id.textView)).getText().toString();
        int comparaison = (Debutant.resultat()).compareTo(text);
        if (comparaison == 0) {
            Intent intent = new Intent(this, EcranFinActivity.class);
            intent.putExtra("action","win");
            startActivity(intent);
        }
        else{
            Intent intent = new Intent(this, EcranFinActivity.class);
            intent.putExtra("action","lose");
            startActivity(intent);
            buttonCE(null);
        }
    }
    public void buttonDEL(View view){
        if(EquationHistory.size()>1)
            EquationHistory.remove(EquationHistory.size()-1);
        TextView textView = findViewById(R.id.textView);
        textView.setText(EquationHistory.get(EquationHistory.size()-1));
    }

    public void buttonCE(View view){
        setQuestion(EquationHistory.get(0));
    }


}
