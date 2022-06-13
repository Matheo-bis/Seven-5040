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

public class activity_division extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_division);

        TextView division = findViewById(R.id.explication_div);
        TextView div1 = findViewById(R.id.div1);
        TextView div2 = findViewById(R.id.div2);
        TextView div3 = findViewById(R.id.div3);

        String division_explication =
                "La division est une opération qui divise un nombre en plusieurs parties. \n" +
                "Le nombre que l’on divise est appelé « dividende ». Le nombre par lequel on divise est le diviseur.\n" +
                "Le résultat d'une division est un quotient et un reste." +
                "Le reste est nul si le quotient des deux nombres de la division est exact, sinon ce quotient est approximatif.\n";

        String text1=
                " Je commence par diviser ce qu’il y a de plus grand, c’est-à-dire ici, les centaines.\n" +
                "4 centaines divisées par 3 «Dans 4, combien de fois je peux mettre 3 ?» ou «Dans la table de 3, qu’est-ce qui se rapproche de 4 ?» ou «Dans la table de 3, qu’est-ce qui se rapproche de 4?» Il y va 1 fois. Je note donc 1 au quotient.\n" +
                "Je multiplie le quotient par le diviseur : 1 x 3 = 3. je note 3 sous les centaines.\n" +
                "Et je soustrais : 4 centaines moins 3 centaines, il me reste 1 centaine.";

        String text2=
                "J’abaisse les dizaines, c’est-à-dire 7 : J’ai donc 17 dizaines que je divise par 3.\n" +
                "« Dans 17, combien de fois je peux mettre 3 ?» ou « Dans la table de 3, qu’est-ce qui se rapproche de 17 ?» Il y va 5 fois. Je note 5 au quotient.\n" +
                "Je multiplie 5 par 3 = 15. Et je note 15 sous les dizaines.\n" +
                "17dizaines moins 15dizaines, il me reste 2 dizaines.";
        String text3 =
                "J’abaisse les unités, c’est-à-dire 6 : j’ai donc 26 unités que je divise par 3.\n" +
                "«Dans 26, combien de fois je peux mettre 3 ?» ou «Dans la table de 3, qu’est-ce qui se rapproche de 26 ?» Il y va 8 fois. Je note 8 au quotient.\n" +
                "Je multiplie 8 par 3= 24. Et je note 24 sous les unités.\n" +
                "26 unités moins 24 unités, il me reste 2.";

        SpannableString div = new SpannableString(division_explication);

        StyleSpan bold = new StyleSpan(Typeface.BOLD);
        StyleSpan bold1 = new StyleSpan(Typeface.BOLD);
        StyleSpan bold2 = new StyleSpan(Typeface.BOLD);
        StyleSpan bold3 = new StyleSpan(Typeface.BOLD);
        StyleSpan bold4 = new StyleSpan(Typeface.BOLD);
        ForegroundColorSpan red = new ForegroundColorSpan(Color.RED);
        ForegroundColorSpan red1 = new ForegroundColorSpan(Color.rgb(255,0,0));
        ForegroundColorSpan red2 = new ForegroundColorSpan(Color.rgb(254,0,0));
        ForegroundColorSpan red3 = new ForegroundColorSpan(Color.rgb(254,0,0));
        ForegroundColorSpan red4 = new ForegroundColorSpan(Color.rgb(254,0,0));
        div.setSpan(red,3,11, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        div.setSpan(bold,3,11, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        div.setSpan(red1,112,122, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        div.setSpan(bold1,112,122, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        div.setSpan(red2,164,172, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        div.setSpan(bold2,164,172, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        div.setSpan(red3,208,217, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        div.setSpan(bold3,208,217, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        div.setSpan(red4,224,228, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        div.setSpan(bold4,224,228, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        division.setText(div);
        div1.setText(text1);
        div2.setText(text2);
        div3.setText(text3);
    }
}