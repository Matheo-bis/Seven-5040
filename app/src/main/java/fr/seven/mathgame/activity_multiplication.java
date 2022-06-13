package fr.seven.mathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.widget.TextView;

public class activity_multiplication extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplication);
        TextView multiplication = findViewById(R.id.explication_mult);

        String multiplication_explication =
        "La multiplication est l'opération qui consiste à faire une addition répétée. \n"+
        "Le produit désigne le résultat de cette opération.\n"+
        "Les facteurs correspondent à chaque composante de la multiplication, c'est-à-dire les nombres qui sont multipliés ensemble.\n"+
        "Si les 2 facteurs sont de mêmes signes, le produit sera positif.\n" +
        "Si les 2 facteurs sont de signes contraires, le produit sera négatif.";


        SpannableString add = new SpannableString(multiplication_explication);

        StyleSpan bold = new StyleSpan(Typeface.BOLD);
        StyleSpan bold1 = new StyleSpan(Typeface.BOLD);
        StyleSpan bold2 = new StyleSpan(Typeface.BOLD);
        StyleSpan bold3 = new StyleSpan(Typeface.BOLD);
        StyleSpan bold4 = new StyleSpan(Typeface.BOLD);
        StyleSpan bold5 = new StyleSpan(Typeface.BOLD);
        StyleSpan bold6 = new StyleSpan(Typeface.BOLD);
        ForegroundColorSpan red = new ForegroundColorSpan(Color.RED);
        ForegroundColorSpan red1 = new ForegroundColorSpan(Color.rgb(255,0,0));
        ForegroundColorSpan red2 = new ForegroundColorSpan(Color.rgb(254,0,0));
        ForegroundColorSpan blue = new ForegroundColorSpan(Color.rgb(0,0,255));
        ForegroundColorSpan blue1 = new ForegroundColorSpan(Color.rgb(0,0,255));
        ForegroundColorSpan green = new ForegroundColorSpan(Color.rgb(0,254,0));
        ForegroundColorSpan green1 = new ForegroundColorSpan(Color.rgb(0,253,0));
        add.setSpan(red,3,17, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        add.setSpan(bold,3,17, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        add.setSpan(red1,81,89, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        add.setSpan(bold1,81,89, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        add.setSpan(red2,133,141, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        add.setSpan(bold2,133,141, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        add.setSpan(blue,279,292, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        add.setSpan(bold3,279,292, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        add.setSpan(blue1,309,316, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        add.setSpan(bold4,309,316, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        add.setSpan(green,343,361, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        add.setSpan(bold5,343,360, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        add.setSpan(green1,379,386, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        add.setSpan(bold5,379,386, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);



        multiplication.setText(add);
    }
}