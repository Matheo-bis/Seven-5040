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
import android.provider.MediaStore;
import android.view.View;
import android.widget.VideoView;

public class EcranFinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecran_fin);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            switch(getIntent().getStringExtra("action")){
                case "lose":
                    lose(null);
                    break;
                case "win":
                    win(null);
                    break;
                default:
                    wide(null);
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void win(View view){
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        long[] a = {0,50,50,50};
        VibrationEffect V  = VibrationEffect.createWaveform(a,-1);
        v.vibrate(V);

        VideoView videoView = findViewById(R.id.videoView);
        if((getApplicationContext().getResources().getConfiguration().uiMode& Configuration.UI_MODE_NIGHT_YES)!=0)
            videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.victory_dark));
        else
            videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.victory));
        videoView.setZOrderOnTop(true);
        videoView.seekTo(0);
        videoView.start();
        videoView.setVisibility(View.VISIBLE);
        findViewById(R.id.losetext).setVisibility(View.GONE);
        findViewById(R.id.wintext).setVisibility(View.VISIBLE);
        findViewById(R.id.trolltext).setVisibility(View.GONE);

        MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.wide);
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.victory_audio);

        mediaPlayer.seekTo(400);
        mediaPlayer.start();
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Intent intent=new Intent(getApplicationContext(), Jeu1Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public void wide(View view){
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        long[] a = {0,200,200,200,200,200};
        VibrationEffect V  = VibrationEffect.createWaveform(a,-1);
        v.vibrate(V);

        VideoView videoView = findViewById(R.id.videoView);
        if((getApplicationContext().getResources().getConfiguration().uiMode& Configuration.UI_MODE_NIGHT_YES)!=0)
            videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.wide_dark));
        else
            videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.wide));
        videoView.setZOrderOnTop(true);
        videoView.seekTo(0);
        videoView.start();
        videoView.setVisibility(View.VISIBLE);
        findViewById(R.id.losetext).setVisibility(View.GONE);
        findViewById(R.id.wintext).setVisibility(View.GONE);
        findViewById(R.id.trolltext).setVisibility(View.VISIBLE);

        MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.wide);
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.wide_audio);
        mediaPlayer.start();
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Intent intent=new Intent(getApplicationContext(), Jeu1Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public void lose(View view){
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        long[] a = {0,150,60,150};
        VibrationEffect V  = VibrationEffect.createWaveform(a,-1);
        v.vibrate(V);
        VideoView videoView = findViewById(R.id.videoView);
        if((getApplicationContext().getResources().getConfiguration().uiMode& Configuration.UI_MODE_NIGHT_YES)!=0)
            videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.lose_dark));
        else
            videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.lose));        videoView.setZOrderOnTop(true);
        videoView.seekTo(0);
        videoView.start();
        videoView.setVisibility(View.VISIBLE);
        findViewById(R.id.losetext).setVisibility(View.VISIBLE);
        findViewById(R.id.wintext).setVisibility(View.GONE);
        findViewById(R.id.trolltext).setVisibility(View.GONE);
        MediaPlayer mediaPlayer;
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.lose_audio);
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                finish();
            }
        });

        mediaPlayer.start();
    }

    public void reset(View view){
        VideoView videoView = findViewById(R.id.videoView);
        videoView.setVisibility(View.INVISIBLE);
        findViewById(R.id.losetext).setVisibility(View.GONE);
        findViewById(R.id.wintext).setVisibility(View.GONE);
        findViewById(R.id.trolltext).setVisibility(View.GONE);

    }

}