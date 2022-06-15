package fr.seven.mathgame;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class CalculatriceActivity extends AppCompatActivity {
    private TextView resultat;
    private TextView deuxio;
    private TextView calcul;
    private double num1;
    private double num2=0;
    boolean ok=false;
    private boolean num1_exist = false;
    private boolean num2_exist = false;
    boolean ispoint=false;
    private float result;
    private String operation;
    private String [] signs = {"+","-","×","÷","!","^","."};
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculatrice);

        resultat = findViewById(R.id.resultat);
        deuxio = findViewById(R.id.terme);
        calcul = findViewById(R.id.calcul);
        //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        //TEMPORAIRE
        //setCalcul();
    }
    public double factorial(double n){
        double result = 1.0;
        for (double factor = 2.0; factor <= n; factor++) {
            result = result * factor;
        }
        return result;

    }

    public boolean isoperator(String word){
        int n =0;
        for (int i =0; i<7;i++){
            if(word.equals(signs[i])){
                n++;
            }
        }
        return n==1;
    }

    public void buttonclick(View view){

        String viewName = view.getResources().getResourceName(view.getId());
        String button = "_";
        String op = operation;
        switch(viewName) {
            case "fr.seven.mathapp:id/button1":
                button = "1";
                if (num1_exist && !num2_exist){
                   // deuxio.setText(deuxio.getText().toString() + button);
                }
                break;
            case "fr.seven.mathapp:id/button2":
                button = "2";
                if (num1_exist && !num2_exist){
                   // deuxio.setText(deuxio.getText().toString() + button);
                }
                break;
            case "fr.seven.mathapp:id/button3":
                button = "3";
                if (num1_exist && !num2_exist){
                   // deuxio.setText(deuxio.getText().toString() + button);
                }
                break;
            case "fr.seven.mathapp:id/button4":
                button = "4";
                if (num1_exist && !num2_exist){
                    //deuxio.setText(deuxio.getText().toString() + button);
                }
                break;
            case "fr.seven.mathapp:id/button5":
                button = "5";
                if (num1_exist && !num2_exist){
                    //deuxio.setText(deuxio.getText().toString() + button);
                }
                break;
            case "fr.seven.mathapp:id/button6":
                button = "6";
                if (num1_exist && !num2_exist){
                   // deuxio.setText(deuxio.getText().toString() + button);
                }
                break;
            case "fr.seven.mathapp:id/button7":
                button = "7";
                if (num1_exist && !num2_exist){
                   // deuxio.setText(deuxio.getText().toString() + button);
                }
                break;
            case "fr.seven.mathapp:id/button8":
                button = "8";
                if (num1_exist && !num2_exist){
                  //  deuxio.setText(deuxio.getText().toString() + button);
                }
                break;
            case "fr.seven.mathapp:id/button9":
                button = "9";
                if (num1_exist && !num2_exist){
                   // deuxio.setText(deuxio.getText().toString() + button);
                }
                break;
            case "fr.seven.mathapp:id/button0":
                button = "0";
                if (num1_exist && !num2_exist){
                    //deuxio.setText(deuxio.getText().toString() + button);
                }
                break;

            case "fr.seven.mathapp:id/buttonadd":
                button = "+";
                operation = button;
                if (!num1_exist){
                    if (calcul.getText().toString().length()!=0) {
                        num1_exist = true;
                        num1 = Double.parseDouble((String) calcul.getText().toString());
                    }
                }
                else {
                    if (calcul.getText().toString().length()>0){
                        int longueur = calcul.getText().length() - 1;
                        String last_number = (String) calcul.getText().toString().substring(longueur);
                        if (isoperator(last_number)){
                            button="";
                        }
                    }
                    if(!num2_exist && op=="!"){
                        deuxio.setText("0");
                        num2 = Double.parseDouble((String)deuxio.getText().toString());
                    }
                    if(ok || deuxio.getText().length()==0){
                        deuxio.setText("0");
                        num2 = Double.parseDouble((String)deuxio.getText().toString());
                    }

                }
                break;
            case "fr.seven.mathapp:id/buttonsub":
                button = "-";
                operation =button;
                if (!num1_exist){
                    if (calcul.getText().toString().length()!=0) {
                        num1_exist = true;
                        num1 = Double.parseDouble((String) calcul.getText().toString());
                    }
                }
                else {
                    if (calcul.getText().toString().length()>0){
                        int longueur = calcul.getText().length() - 1;
                        String last_number = (String) calcul.getText().toString().substring(longueur);
                        if (isoperator(last_number)){
                            button="";                        }
                    }
                    if(!num2_exist && op=="!"){
                        num2 = Double.parseDouble((String)deuxio.getText());
                        deuxio.setText("0");
                    }
                    if(ok || deuxio.getText().length()==0){
                        deuxio.setText("0");
                        num2 = Double.parseDouble((String)deuxio.getText().toString());
                    }
                }
                break;
            case "fr.seven.mathapp:id/buttondiv":
                button = "÷";
                operation =button;
                if (!num1_exist){
                    if (calcul.getText().toString().length()!=0) {
                        num1_exist = true;
                        num1 = Double.parseDouble((String) calcul.getText().toString());
                    }
                }
                else {
                    if (calcul.getText().toString().length()>0){
                        int longueur = calcul.getText().length() - 1;
                        String last_number = (String) calcul.getText().toString().substring(longueur);
                        if (isoperator(last_number)){
                            button="";                        }
                    }
                    if(!num2_exist && op=="!"){
                        deuxio.setText("1");
                        num2 = Double.parseDouble((String)deuxio.getText());
                    }
                    if(ok || deuxio.getText().length()==0){
                        deuxio.setText("0");
                        num2 = Double.parseDouble((String)deuxio.getText().toString());
                    }
                }
                break;
            case "fr.seven.mathapp:id/buttonmult":
                button = "×";
                operation =button;
                if (!num1_exist){
                    if (calcul.getText().toString().length()!=0) {
                        num1_exist = true;
                        num1 = Double.parseDouble((String) calcul.getText().toString());
                    }
                }
                else {
                    if (calcul.getText().toString().length()>0){
                        int longueur = calcul.getText().length() - 1;
                        String last_number = (String) calcul.getText().toString().substring(longueur);
                        if (isoperator(last_number)){
                            button="";                        }
                    }
                    if(!num2_exist && op=="!"){
                        deuxio.setText("1");
                        num2 = Double.parseDouble((String)deuxio.getText());
                    }
                    if(ok || deuxio.getText().length()==0){
                        deuxio.setText("0");
                        num2 = Double.parseDouble((String)deuxio.getText().toString());
                    }
                }
                break;
            case "fr.seven.mathapp:id/buttondot":
                button = ".";
                if (num1_exist && !num2_exist) {
                    // deuxio.setText(deuxio.getText().toString() + button);
                }

                break;
            case "fr.seven.mathapp:id/buttonfac":
                button = "!";
                operation = button;
                if (!num1_exist){
                    if (calcul.getText().toString().length()!=0) {
                        num1_exist=true;
                        num1 =Double.parseDouble((String)calcul.getText());
                        result=(float)factorial((double)num1);
                        resultat.setText(String.valueOf(result));
                        num1=result;
                    }

                    if (num1==5040){
                        Intent intent=new Intent(this, EcranFinActivity.class);
                        intent.putExtra("action","wide");
                        intent.putExtra("numero", 4);
                        startActivity(intent);
                    }
                }
                else{
                    if (calcul.getText().toString().length()>0){
                        int longueur = calcul.getText().length() - 1;
                        String last_number = (String) calcul.getText().toString().substring(longueur);
                        if (isoperator(last_number)){
                            button="";                        }
                        else {
                            if(ok || deuxio.getText().length()==0){
                                deuxio.setText("0");
                                num2 = Double.parseDouble((String)deuxio.getText().toString());
                            }
                            num2 = Double.parseDouble((String) deuxio.getText());
                            num2 = (float) (factorial((double) num2));
                        }
                    }

                }
                break;
            case "fr.seven.mathapp:id/buttonpow":
                button = "^";
                operation =button;
                if (!num1_exist){
                    if (calcul.getText().toString().length()!=0) {
                        num1_exist = true;
                        num1 = Double.parseDouble((String) calcul.getText().toString());
                    }
                }
                else {
                    if (calcul.getText().toString().length()>0){
                        int longueur = calcul.getText().length() - 1;
                        String last_number = (String) calcul.getText().toString().substring(longueur);
                        if (isoperator(last_number)){
                            button="";
                        }
                        else {
                            if(ok || deuxio.getText().length()==0){
                                deuxio.setText("0");
                                num2 = Double.parseDouble((String)deuxio.getText().toString());
                            }
                        }
                    }

                }
                break;
        }
        if (calcul.getText().length()==0){
            if (!button.equals(signs[0]) && !button.equals(signs[1]) &&!button.equals(signs[2])&&!button.equals(signs[3])&&!button.equals(signs[4])&&!button.equals(signs[5])&&!button.equals(".")){
                calcul.setText(calcul.getText().toString()+button);
            }
        }
        else{
            if (calcul.getText().toString().length()>0){
                int longueur = calcul.getText().length() - 1;
                String last_number = (String) calcul.getText().toString().substring(longueur);
                if (isoperator(last_number)&&isoperator(button)){
                    button="";
                }
            }
            if (ispoint){
                if (button.equals(".")) {
                    button="";
                    ispoint=false;
                }
            }
            else{
                ispoint=true;
            }
            calcul.setText(calcul.getText().toString()+button);
        }
        if (num1_exist) {
            if (button != signs[0] && button != signs[1] && button != signs[2] && button != signs[3]&& button != signs[4] &&button != signs[5]&&button!="") {
                deuxio.setText(deuxio.getText().toString() + button);
                num2 = Double.parseDouble(deuxio.getText().toString());
            }
            else if ( (button != signs[0] || button != signs[1] || button != signs[2] || button != signs[3] || button != signs[4] || button != signs[5] ) && (deuxio.getText().toString()!="" &&deuxio.getText().toString()!="0" )){
                num2_exist=true;
            }

        }
        if(num1_exist && num2_exist){
            switch (op){
                case "+":
                    result= (float) (num1+num2);
                    break;
                case "-":
                    result= (float) (num1-num2);
                    break;
                case "×":
                    result=(float) (num1*num2);
                    break;
                case "÷":
                    result= (float) (num1/num2);
                    break;
                case "^":
                    result = (float)Math.pow((double)num1, (double) num2);
                    break;
            }
            num1= result;
            resultat.setText(String.valueOf(result));
            num2_exist=false;
            deuxio.setText("");
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public void buttonOK(View view){
        if (!num2_exist){
            num2_exist=true;
        }

        if(!num1_exist){
            num1=0;
            num1_exist=true;
            operation="k";
        }

        if(num1_exist && num2_exist) {
            switch (operation) {
                case "+":
                    result = (float) (num1 + num2);
                    break;
                case "-":
                    result = (float) (num1 - num2);
                    break;
                case "×":
                    result = (float) (num1 * num2);
                    break;
                case "÷":
                    result = (float) (num1 / num2);
                    break;
                case "!":
                    result = (float) factorial((int) num1);
                    break;
                case "^":
                    result = (float) Math.pow((double) num1, (double) num2);
                    break;
                case "k":
                    result=0;
            }
            if (operation.equals("k")){
                calcul.setText("");
            }
            else {
                num1 = result;
                num2_exist = false;
                num1_exist = true;
                ok = true;
                resultat.setText(String.valueOf(result));
                deuxio.setText("");
            }
        }

    }
    public void buttonDEL(View view) {
        if (calcul.length() > 0) {
            calcul.setText(calcul.getText().toString().substring(0, calcul.length() - 1));
            if (deuxio.length() > 0) {
                deuxio.setText(deuxio.getText().toString().substring(0, deuxio.length() - 1));
            }
        }
    }

    public void buttonCE(View view){
        calcul.setText("");
        resultat.setText("");
        num1 = 0;
        num1_exist=false;
        num2_exist=false;
        num2 = 0;
        deuxio.setText("");
        ispoint=false;
    }


}