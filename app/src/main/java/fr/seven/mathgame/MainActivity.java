package fr.seven.mathgame;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.appcheck.FirebaseAppCheck;
import com.google.firebase.appcheck.safetynet.SafetyNetAppCheckProviderFactory;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        try {
            FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
            FirebaseUser User = firebaseAuth.getCurrentUser();
            if(User.getDisplayName()!=null && User.getDisplayName().compareTo("")!=0) {
                ((TextView) findViewById(R.id.textView4)).setText(User.getDisplayName());
            }
            else{
                ((TextView) findViewById(R.id.textView4)).setText(User.getEmail().split("@")[0]);
            }
            Picasso.get().load(User.getPhotoUrl()).into((ImageView) findViewById(R.id.imageView));
        }
        catch(Exception e) {
            System.err.print(e);
        }
        //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        VideoView videoView = findViewById(R.id.videoView);


    }

    public void goto_jeu1(View view){
        Intent intent=new Intent(this, Jeu1Activity.class);
        startActivity(intent);
    }

    public void goto_jeu2(View view){
        Intent intent=new Intent(this, Jeu2Activity.class);
        startActivity(intent);
    }

    public void goto_jeu3(View view){
        Intent intent=new Intent(this, Jeu3Activity.class);
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