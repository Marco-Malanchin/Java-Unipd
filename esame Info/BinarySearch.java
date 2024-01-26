import java.util.Scanner;

public class BinarySearch{
    public static void main(String[] args){
        int[] a = {1,2,3,4,5,6,7,8,9};
        for (int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }
        Scanner scan = new Scanner(System.in);
        System.out.println("Inserisci un numero da cercare");
        int ricerca = scan.nextInt();
        int posizione = ricercaBinaria(a, ricerca);
        if(posizione != -1){
            System.out.println("numero trovato posizione; " + posizione);
        }
        else{
             System.out.println("Numero non trovato");
        }
    }
    public static int ricercaBinaria(int[] a, int b){
        return binSearch(a,  0,  a.length - 1, b);
    }
    private  static int binSearch(int[] a, int start, int end, int b){
        if(start > end){
            return -1;
        }
        int mid = (start + end ) / 2;
        int middle = a[mid];
        if(middle == b){
            return mid;
        }
        if(middle < b){
            return binSearch( a,  mid + 1, end, b);
        }
        return binSearch( a, start, mid -1, b);
    }
}