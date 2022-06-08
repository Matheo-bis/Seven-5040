package fr.seven.mathgame;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.VideoView;

public class EcranFinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecran_fin);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            win(null);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void win(View view){
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(50);

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
        MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.victory_audio);
        mediaPlayer.seekTo(400);
        mediaPlayer.start();
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
        MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.lose_audio);
        mediaPlayer.start();
    }

    public void reset(View view){
        VideoView videoView = findViewById(R.id.videoView);
        videoView.setVisibility(View.INVISIBLE);
        findViewById(R.id.losetext).setVisibility(View.GONE);
        findViewById(R.id.wintext).setVisibility(View.GONE);
    }

}