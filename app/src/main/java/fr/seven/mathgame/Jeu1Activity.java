package fr.seven.mathgame;

import androidx.annotation.RequiresApi;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Jeu1Activity extends Jeu {
    private final ArrayList<String> EquationHistory = new ArrayList<>();
    private String equation1;
    private String equation2;
    private String equation3;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        numeroJeu=1;
        setContentView(R.layout.activity_jeu1);
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
                setQuestion(Intermediaire.equation());
                if (Intermediaire.functequation() == 1) {
                    qcm();
                }
                if (Intermediaire.functequation() == 0) {
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
        if (Intermediaire.functequation() == 1) {
            qcmbutton1.setText(Intermediaire.funcequationqcm(u));
            equation1 = Intermediaire.funcequationqcm(u);
            qcmbutton2.setText(Intermediaire.funcequationqcm(x));
            equation2 = Intermediaire.funcequationqcm(x);
            qcmbutton3.setText(Intermediaire.funcequationqcm(y));
            equation3 = Intermediaire.funcequationqcm(y);
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

        if (Intermediaire.functequation() == 1) {
            comparaison = button.compareTo(Intermediaire.bonneequation());
            verif(comparaison, Intermediaire.bonneequation()+((TextView) findViewById(R.id.textView)).getText().toString());
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
            ScoreActivity.setScore(1);
            Intent intent = new Intent(this, EcranFinActivity.class);
            intent.putExtra("numero",numeroJeu);
            intent.putExtra("action", "win");
            try {
                DatabaseReference databaseReference = FirebaseDatabase.getInstance("https://projet7-e3b8a-default-rtdb.europe-west1.firebasedatabase.app/")
                        .getReference("userdata").child(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid()).child("equations").push();
                databaseReference.child("content").setValue(eq);
                databaseReference.child("status").setValue(true);

            }
            catch(Exception e){
                e.printStackTrace();
            }
            startActivity(intent);
            qcmbutton1.setVisibility(View.GONE);
            qcmbutton2.setVisibility(View.GONE);
            qcmbutton3.setVisibility(View.GONE);
            space.setVisibility(View.GONE);
        } else {
            Intent intent = new Intent(this, EcranFinActivity.class);
            intent.putExtra("action", "lose");
            intent.putExtra("numero",numeroJeu);
            try {
                DatabaseReference databaseReference = FirebaseDatabase.getInstance("https://projet7-e3b8a-default-rtdb.europe-west1.firebasedatabase.app/")
                        .getReference("userdata").child(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid()).child("equations").push();
                databaseReference.child("content").setValue(eq);
                databaseReference.child("status").setValue(false);

            }
            catch(Exception e){
                e.printStackTrace();
            }
            startActivity(intent);
            buttonCE(null);
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
                comparaison = (Intermediaire.resultat()).compareTo(text);
                result= Intermediaire.resultat();
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
            ScoreActivity.setScore(1);
            Intent intent = new Intent(this, EcranFinActivity.class);
            intent.putExtra("numero",numeroJeu);
            intent.putExtra("action", "win");
            try {
                DatabaseReference databaseReference = FirebaseDatabase.getInstance("https://projet7-e3b8a-default-rtdb.europe-west1.firebasedatabase.app/")
                        .getReference("userdata").child(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid()).child("equations").push();
                databaseReference.child("content").setValue(result);
                databaseReference.child("status").setValue(true);

            }
            catch(Exception e){
                e.printStackTrace();
            }
            startActivity(intent);
        } else {
            Intent intent = new Intent(this, EcranFinActivity.class);
            intent.putExtra("action", "lose");
            intent.putExtra("numero",numeroJeu);
            try {
                DatabaseReference databaseReference = FirebaseDatabase.getInstance("https://projet7-e3b8a-default-rtdb.europe-west1.firebasedatabase.app/")
                        .getReference("userdata").child(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid()).child("equations").push();
                databaseReference.child("content").setValue(result);
                databaseReference.child("status").setValue(false);

            }
            catch(Exception e){
                e.printStackTrace();
            }
            startActivity(intent);
            buttonCE(null);
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
