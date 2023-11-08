import java.util.Scanner;

public class deviazioneStandard{
    public static void main(String[] arg){
        Scanner scan = new Scanner(System.in);
        String valore;
        double numero;
        double somma = 0;
        double numeroQuadrato;
        double sommaQuadrati = 0;
        double contatore = 0;
         System.out.println("Inserisci quanti valori in virgola mobile vuoi, ad ogni numero premi invio, quando non vuoi piu inserire numeri inserisci il carattere T");
        while(true){
            valore = scan.nextLine();
            if(valore.equalsIgnoreCase("T")){
                break;
            }
            else{
                numero = Double.valueOf(valore);
                somma = somma + numero;
                numeroQuadrato = Math.pow(numero, 2);
                sommaQuadrati = sommaQuadrati + numeroQuadrato;
                contatore++;
            }
        }
        double media = 0;
        double deviazione = 0;
        if(contatore == 0){
            System.out.println("La media e' 0 e la deviazione standard e' 0");
            System.exit(0);
        }
        else if(contatore == 1){
            media = somma;
            System.out.println("La media e' " + media + "  e la deviazione standard e' 0");
            System.exit(0);
        }
        else{
            media = somma/contatore;
            deviazione = Math.sqrt((sommaQuadrati - somma*somma/contatore)/(contatore-1));
            System.out.println("La media e' " + media + "  e la deviazione standard e' "+ deviazione);
            System.exit(0);
        }
    }
}