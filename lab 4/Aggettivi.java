import java.util.Scanner;

public class Aggettivi{
    public static void main(String[] arg){
        Scanner scan = new Scanner(System.in);
        System.out.println("Inserisci aggettivo da modificare");
        String aggettivo = scan.nextLine();
        aggettivo = aggettivo.toLowerCase();
        String sub1 = aggettivo.substring(0,1);
        sub1 = sub1.toUpperCase();
        String sub2 = aggettivo.substring(1);
        aggettivo = sub1 + sub2;
        int lunghezza = aggettivo.length();
        char carattereFinale = aggettivo.charAt(lunghezza - 1);
        if(carattereFinale  == 'o'){
            System.out.println(aggettivo);
            String subFinale = aggettivo.substring(lunghezza -1, lunghezza);
            String subIniziale = aggettivo.substring(0, lunghezza - 1);
            String diminutiva = subIniziale + "ino";
            String superlativo = subIniziale + "issimo";
            System.out.println(diminutiva);
            System.out.println(superlativo);
            System.exit(0);
        }
        else if(carattereFinale  == 'a'){
            System.out.println(aggettivo);
            String subFinale = aggettivo.substring(lunghezza -1, lunghezza);
            String subIniziale = aggettivo.substring(0, lunghezza - 1);
            String diminutiva = subIniziale + "ina";
            String superlativo = subIniziale + "issima";
            System.out.println(diminutiva);
            System.out.println(superlativo);
            System.exit(0);
        }
        else{
            System.out.println("Inserisci un aggettivo singolare");
            System.exit(0);
        }
    }
}