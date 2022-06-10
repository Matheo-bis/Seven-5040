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
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        VideoView videoView = findViewById(R.id.videoView);


    }

    public void goto_jeu1(View view){
        Intent intent=new Intent(this, Jeu1Activity.class);
        startActivity(intent);
    }

    public void goto_calc(View view){
        Intent intent=new Intent(this, CalculatriceActivity.class);
        startActivity(intent);
    }

    public void goto_win(View view){
        Intent intent=new Intent(this, EcranFinActivity.class);
        intent.putExtra("action","win");
        startActivity(intent);
    }

    public void goto_lose(View view){
        Intent intent=new Intent(this, EcranFinActivity.class);
        intent.putExtra("action","lose");
        startActivity(intent);
    }

    public void goto_wide(View view){
        Intent intent=new Intent(this, EcranFinActivity.class);
        intent.putExtra("action","wide");
        startActivity(intent);
    }


    public void goto_settings(View view){
        Intent intent=new Intent(this, ParametresActivity.class);
        startActivity(intent);
    }
}