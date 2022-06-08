package fr.seven.mathgame;

import java.util.Random;

public class Debutant extends Equation{

 static String equation(){
     Random rand = new Random();
     int choixoperateur = rand.nextInt(3);
     String operateur;
     switch (choixoperateur) {
         case 0:
             operateur = "+";
             int Sumx = rand.nextInt(21);
             int Sumy = rand.nextInt(21);
             String StringSumx=String.valueOf(Sumx);
             String StringSumy=String.valueOf(Sumy);
             int SumResultat = Sumx+Sumy;
             String SumEquation=StringSumx +operateur + StringSumy + "=__";
             return SumEquation;

         case 1:
             operateur = "-";
             int Minx = rand.nextInt(21);
             int Miny = rand.nextInt(21);
             if (Miny>=Minx){
                 int replace = Miny;
                 Miny = Minx;
                 Minx = replace;
             }
             String StringMinx=String.valueOf(Minx);
             String StringMiny=String.valueOf(Miny);
             int MinResultat = Minx+Miny;
             String MinEquation=StringMinx +operateur + StringMiny + "=__";
             return MinEquation;

         case 2:
             operateur = "x";
             int Multx = rand.nextInt(6);
             int Multy = rand.nextInt(6);
             String StringMultx=String.valueOf(Multx);
             String StringMulty=String.valueOf(Multy);
             int MultResultat = Multx+Multy;
             String MultEquation=StringMultx +operateur + StringMulty + "=__";
             return MultEquation;
         default:
             operateur = "+";
             return "x+y=_";
     }
 }

}
