import java.util.Scanner;
public class LinearySearch{
    public static void main(String[] args){
        int[] a = {3,5,7,1,2,9,4,10,0,6};
        for (int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }
        Scanner scan = new Scanner(System.in);
        System.out.println("Inserisci un numero da cercare");
        int ricerca = scan.nextInt();
        int posizione = ricercaBinaria(ricerca, a);
        if(posizione != -1){
            System.out.println("numero trovato posizione; " + posizione);
        }
        else{
             System.out.println("Numero non trovato");
        }
    }
    public static int ricercaBinaria(int b, int[] a){
        for(int i = 0; i <  a.length; i++){
            if(a[i] == b){
                return i;
            }
        }
        return -1;
    }
}