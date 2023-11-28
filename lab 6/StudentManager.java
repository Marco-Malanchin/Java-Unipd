import java.util.Scanner;

public class StudentManager{
    public static void main(String[] args){
         Scanner scan = new Scanner(System.in);
         if(args[0] != "studenti.txt"){
            System.out.println("file sbagliato");
            System.exit(1);
         }
          System.out.println("Inserisci l'elenco di studenti ricordando di Inserire cognome, voto(scritto), voto(orale) e separarli con il tasto per andare a capo riga");
          //Fai controlli
         scan.close();
    }
}