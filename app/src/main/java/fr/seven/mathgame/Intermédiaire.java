package fr.seven.mathgame;

import java.util.Random;

public class Intermédiaire extends Equation{

    static String equation() {
        Random rand = new Random();
        switch (rand.nextInt(3)) {
            case 0:
                return jeuatrouchiffre();
            case 1:
                return jeuatrouchiffre();
            //jeuatrouoperateur();
            case 2:
                return jeuatrouchiffre();
            default:
                return "Attention";
        }
    }

    private static String jeuatrouoperateur(){
        Random rand = new Random();
        switch (rand.nextInt(2)){
            case 0:
                return "";
            default:
                return "Atttention";
        }
    }

    static String resultat() {
        return String.valueOf(toutresultat);
    }


    private static String jeuatrouchiffre() {
        Random rand = new Random();
        String operateur;
        String operateur1;
        String operateur2;
        switch (rand.nextInt(5)) {
            case 0:
                operateur = "+";
                int Sumx = rand.nextInt(51)+50;
                int Sumy = rand.nextInt(51)+50;
                String StringSumx = String.valueOf(Sumx);
                String StringSumy = String.valueOf(Sumy);
                int SumResultat = Sumx + Sumy;
                toutresultat = StringSumx+operateur+StringSumy +"="+ SumResultat;
                return StringSumx + operateur + StringSumy + "=" + new String(new char[String.valueOf(SumResultat).length()]).replace('\u0000', '_');

            case 1:
                operateur = "-";
                int Minx = rand.nextInt(151)+50;
                int Miny = rand.nextInt(151)+50;
                if (Miny >= Minx) {
                    int replace = Miny;
                    Miny = Minx;
                    Minx = replace;
                }
                String StringMinx = String.valueOf(Minx);
                String StringMiny = String.valueOf(Miny);
                int MinResultat = Minx - Miny;
                toutresultat = StringMinx+operateur+StringMiny+"="+MinResultat;
                return StringMinx + operateur + StringMiny + "=" + new String(new char[String.valueOf(MinResultat).length()]).replace('\u0000', '_');

            case 2:
                operateur = "*";
                int Multx = rand.nextInt(11)+10;
                int Multy = rand.nextInt(6)+5;
                String StringMultx = String.valueOf(Multx);
                String StringMulty = String.valueOf(Multy);
                int MultResultat = Multx * Multy;
                toutresultat = StringMultx+operateur+StringMulty+"="+MultResultat;
                return StringMultx + operateur + StringMulty + "=" + new String(new char[String.valueOf(MultResultat).length()]).replace('\u0000', '_');

            case 3:
                operateur ="÷";
                int Divy=rand.nextInt(14)+1;
                int DivResultat=rand.nextInt(5);
                int Divx=Divy*DivResultat;
                String StringDivx=String.valueOf(Divx);
                String StringDivy=String.valueOf(Divy);
                toutresultat = StringDivx+operateur+StringDivy+"="+DivResultat;
                return StringDivx + operateur + StringDivy + "=" + new String(new char[String.valueOf(DivResultat).length()]).replace('\u0000', '_');

            case 4:
                operateur1 = "+";
                operateur2= "-";
                int x = rand.nextInt(51)+50;
                int y = rand.nextInt(51)+50;
                int z = rand.nextInt(91)+10;
                String Stringx = String.valueOf(x);
                String Stringy = String.valueOf(y);
                String Stringz = String.valueOf(z);
                int Resultat = x + y - z;
                toutresultat = Stringx+operateur1+Stringy +operateur2+Stringz+"="+ Resultat;
                return Stringx + operateur1 + Stringy + operateur2+Stringz+"=" + new String(new char[String.valueOf(Resultat).length()]).replace('\u0000', '_');

            default:
                return "Attention";
        }
    }
}
