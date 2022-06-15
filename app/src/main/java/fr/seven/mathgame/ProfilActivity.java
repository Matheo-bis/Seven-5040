package fr.seven.mathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.Objects;

public class ProfilActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        try {
            FirebaseUser User = FirebaseAuth.getInstance().getCurrentUser();
            assert User != null;
            if(Objects.requireNonNull(User.getDisplayName()).compareTo("")!=0) {
                ((TextView) findViewById(R.id.textView10)).setText(User.getDisplayName());
            }
            else{
                ((TextView) findViewById(R.id.textView10)).setText(Objects.requireNonNull(User.getEmail()).split("@")[0]);
            }
            Picasso.get().load(User.getPhotoUrl()).into((ImageView) findViewById(R.id.imageView2));
        }
        catch(Exception e) {
            System.out.print(e);
        }

        if (FirebaseAuth.getInstance().getCurrentUser()==null){
            Button button = findViewById(R.id.button);
            button.setText("Se Connecter");
        }
    }

    public void goto_start(View view){
        FirebaseAuth.getInstance().signOut();
        Intent intent=new Intent(this, StartActivity.class);
        startActivity(intent);
    }

    public void del_progression(View view){
        new AlertDialog.Builder(this)
                .setTitle("Supprimer les données?")
                .setMessage("Voulez-vous VRAIMENT supprimer toute la progression?")
                .setPositiveButton("Oui", (dialogInterface, i) -> {
                    if(FirebaseAuth.getInstance().getCurrentUser() != null){
                        FirebaseDatabase database = FirebaseDatabase.getInstance("https://projet7-e3b8a-default-rtdb.europe-west1.firebasedatabase.app/");
                        DatabaseReference reference = database.getReference("userdata").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("score");
                        reference.setValue(0);
                    }
                })
                .setNegativeButton("Non", (dialogInterface, i) -> {

                })
                .show();
    }
}