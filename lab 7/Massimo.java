import java.util.Scanner;
import java.util.InputMismatchException;  
public class Massimo{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        boolean controllo = false;
        boolean controllo2 = false;
        int contatore = 0;
        while(!controllo){
            try{
                System.out.println("Tra quanti numeri vuoi calcolare il massimo?");
                 contatore = scan.nextInt();
                if(contatore > 0 ){
                    controllo = true;
                }
                else{
                    System.out.println("Inserisci un valore valido");
                }
            }
            catch(InputMismatchException e){
                System.out.println("Inserisci un valore valido");
                scan.nextLine();
            }
        }
        int[] numeri = new int[contatore];
        for(int i = 0; i < contatore;){
            controllo2 = false;
             while(!controllo2){
            try{
                System.out.println("Inserisci il " + (i +1 ) + " numero");
                 numeri[i] = scan.nextInt();
                controllo2 = true;
                i++;
            }
            catch(InputMismatchException e){
                System.out.println("Inserisci un valore valido");
                scan.nextLine();
            }
        }
        }
        int massimo = trovaMassimo(numeri);
         System.out.println("Il valore massimo e': ");
        System.out.println(massimo);
        scan.close();
    }
    public static int trovaMassimo(int[] pippo){
        int l = (pippo.length - 1);
        int massimo = pippo[l];
        int[] pippo2 = new int[l];
        for(int i = 0; i < l ; i++){
            pippo2[i] = pippo[i];
        }
        if(pippo.length == 1){
            return pippo[0];
        }
        massimo = max(trovaMassimo(pippo2),  massimo);
        return massimo;
    }

    public static int max(int x,  int y){
        if(x > y){
            return x;
        }
        else if(x < y){
            return y;
        }
        else if(x == y){
            return x;
        }
        return 0;
    }
}