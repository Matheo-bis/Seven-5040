package fr.seven.mathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class ProfilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        try {
            FirebaseUser User = FirebaseAuth.getInstance().getCurrentUser();
            ((TextView) findViewById(R.id.textView10)).setText(User.getDisplayName());
            Picasso.get().load(User.getPhotoUrl()).into((ImageView) findViewById(R.id.imageView2));
        }
        catch(Exception e) {
            System.err.print(e);
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
                .setMessage("Voulez-vous VRAIMENT supprimer tout la progression?")
                .setPositiveButton("Oui", (dialogInterface, i) -> {
                    if(FirebaseAuth.getInstance().getCurrentUser() != null){
                        FirebaseDatabase database = FirebaseDatabase.getInstance("https://projet7-e3b8a-default-rtdb.europe-west1.firebasedatabase.app/");
                        DatabaseReference reference = database.getReference("userdata").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
                        reference.removeValue();
                    }
                    goto_start(null);
                })
                .setNegativeButton("Non", (dialogInterface, i) -> {

                })
                .show();
    }
}