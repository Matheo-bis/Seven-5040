package fr.seven.mathgame;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.View;
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

        int maxtime = 1000;
        int progresstime = getIntent().getIntExtra("timer",1000);
        int currentprogresstime = getIntent().getIntExtra("timer",1000);

        timebar.setMax(maxtime);
        timebar.setProgress(progresstime);
        int[] currentProgress = {currentprogresstime};

        new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
            currentProgress[0] -= 1;
            timebar.setProgress(currentProgress[0]);
            if(currentProgress[0] != 0){
                new Handler().postDelayed(this, 10);
            }else {
                currentProgress[0]=1000;
                //Fin du jeu, écran de fin
                new Handler().postDelayed(this, 10);
                Intent intent = new Intent(getApplicationContext(), FinJeu3Activity.class);
                intent.putExtra("action", "lose");
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("numero",numeroJeu);
                startActivity(intent);
                finish();

            }
        }
    }, 0);
 }

}
