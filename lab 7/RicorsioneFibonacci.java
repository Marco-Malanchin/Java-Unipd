import java.util.Scanner;
import java.util.InputMismatchException;
public class RicorsioneFibonacci{
    public static void main(String[]args){
        Scanner scan =  new Scanner(System.in);
        boolean check = false;
        int n = 0;
        while(!check){
            check = false;
            try{
                System.out.println("Inserisci parametro n da calcolare con la sequenza di fibonacci");
                n = scan.nextInt();
                if( n >=  0){
                    check = true;
                }
                else{
                     System.out.println("Parametro inserito errato");
                }
            }
            catch(InputMismatchException e){
                System.out.println("Parametro inserito errato");
                scan.nextLine();
            }
        }
        long start1 = System.currentTimeMillis();
        long fibonacci1 = (long) recursiveFib(n);
        long end1 = System.currentTimeMillis();
        long time1 = end1 - start1;
        long start2 = System.currentTimeMillis();
        long fibonacci2 = (long) iterativeFib(n);
        long end2 = System.currentTimeMillis();
        long time2 = end2 - start2;
        System.out.println("Il valore della sequenza di fibonacci in posizione " + n + " calcolato con il metodo ricorsivo  e': ");
        System.out.println(fibonacci1);
        System.out.println("Il metodo ricorsivo ha impiegato " + time1 + " millisecondi");
        System.out.println("Il valore della sequenza di fibonacci in posizione " + n + " calcolato con il metodo iterativo e': ");
        System.out.println(fibonacci2);
        System.out.println("Il metodo iterativo ha impiegato " + time2 + " millisecondi");
         scan.close();
    }
    public static long  recursiveFib(int n){
        long[] pippo = new long[n + 1];
        if(n == 0){
            return 0;
        }
        else if (n == 1){
            return 1;
        }
        pippo[n] = recursiveFib(n-2) + recursiveFib(n-1);
        return pippo[n];
    }
    public static long iterativeFib(int n){
        if(n == 0){
            return 0;
        }
        else if(n == 1){
            return 1;
        }
        else{
            int fibonacci = 0;
            int n2 = 0;
            int n1 = 1;
            for(int i = 2; i <= n; i++){
                fibonacci = n2 + n1;
                n2 = n1;
                n1 = fibonacci;
            }
            return fibonacci;
        }
    }
}