import java.util.Scanner;

public class MCD{
    public static void main(String[] arg){
        Scanner scan = new Scanner(System.in);
        int m;
        int n;
        do{
            System.out.println("Inserisci il primo numero intero");
            m = scan.nextInt();
        }
        while(m <= 0);
         int temp1 = m;
        do{
        System.out.println("Inserisci il secondo numero intero");
        n = scan.nextInt();
        }
         while(n <= 0);
        int temp2 = n;
        int mcd;
        if(m > n){
            do{
                int temp = m;
                m = n;
                n = (temp % n);
            }
            while((m%n) != 0);
            mcd = n;
            System.out.println("Il MCD tra " + temp1 + " e "+ temp2 + " e' " + mcd);
            System.exit(0);
        }
         else if(n > m){
            do{
                int temp = n;
                n = m;
                m = (temp % m);
            }
            while((n%m) != 0);
            mcd = m;
            System.out.println("Il MCD tra " + temp2 + " e "+ temp1 + " e' " + mcd);
            System.exit(0);
        }
        else{
            System.out.println("Il MCD tra " + n + " e "+ m + " e' " + m);
            System.exit(0);
        }
    }
}