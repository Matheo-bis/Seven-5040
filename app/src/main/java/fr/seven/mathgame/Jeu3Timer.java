package fr.seven.mathgame;

import static java.lang.Math.max;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.Random;

public class Jeu3Timer extends Jeu{

    @RequiresApi(api = Build.VERSION_CODES.O)


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeu3);
        ProgressBar timebar = findViewById(R.id.timebar);

        timebar.setMax(1000);
        timebar.setProgress(1000);
        int[] currentProgress = {1000};

        new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
            try {
                timebar.setProgress(max(timebar.getProgress() - 1, 0));
                if (timebar.getProgress() > 0) {
                    new Handler().postDelayed(this, 10);
                } else {
                    timebar.setProgress(1000);
                    //Fin du jeu, écran de fin
                    ((ViewGroup) timebar.getParent()).removeView(timebar);
                    //new Handler().postDelayed(this, 10);
                    Intent intent = new Intent(getApplicationContext(), FinJeu3Activity.class);
                    intent.putExtra("action", "lose");
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.putExtra("numero", numeroJeu);
                    startActivity(intent);
                    finish();

                }
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }, 0);

 }

}
