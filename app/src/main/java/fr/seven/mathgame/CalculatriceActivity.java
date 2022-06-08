package fr.seven.mathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculatriceActivity extends AppCompatActivity {

    private Button[] buttons = new Button[20];
    private TextView resultat;
    private TextView calcul;
    public char [] sign = {'+','-','x','/'};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculatrice);
        setCalcul();
    }

    public void setCalcul(){
        buttons[0]=(Button)findViewById(R.id.button0);
        buttons[1]=(Button)findViewById(R.id.button1);
        buttons[2]=(Button)findViewById(R.id.button2);
        buttons[3]=(Button)findViewById(R.id.button3);
        buttons[4]=(Button)findViewById(R.id.button4);
        buttons[5]=(Button)findViewById(R.id.button5);
        buttons[6]=(Button)findViewById(R.id.button6);
        buttons[7]=(Button)findViewById(R.id.button7);
        buttons[8]=(Button)findViewById(R.id.button8);
        buttons[9]=(Button)findViewById(R.id.button9);
        calcul = (TextView) findViewById(R.id.calcul);
        resultat = (TextView) findViewById(R.id.result);
    }
    public void OnClickZero(View v) {
        calcul.setText(calcul.getText().toString() + '0');
    }
    public void OnClickOne(View v) {
        calcul.setText(calcul.getText().toString() + '1');
    }
    public void OnClickTwo(View v) {
        calcul.setText(calcul.getText().toString() + '2');
    }
    public void OnClickThree(View v) {
        calcul.setText(calcul.getText().toString() + '3');
    }
    public void OnClickFour(View v) {
        calcul.setText(calcul.getText().toString() + '4');
    }
    public void OnClickFive(View v) {
        calcul.setText(calcul.getText().toString() + '5');
    }
    public void OnClickSix(View v) {
        calcul.setText(calcul.getText().toString() + '6');
    }
    public void OnClickSeven(View v) {
        calcul.setText(calcul.getText().toString() + '7');
    }
    public void OnClickEight(View v) {
        calcul.setText(calcul.getText().toString() + '8');
    }
    public void OnClickNine(View v) {
        calcul.setText(calcul.getText().toString() + '9');
    }
}