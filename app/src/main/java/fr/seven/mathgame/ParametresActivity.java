package fr.seven.mathgame;

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

public class ParametresActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, SeekBar.OnSeekBarChangeListener {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametres);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = sharedPreferences.edit();
        if (!sharedPreferences.contains("Initialized")){
            editor.putBoolean("Initialized", true);
            editor.putString("Difficulty", "Débutant");
            editor.putInt("Volume", 100);
            editor.putBoolean("Vibrations", true);
            if(Build.VERSION.SDK_INT<29){
                editor.putBoolean("Dark", false);
            }
            editor.apply();
        }

        Spinner spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.difficulties, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }

    protected void onStart() {
        super.onStart();
        TextView textView = findViewById(R.id.difficulte);
        textView.setText(sharedPreferences.getString("Difficulty", "ERREUR"));

        Spinner spinner = findViewById(R.id.spinner);
        int pos=-1;
        switch (sharedPreferences.getString("Difficulty", "ERREUR")){
            case "Débutant":
                pos=0;
                break;
            case "Intermédiaire":
                pos=1;
                break;
            case "Expert":
                pos=2;
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
        TextView textView = findViewById(R.id.difficulte);
        String string = (String) adapterView.getItemAtPosition(i);
        textView.setText(string);
        editor.putString("Difficulty", string);
        editor.apply();
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
}