package fr.seven.mathgame;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Html;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.preference.PreferenceManager;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class JeuMultiActivity extends Jeu {
    private ArrayList<String> EquationHistory = new ArrayList<String>();
    private String equation;
    private String equation1;
    private String equation2;
    private String equation3;
    private int jeu1et2;
    public String self_identifier;
    public String enemy_identifier;
    private ProgressBar progress;
    public int jeu1ou2(){return jeu1et2=2;}
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        numeroJeu = 1;
        setContentView(R.layout.activity_jeumulti);
        ((TextView)findViewById(R.id.textView12)).setText(getIntent().getStringExtra("enemy"));
        ((TextView)findViewById(R.id.textView13)).setText(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getDisplayName());
        self_identifier = getIntent().getBooleanExtra("server",false)?"host":"guest";
        enemy_identifier = getIntent().getBooleanExtra("server",false)?"guest":"host";
        progress = findViewById(R.id.progressBar);
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://projet7-e3b8a-default-rtdb.europe-west1.firebasedatabase.app/");
        ChildEventListener enemyEventListener = new ChildEventListener() {
            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {}
            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {}
            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {}
            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String previousChildName) {
                lose_points();
            }
        };
        ChildEventListener selfEventListener = new ChildEventListener() {
            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {}
            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {}
            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {}
            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String previousChildName) {
                gain_points();
            }
        };
        database
                .getReference("match")
                .child(getIntent()
                        .getStringExtra("MatchID"))
                .child(self_identifier)
                .addChildEventListener(selfEventListener);
        database
                .getReference("match")
                .child(getIntent()
                        .getStringExtra("MatchID"))
                .child(enemy_identifier)
                        .addChildEventListener(enemyEventListener);

        loadQuestion();
    }
    private void good(){
        loadQuestion();
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://projet7-e3b8a-default-rtdb.europe-west1.firebasedatabase.app/");
        DatabaseReference databaseReference = database
                .getReference("match")
                .child(getIntent().getStringExtra("MatchID"))
                .child(self_identifier)
                .push();
        databaseReference.setValue(1);
    }
    private void bad(){
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://projet7-e3b8a-default-rtdb.europe-west1.firebasedatabase.app/");
        DatabaseReference databaseReference = database
                .getReference("match")
                .child(getIntent().getStringExtra("MatchID"))
                .child(enemy_identifier)
                .push();
        databaseReference.setValue(1);
        Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
        View textview = findViewById(R.id.textView);
        textview.startAnimation(shake);
        buttonCE(null);
    }
    public void lose_points(){
        if(progress.getProgress()-10<=0) {
            Intent intent = new Intent(this, EcranFinActivity.class);
            intent.putExtra("action","lose");
            startActivity(intent);
            finish();
        }
        ObjectAnimator animator = ObjectAnimator.ofInt(progress, "progress", progress.getProgress(), Math.max(progress.getProgress()-10,0));
        animator.setDuration(100);
        animator.setAutoCancel(true);
        animator.setInterpolator(new DecelerateInterpolator());
        animator.start();    }
    public void gain_points(){
        if(progress.getProgress()+10>=100) {
            Intent intent = new Intent(this, EcranFinActivity.class);
            intent.putExtra("action","wide");
            intent.putExtra("numero",5);

            startActivity(intent);
            finish();
        }
        ObjectAnimator animator = ObjectAnimator.ofInt(progress, "progress", progress.getProgress(), Math.min(progress.getProgress()+10,100));
        animator.setDuration(100);
        animator.setAutoCancel(true);
        animator.setInterpolator(new DecelerateInterpolator());
        animator.start();
    }
    protected void loadQuestion(){
        //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        //TEMPORAIRE
        Button qcmbutton1 = findViewById(R.id.buttonequation1);
        Button qcmbutton2 = findViewById(R.id.buttonequation2);
        Button qcmbutton3 = findViewById(R.id.buttonequation3);
        View space = findViewById(R.id.Space);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String difficulty = sharedPreferences.getString("Difficulty", "ERREUR");
        if(difficulty.equals("Adaptatif")) {
            difficulty = sharedPreferences.getString("ADifficulty", "ERREUR");
        }
        switch (difficulty) {
            case "Intermédiaire":
                setQuestion(Intermédiaire.equation());
                if (Intermédiaire.functequation() == 1) {
                    qcm();
                }
                if (Intermédiaire.functequation() == 0) {
                    qcmbutton1.setVisibility(View.GONE);
                    qcmbutton2.setVisibility(View.GONE);
                    qcmbutton3.setVisibility(View.GONE);
                    space.setVisibility(View.GONE);
                }
                break;
            case "Expert":
                setQuestion(Expert.equation());
                if (Expert.functequation() == 1) {
                    qcm();
                }
                if (Expert.functequation() == 0) {
                    qcmbutton1.setVisibility(View.GONE);
                    qcmbutton2.setVisibility(View.GONE);
                    qcmbutton3.setVisibility(View.GONE);
                    space.setVisibility(View.GONE);
                }
                break;
            default:
                setQuestion(Debutant.equation());
                if (Debutant.functequation() == 1) {
                    qcm();
                }
                if (Debutant.functequation() == 0) {
                    qcmbutton1.setVisibility(View.GONE);
                    qcmbutton2.setVisibility(View.GONE);
                    qcmbutton3.setVisibility(View.GONE);
                    space.setVisibility(View.GONE);
                }
        }
    }

    public void qcm() {
        Random rand = new Random();
        Button qcmbutton1 = findViewById(R.id.buttonequation1);
        Button qcmbutton2 = findViewById(R.id.buttonequation2);
        Button qcmbutton3 = findViewById(R.id.buttonequation3);
        View space = findViewById(R.id.Space);
        int u = rand.nextInt(3) + 1;
        int y;
        int x;
        switch (u) {
            case 1:
                x = 3;
                y = 2;
                break;
            case 2:
                x = 1;
                y = 3;
                break;
            default:
                x = 2;
                y = 1;
                break;
        }
        space.setVisibility(View.VISIBLE);
        qcmbutton1.setVisibility(View.VISIBLE);
        qcmbutton2.setVisibility(View.VISIBLE);
        qcmbutton3.setVisibility(View.VISIBLE);
        if (Intermédiaire.functequation() == 1) {
            qcmbutton1.setText(Intermédiaire.funcequationqcm(u));
            equation1 = Intermédiaire.funcequationqcm(u);
            qcmbutton2.setText(Intermédiaire.funcequationqcm(x));
            equation2 = Intermédiaire.funcequationqcm(x);
            qcmbutton3.setText(Intermédiaire.funcequationqcm(y));
            equation3 = Intermédiaire.funcequationqcm(y);
        }
        if (Expert.functequation() == 1) {
            qcmbutton1.setText(Expert.funcequationqcm(u));
            equation1 = Expert.funcequationqcm(u);
            qcmbutton2.setText(Expert.funcequationqcm(x));
            equation2 = Expert.funcequationqcm(x);
            qcmbutton3.setText(Expert.funcequationqcm(y));
            equation3 = Expert.funcequationqcm(y);
        }
        if (Debutant.functequation() == 1) {
            qcmbutton1.setText(Debutant.funcequationqcm(u));
            equation1 = Debutant.funcequationqcm(u);
            qcmbutton2.setText(Debutant.funcequationqcm(x));
            equation2 = Debutant.funcequationqcm(x);
            qcmbutton3.setText(Debutant.funcequationqcm(y));
            equation3 = Debutant.funcequationqcm(y);
        }
    }

    public void setQuestion(String str) {
        EquationHistory.clear();
        EquationHistory.add(str);
        ((TextView) findViewById(R.id.textView)).setText(Html.fromHtml(str));
    }

    public void buttonclick(View view) {
        String viewName = view.getResources().getResourceName(view.getId());
        String button = "_";
        switch (viewName) {
            case "fr.seven.mathapp:id/button1":
                button = "1";
                break;
            case "fr.seven.mathapp:id/button2":
                button = "2";
                break;
            case "fr.seven.mathapp:id/button3":
                button = "3";
                break;
            case "fr.seven.mathapp:id/button4":
                button = "4";
                break;
            case "fr.seven.mathapp:id/button5":
                button = "5";
                break;
            case "fr.seven.mathapp:id/button6":
                button = "6";
                break;
            case "fr.seven.mathapp:id/button7":
                button = "7";
                break;
            case "fr.seven.mathapp:id/button8":
                button = "8";
                break;
            case "fr.seven.mathapp:id/button9":
                button = "9";
                break;
            case "fr.seven.mathapp:id/button0":
                button = "0";
                break;
            case "fr.seven.mathapp:id/buttonadd":
                button = "+";
                break;
            case "fr.seven.mathapp:id/buttonsub":
                button = "-";
                break;
            case "fr.seven.mathapp:id/buttondiv":
                button = "÷";
                break;
            case "fr.seven.mathapp:id/buttonmult":
                button = "×";
                break;
            case "fr.seven.mathapp:id/buttondot":
                button = ".";
                break;
            case "fr.seven.mathapp:id/buttonfac":
                button = "!";
                break;
            case "fr.seven.mathapp:id/buttonpow":
                button = "^";
                break;
            case "fr.seven.mathapp:id/buttonequation1":
                button = equation1;
                break;
            case "fr.seven.mathapp:id/buttonequation2":
                button = equation2;
                break;
            case "fr.seven.mathapp:id/buttonequation3":
                button = equation3;
                break;
        }
        TextView textView = findViewById(R.id.textView);
        String text = EquationHistory.get(EquationHistory.size() - 1);

        if (text.contains("_")) {
            EquationHistory.add(text.replaceFirst("_", button));
            textView.setText(Html.fromHtml(EquationHistory.get(EquationHistory.size() - 1)));
        }
        int comparaison;

        if (Intermédiaire.functequation() == 1) {
            comparaison = button.compareTo(Intermédiaire.bonneequation());
            verif(comparaison,Intermédiaire.bonneequation()+((TextView) findViewById(R.id.textView)).getText().toString());
        }

        if (Expert.functequation() == 1) {
            comparaison = button.compareTo(Expert.bonneequation());
            verif(comparaison,Expert.bonneequation()+((TextView) findViewById(R.id.textView)).getText().toString());
        }

        if (Debutant.functequation() == 1) {
            comparaison = button.compareTo(Debutant.bonneequation());
            verif(comparaison,Debutant.bonneequation()+((TextView) findViewById(R.id.textView)).getText().toString());
        }


    }

    public void verif(int comparaison,String eq) {
        Button qcmbutton1 = findViewById(R.id.buttonequation1);
        Button qcmbutton2 = findViewById(R.id.buttonequation2);
        Button qcmbutton3 = findViewById(R.id.buttonequation3);
        View space = findViewById(R.id.Space);
        if (comparaison == 0) {

            try {
                DatabaseReference databaseReference = FirebaseDatabase.getInstance("https://projet7-e3b8a-default-rtdb.europe-west1.firebasedatabase.app/")
                        .getReference("userdata").child(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid()).child("equations").push();
                databaseReference.child("content").setValue(eq);
                databaseReference.child("status").setValue(true);

            }
            catch(Exception e){
                System.out.println(e);
            }

            qcmbutton1.setVisibility(View.GONE);
            qcmbutton2.setVisibility(View.GONE);
            qcmbutton3.setVisibility(View.GONE);
            space.setVisibility(View.GONE);
            good();
        } else {

            try {
                DatabaseReference databaseReference = FirebaseDatabase.getInstance("https://projet7-e3b8a-default-rtdb.europe-west1.firebasedatabase.app/")
                        .getReference("userdata").child(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid()).child("equations").push();
                databaseReference.child("content").setValue(eq);
                databaseReference.child("status").setValue(false);

            }
            catch(Exception e){
                System.out.println(e);
            }
            bad();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void buttonOK(View view) {
        String text = ((TextView) findViewById(R.id.textView)).getText().toString();
        int comparaison;
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String difficulty = sharedPreferences.getString("Difficulty", "ERREUR");
        if(difficulty.equals("Adaptatif")) {
            difficulty = sharedPreferences.getString("ADifficulty", "ERREUR");
        }
        String result;
        switch (difficulty) {
            case "Intermédiaire":
                comparaison = (Intermédiaire.resultat()).compareTo(text);
                result=Intermédiaire.resultat();
                break;
            case "Expert":
                comparaison = (Expert.resultat()).compareTo(text);
                result=Expert.resultat();
                break;
            default:
                comparaison = (Debutant.resultat()).compareTo(text);
                result=Debutant.resultat();

        }
        if (comparaison == 0) {
            try {
                DatabaseReference databaseReference = FirebaseDatabase.getInstance("https://projet7-e3b8a-default-rtdb.europe-west1.firebasedatabase.app/")
                        .getReference("userdata").child(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid()).child("equations").push();
                databaseReference.child("content").setValue(result);
                databaseReference.child("status").setValue(true);

            }
            catch(Exception e){
                System.out.println(e);
            }
            good();
        } else {

            try {
                DatabaseReference databaseReference = FirebaseDatabase.getInstance("https://projet7-e3b8a-default-rtdb.europe-west1.firebasedatabase.app/")
                        .getReference("userdata").child(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid()).child("equations").push();
                databaseReference.child("content").setValue(result);
                databaseReference.child("status").setValue(false);

            }
            catch(Exception e){
                System.out.println(e);
            }
            bad();
        }
    }

    public void buttonDEL(View view) {
        if (EquationHistory.size() > 1)
            EquationHistory.remove(EquationHistory.size() - 1);
        TextView textView = findViewById(R.id.textView);
        textView.setText(Html.fromHtml(EquationHistory.get(EquationHistory.size() - 1)));
    }

    public void buttonCE(View view) {
        setQuestion(EquationHistory.get(0));
    }

    public void goto_history(View view){
        Intent intent = new Intent(getApplicationContext(), HistoriqueJeu1Activity.class);
        startActivity(intent);
    }


}
