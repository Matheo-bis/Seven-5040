package fr.seven.mathgame;

import java.util.Random;

public class Expert extends Equation{

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
        switch (rand.nextInt(6)) {
            case 0:
                operateur = "+";
                int Sumx = rand.nextInt(501)+500;
                int Sumy = rand.nextInt(501)+500;
                String StringSumx = String.valueOf(Sumx);
                String StringSumy = String.valueOf(Sumy);
                int SumResultat = Sumx + Sumy;
                toutresultat = StringSumx+operateur+StringSumy +"="+ SumResultat;
                return StringSumx + operateur + StringSumy + "=" + new String(new char[String.valueOf(SumResultat).length()]).replace('\u0000', '_');

            case 1:
                operateur = "-";
                int Minx = rand.nextInt(501)+500;
                int Miny = rand.nextInt(501)+500;
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
                int Multx = rand.nextInt(31)+10;
                int Multy = rand.nextInt(31)+10;
                String StringMultx = String.valueOf(Multx);
                String StringMulty = String.valueOf(Multy);
                int MultResultat = Multx * Multy;
                toutresultat = StringMultx+operateur+StringMulty+"="+MultResultat;
                return StringMultx + operateur + StringMulty + "=" + new String(new char[String.valueOf(MultResultat).length()]).replace('\u0000', '_');

            case 3:
                operateur ="÷";
                int Divy=rand.nextInt(501)+50;
                int DivResultat=rand.nextInt(20);
                int Divx=Divy*DivResultat;
                String StringDivx=String.valueOf(Divx);
                String StringDivy=String.valueOf(Divy);
                toutresultat = StringDivx+operateur+StringDivy+"="+DivResultat;
                return StringDivx + operateur + StringDivy + "=" + new String(new char[String.valueOf(DivResultat).length()]).replace('\u0000', '_');

            case 4:
                operateur1 = "+";
                operateur2= "-";
                int Summinx = rand.nextInt(501)+500;
                int Summiny = rand.nextInt(501)+500;
                int Summinz = rand.nextInt(901)+100;
                String StringSumminx = String.valueOf(Summinx);
                String StringSumminy = String.valueOf(Summiny);
                String StringSumminz = String.valueOf(Summinz);
                int SumminResultat = Summinx + Summiny - Summinz;
                toutresultat = StringSumminx+operateur1+StringSumminy +operateur2+StringSumminz+"="+ SumminResultat;
                return StringSumminx + operateur1 + StringSumminy + operateur2+StringSumminz+"=" + new String(new char[String.valueOf(SumminResultat).length()]).replace('\u0000', '_');

            case 5:
                operateur1 = "+";
                operateur2= "*";
                int Summultx = rand.nextInt(501)+500;
                int Summulty = rand.nextInt(501)+500;
                int Summultz = rand.nextInt(901)+100;
                String StringSummultx = String.valueOf(Summultx);
                String StringSummulty = String.valueOf(Summulty);
                String StringSummultz = String.valueOf(Summultz);
                int SummultResultat = Summultx + Summulty - Summultz;
                toutresultat = StringSummultx+operateur1+StringSummulty +operateur2+StringSummultz+"="+ SummultResultat;
                return StringSummultx + operateur1 + StringSummulty + operateur2+StringSummultz+"=" + new String(new char[String.valueOf(SummultResultat).length()]).replace('\u0000', '_');
            default:
                return "Attention";
        }
    }
}
