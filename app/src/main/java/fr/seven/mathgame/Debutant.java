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
             resultat(SumResultat);
             return StringSumx +operateur + StringSumy +"="+new String(new char[String.valueOf(SumResultat).length()]).replace('\u0000', '_');

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
             int MinResultat = Minx-Miny;
             resultat(MinResultat);
             return StringMinx +operateur + StringMiny+"="+ new String(new char[String.valueOf(MinResultat).length()]).replace('\u0000', '_');

         case 2:
             operateur = "x";
             int Multx = rand.nextInt(6);
             int Multy = rand.nextInt(6);
             String StringMultx=String.valueOf(Multx);
             String StringMulty=String.valueOf(Multy);
             int MultResultat = Multx*Multy;
             resultat(MultResultat);
             return StringMultx +operateur + StringMulty + "="+ new String(new char[String.valueOf(MultResultat).length()]).replace('\u0000', '_');

         default:
             operateur = "+";
             return "x+y=_";
     }
 }
static String resultat(int Resultat){
        return String.valueOf(Resultat);
}
}
