import java.util.Scanner;

public class numeriPrimi{
    public static void  main(String[] arg){
        Scanner scan = new Scanner(System.in);
        int x;
        boolean continua = true;
        while(continua == true){
            System.out.println("Inserisci un numero primo, per stoppare il programma inserisci un numero NON primo");
            x = scan.nextInt();
             System.out.println("\n");
            if(((x%1) == 0) && ((x%x) == 0)&& ((x%3) == 0) || ((x%1) == 0) && ((x%x) == 0) && ((x%2) == 0)  || ((x%1) == 0) && ((x%x) == 0) && ((x%5) == 0)  || ((x%1) == 0) && ((x%x) == 0) && ((x%7) == 0)){
                if(x== 1 || x == 2 || x == 3  || x == 5   || x == 7){
                    for(int i = 1; i <= x;){
                    if(((i%1) == 0) && ((i%i) == 0)&& ((i%3) == 0) || ((i%1) == 0) && ((i%i) == 0) && ((i%2) == 0)  || ((i%1) == 0) && ((i%i) == 0) && ((i%5) == 0) || ((i%1) == 0) && ((i%i) == 0) && ((i%7) == 0)){
                       if(i == 1 || i == 2 || i == 3  || i == 5   || i == 7){
                        System.out.println(i);
                       }
                        i++;
                    }
                    else{
                        System.out.println(i);
                        i++;
                    }
                }
                continua = true;
                }
                else{
                    System.out.println("Numero non primo inserito, arresto del programma");
                     continua = false;
                    System.exit(0);
                }
            }
            else{
                for(int i = 1; i <= x;){
                    if(((i%1) == 0) && ((i%i) == 0)&& ((i%3) == 0) || ((i%1) == 0) && ((i%i) == 0) && ((i%2) == 0)  || ((i%1) == 0) && ((i%i) == 0) && ((i%5) == 0) || ((i%1) == 0) && ((i%i) == 0) && ((i%7) == 0)){
                       if(i == 1 || i == 2 || i == 3  || i == 5   || i == 7){
                        System.out.println(i);
                       }
                        i++;
                    }
                    else{
                        System.out.println(i);
                        i++;
                    }
                }
            }
        }
    }
}