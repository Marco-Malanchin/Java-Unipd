import java.util.Scanner;

public class sommaNumeri{
    public static void main(String[] arg){
        Scanner num = new Scanner(System.in);
        int c = 0;
        do{
            System.out.println("Di quanti numeri vuoi fare la somma?");
            c = num.nextInt();
        }
        while(c <= 0);
        double somma = 0;
        int j = 1;
        int numero = 0;
        for(int i = 0; i < c; i++){
            do{
                System.out.println("Inserisci " + j + " numero" );
                 numero = num.nextInt();
            }
             while(numero <= 0);
             somma = somma + numero;
             j++;
        }
        double media = somma / c;
        System.out.println("Somma: " + somma + "\n" + "media: " + media);
        System.exit(0);
    }
}