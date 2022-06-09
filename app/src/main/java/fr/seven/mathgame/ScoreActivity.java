package fr.seven.mathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ScoreActivity extends AppCompatActivity {
    public static int score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
    }

    public static void initiateScore(){
        int score=0;
    }

    public static int getScore() {
        return score;
    }

    public static void setScore(int x) {
        score = score + x;
    }


}