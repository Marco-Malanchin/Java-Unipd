import java.util.Scanner;

public class numeriDispari{
    public static void main(String[] arg){
        Scanner num = new Scanner(System.in);
        int n  = 0;
        do{
             System.out.println("inserisci il primo numero n, il numero deve essere maggiore di 0 ed un numero intero");
            n = num.nextInt();
        }
        while(n <= 0);
           int m  = 0;
        do{
             System.out.println("inserisci il secondo numero m, il numero deve essere maggiore di 0 ed un numero intero");
            m = num.nextInt();
        }
        while(m <= 0);
        if(n > m){
            System.out.println("Errore, il secondo numero deve essere maggiore del primo");
            System.exit(1);
        }
        if(n == m){
             System.out.println("Errore, il secondo numero deve essere diverso e maggiore del primo");
            System.exit(1);
        }
        if((n % 2) == 0){
            System.out.println("Numero n:" + n + "\n" +"numero m:" + m);
              System.out.println("Numeri dispari tra n e m:");
              int j = 1;
                while(n < m ){
                    n  = n + 1;
                    System.out.println(j + "  numero : "+ n  );
                    n = n + 1;
                    j++;
                }
                System.exit(0);
            }
            else{
                  System.out.println("Numero n:" + n + "\n" +"numero m:" + m);
                  System.out.println("Numeri dispari tra n e m:");
                int j = 1;
                 while(n < m - 1 ){
                      n = n + 2;
                    System.out.println(j + " numero : "+ n  );
                    j++;
                }
                    System.exit(0);
            }
        }
    }