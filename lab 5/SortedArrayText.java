import java.util.*;
import java.util.Scanner;
import java.util.Random;

public class SortedArrayText{
    public static void main(String[] args){
        Scanner in= new Scanner(System.in);
        int intervallo = args[1];
		Random generatore = new Random();
        SortedArray pippo = new SortedArray();
		for (int i=0; i<a.length; i++) {
			pippo[i] = generatore.nextInt(intervallo) + 1;
        }
        double media = pippo.avg();
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[2]));
        writer.write(media);
        int max = pippo.removeMax();
        writer.write(max);
        
    }
}
class SortedArray
{
    private int [] v;
    private int vSize;
    /*  Crea un oggetto SortedArray vuoto     */
    public SortedArray()
    {
        v = new int[10];
        vSize = 0;
    }
    /*  Verifica se l'array e` vuoto. Prestazioni O(1)    */
    public boolean isEmpty()
    { 
        return vSize == 0; //restituisce true o false a seconda se vSize sia 0 o no.
    }
        /*  Aggiunge il valore value all'array ordinato, conservando l'ordinamento.
        Prestazioni O(n) (prima dell'inserimento l'array e' ordinato!)
    */
   public int[] resize(int[] v, int l){
        int[] newV = new int [l];
        for(int i = 0; i < v.length; i++){
            newV[i] = v[i];
        }
        return v;
   }
    public void add(int value)
    { 
        if(vSize == v.length){
            v = resize (v, 2*vSize); //Scrivi il metodo di  resize
        }

        int j;
        for(j  = (vSize - 1);  j >= 0 && v[j]> value; j-- ){
            v[j + 1] = v[j];
            v[j + 1] = value;
            vSize++;
        }
    }
    /* Cancella il valore massimo dall'array, e lo restituisce.
        Prestazioni O(1). Lancia NoSuchElementException se l'array e' vuoto
    */
    public int removeMax() throws NoSuchElementException
    { 
        if(isEmpty() == true){
            throw new  NoSuchElementException();
        }
         vSize--;
        return v[vSize];
    }
      /*  Restituisce la media (average) dei valori dell'array
        Prestazioni O(n)
    */
    public double avg()
    { 
        double somma  = 0;
        double media = 0;
        for(int i = 0; i < vSize; i++){
            somma = somma + v[i];
        }
        media = somma / vSize;
        return media;
    }
}