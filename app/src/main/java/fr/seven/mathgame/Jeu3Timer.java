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

public class Jeu3Timer extends Jeu3Activity{

    @RequiresApi(api = Build.VERSION_CODES.O)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ProgressBar timebar = findViewById(R.id.timebar);
    setContentView(R.layout.activity_jeu3);


    timebar.setMax(300);
    timebar.setProgress(300);
    int[] currentProgress = {300};

        new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
            currentProgress[0] -= 1;
            timebar.setProgress(currentProgress[0]);
            if(currentProgress[0] != 0){
                new Handler().postDelayed(this, 10);
            }else
                new Handler().postDelayed(this, 10);

        }
    }, 0);
 }


}
