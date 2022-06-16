package fr.seven.mathgame;

import static java.lang.Math.max;

import androidx.annotation.RequiresApi;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.ViewGroup;
import android.widget.ProgressBar;

public class Jeu3Timer extends Jeu{
    protected int scorejeu3 = 0;

    @RequiresApi(api = Build.VERSION_CODES.O)


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeu3);
        ProgressBar timebar = findViewById(R.id.timebar);

        timebar.setMax(1000);
        timebar.setProgress(1000);

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
                    intent.putExtra("action", "win");
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.putExtra("numero", numeroJeu);
                    intent.putExtra("score", scorejeu3);

                    startActivity(intent);
                    finish();

                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }, 0);

 }

}
