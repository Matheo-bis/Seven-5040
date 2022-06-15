package fr.seven.mathgame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ParametresActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, SeekBar.OnSeekBarChangeListener {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    public static int selectiondifficultes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametres);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = sharedPreferences.edit();

        Spinner spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.difficulties, R.layout.spinner);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }

    protected void onStart() {
        super.onStart();

        Spinner spinner = findViewById(R.id.spinner);
        int pos=-1;
        switch (sharedPreferences.getString("Difficulty", "ERREUR")){
            case "Débutant":
                pos=0;
                selectiondifficultes =1;
                break;
            case "Intermédiaire":
                pos=1;
                selectiondifficultes =2;
                break;
            case "Expert":
                pos=2;
                selectiondifficultes=3;
                break;
            case "Adaptatif":
                pos=3;
                selectiondifficultes=4;
                break;
            case "ERREUR":
                updateDifficultyInDatabase();
                pos=0;
                selectiondifficultes =1;
                break;
        }
        spinner.setSelection(pos);
        System.out.println("La difficulté est: "+sharedPreferences.getString("Difficulty", "ERREUR"));

        TextView textView1 = findViewById(R.id.volume);
        textView1.setText(String.valueOf(sharedPreferences.getInt("Volume", 100)));

        SeekBar seekBar = findViewById(R.id.seekBar);
        seekBar.setProgress(sharedPreferences.getInt("Volume", 100));
        seekBar.setOnSeekBarChangeListener(this);

        @SuppressLint("UseSwitchCompatOrMaterialCode") Switch toggleVib = findViewById(R.id.switch1);
        toggleVib.setChecked(sharedPreferences.getBoolean("Vibrations", true));
        toggleVib.setOnCheckedChangeListener((buttonView, b) -> {
            editor.putBoolean("Vibrations", b);
            editor.apply();
        });

        if(Build.VERSION.SDK_INT<29){
            @SuppressLint("UseSwitchCompatOrMaterialCode") Switch toggleDark = findViewById(R.id.switch2);
            toggleDark.setVisibility(View.VISIBLE);
            toggleDark.setOnCheckedChangeListener((buttonView, b) -> {
                editor.putBoolean("Dark", b);
                editor.apply();
            });
        }
    }

    //Méthodes du spinner
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String string = (String) adapterView.getItemAtPosition(i);
        editor.putString("Difficulty", string);
        editor.apply();
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() != null) {
            updateDifficultyInDatabase();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    //Méthodes du slider
    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        TextView textView = findViewById(R.id.volume);
        textView.setText(String.valueOf(i));

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        editor.putInt("Volume", seekBar.getProgress());
        editor.apply();
    }

    //Autres méthodes
    public void goto_profil(View view){
        Intent intent=new Intent(this, ProfilActivity.class);
        startActivity(intent);
    }

    public void updateDifficultyInDatabase(){
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

        FirebaseDatabase database = FirebaseDatabase.getInstance("https://projet7-e3b8a-default-rtdb.europe-west1.firebasedatabase.app/");
        DatabaseReference reference = database.getReference("userdata").child(firebaseAuth.getCurrentUser().getUid());
        reference.child("difficulty").setValue(sharedPreferences.getString("Difficulty", "Débutant"));
    }

    public void redo_tuto(View view){
        editor.putBoolean("Tuto_fini", false);
        editor.apply();
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void a_propos(View view){
        new AlertDialog.Builder(this)
        .setTitle("Seven! (A.K.A 5040)")
        .setMessage("Jeu créé par: Félix ASSELINO, Jean BISEL, Fode CISSOKHO, Nicolas COUDRILLIER, Mathéo MARCOUT et Justin SOTTILE")
        .show();
    }
}