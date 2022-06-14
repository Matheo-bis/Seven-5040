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

public class activity_soustraction extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soustraction);

        TextView soustraction = findViewById(R.id.explication_sous);

        String soustraction_explication =
                "La soustraction est une opération qui consiste à enlever une quantité à une autre, à trouver une quantité manquante ou à comparer des quantités entre elles.\n"+
                "Ces quantités qui forment la soustraction se nomment des termes.\n"+
                "La différence est le résultat de cette opération."+
                "\n \n \n \n \n \n \n \n \n  \n \n"+
                "Dans une soustraction, un emprunt consiste à enlever une dizaine et à la transformer en 10 unités lorsque la valeur du chiffre au-dessus est plus petite que la valeur du chiffre à soustraire." + "\n" +
                "Remarque : on utilise la même technique si on doit emprunter aux centaines, aux unités de mille, etc.)..";

        SpannableString add = new SpannableString(soustraction_explication);

        StyleSpan bold = new StyleSpan(Typeface.BOLD);
        StyleSpan bold1 = new StyleSpan(Typeface.BOLD);
        StyleSpan bold2 = new StyleSpan(Typeface.BOLD);
        ForegroundColorSpan red = new ForegroundColorSpan(Color.RED);
        ForegroundColorSpan red1 = new ForegroundColorSpan(Color.rgb(255,0,0));
        ForegroundColorSpan red2 = new ForegroundColorSpan(Color.rgb(254,0,0));
        add.setSpan(red,3,16, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        add.setSpan(bold,3,16, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        add.setSpan(red1,214,220, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        add.setSpan(bold1,214,220, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        add.setSpan(red2,224,236, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        add.setSpan(bold2,224,236, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);


        soustraction.setText(add);
    }
}