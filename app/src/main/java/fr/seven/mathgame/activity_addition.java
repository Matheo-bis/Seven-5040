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

public class activity_addition extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition);

        TextView addition = findViewById(R.id.explication_add);

        String addition_explication =
                "L'addition est une opération qui consiste à ajouter un ou plusieurs nombres à un autre.\n" +
                "Les nombres qui composent l'addition se nomment les termes.\n" +
                "Le résultat obtenu après cette opération se nomme : somme.\n"+
                "\n \n \n \n \n \n \n \n \n \n \n"+
                "Lorsqu’on additionne 2 chiffres et qu’on obtient un nombre dans les dizaines, on place le chiffre des unités sous la ligne et le chiffre des dizaines « en retenue » en haut du chiffre suivant dans l’addition. \n" +
                "On additionnera la retenue en même temps que le chiffre suivant.";

        SpannableString add = new SpannableString(addition_explication);

        StyleSpan bold = new StyleSpan(Typeface.BOLD);
        StyleSpan bold1 = new StyleSpan(Typeface.BOLD);
        StyleSpan bold2 = new StyleSpan(Typeface.BOLD);
        ForegroundColorSpan red = new ForegroundColorSpan(Color.RED);
        ForegroundColorSpan red1 = new ForegroundColorSpan(Color.rgb(255,0,0));
        ForegroundColorSpan red2 = new ForegroundColorSpan(Color.rgb(254,0,0));
        add.setSpan(red,2,10, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        add.setSpan(bold,2,10, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        add.setSpan(red1,139,146, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        add.setSpan(bold1,139,146, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        add.setSpan(red2,200,205, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        add.setSpan(bold2,200,205, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);


        addition.setText(add);
    }
}