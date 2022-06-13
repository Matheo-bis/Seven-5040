package fr.seven.mathgame;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.circularreveal.CircularRevealHelper;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ScoreActivity extends AppCompatActivity {
    public static int score;
    private static FirebaseDatabase database;
    private static DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
    }

    public static void initScore(){
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser()!=null) {
            database = FirebaseDatabase.getInstance("https://projet7-e3b8a-default-rtdb.europe-west1.firebasedatabase.app/");
            reference = database.getReference("userdata").child(firebaseAuth.getCurrentUser().getUid());
            reference.child("score").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DataSnapshot> task) {
                    if(task.getResult().exists())
                        score = (int) ((long) task.getResult().getValue());
                    else
                        score=0;
                }
            });
        }
        else {
            score=0;
        }

    }

    public static int getScore() {
        return score;
    }

    public static void setScore(int x) {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        score = score + x;
        if(firebaseAuth.getCurrentUser()!=null)
            reference.child("score").setValue(score);
    }


}