/*
   Fondamenti di Informatica - Canale C

   Completare il file in base ai commenti presenti;
   si puo' scrivere codice SOLTANTO dove sono presenti i puntini ...
   
*/

import java.util.EmptyStackException;
import java.util.Scanner;
// NON SI POSSONO IMPORTARE NE' USARE ALTRE CLASSI DI java.util
// MA SI POSSONO IMPORTARE E USARE ECCEZIONI

interface StringStack { // NON SI PUO' MODIFICARE
   int size();
   boolean isEmpty();

   /* Lancia IllegalArgumentException se e solo se s e' null;
      il metodo deve avere prestazioni O(1) in media.
   */
   void push(String s);

   /* Lancia EmptyStackException se e solo se la pila è vuota.
   */
   String top();

   /* Lancia EmptyStackException se e solo se la pila è vuota.
   */
   String pop();

   /* Restituisce un array di dimensione size() contenente tutte
      e sole le stringhe presenti nella pila, in modo che nella
      posizione 0 ci sia la stringa che si trova in cima alla pila
      e via cosi' ordinatamente, in indici successivi ci devono
      essere le stringhe sempre piu' lontane dalla cima della pila;
      il metodo NON deve modificare il contenuto della pila.
   */
   String[] toArray();

   /* Restituisce un array di dimensione size() contenente tutte
      e sole le stringhe presenti nella pila, 
      in modo che nella posizione 0 ci sia la stringa che precede tutte
      le altre nell'ordinamento lessicografico e cosi' via
      (cioe' l'array restituito deve essere lessicograficamente
       ordinato in senso crescente);
      le prestazioni dell'algoritmo di ordinamento non verranno
      valutate, basta che funzioni (quindi fatelo SEMPLICE...)
      il metodo NON deve modificare il contenuto della pila.
   */
   String[] toSortedArray();
}
class MyStringStack implements StringStack {
	private String[] v;
    private int vSize;
    public MyStringStack(){
        v = new String[100];
       vSize = 0;
    }
    public boolean isEmpty(){
        return (vSize == 0);
    }
    public int size(){
        return vSize;
    }
    public void push(String s){
        if(s == null){
            throw new IllegalArgumentException();
        }
        if(vSize == v.length){
            String[] temp = new String[2 * v.length];
            System.arraycopy(v, 0, temp , 0, vSize);
            v = temp;
        }
        v[vSize++] = s;
    }
    public String top(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        String s = v[vSize - 1];
        return s;
    }
    public String pop(){
        String s = top();
        vSize--;
        return s;
    }
    public String[] toArray(){
        String[] temp = new String[size()];
        String[] temp2 = new String[size()];
        System.arraycopy(v, 0, temp2, 0, vSize);
        int j = size() - 1;
        for(int i = 0;  i < vSize; i++){
            temp[i] = temp2[j];
            j--;
        }
        return temp;
    }
    public String[] toSortedArray(){
        String[] temp = new String[size()];
        System.arraycopy(v, 0, temp, 0, vSize);
        for(int i = 0; i < temp.length - 1 ; i++){
            int pos = i;
            for(int j = pos + 1; j < temp.length; j++){
                if(temp[j].compareTo(temp[pos]) < 0){
                    pos = j;
                }
            }
            if(pos != i){
                String temp2 = temp[i];
                temp[i] = temp[pos];
                temp[pos]  = temp2; 
            }
        }
        return temp;
    }
}

public class MalanchinMarco1  // <--------- INSERIRE IL NOME OPPORTUNO ********
// usando la regola seguente: CognomeMatricola (es. Bazzanella123456)
// dove cognome e matricola sono, evidentemente, il cognome e la
// matricola dello studente; se il cognome contiene spazi o apostrofo,
// questi vanno ignorati; se contiene lettere accentate, usare la
// corrispondente lettera non accentata
//
{  public static void main(String[] args)
   {  test(); // fa' un po' di collaudi... se da' errore, c'e' un errore!
      StringStack stack = new MyStringStack();
      /*
         aggiungere qui sotto una porzione di codice che legge
         numeri interi dal flusso di ingresso standard, finche'
         questo non viene chiuso dall'utente, inserendoli nella
         pila gia' creata qui sopra, che in questo momento e' vuota;
         se viene introdotto un valore che NON sia un numero intero,
         esso deve essere IGNORATO e il programma deve procedere
         senza visualizzare alcun messaggio d'errore;
         l'utente deve introdurre un solo numero intero per riga ed 
         eventuali ulteriori numeri validi introdotti su una riga,
         dopo il primo, devono essere ignorati (senza messaggi d'errore);
         il programma non deve MAI terminare con il lancio di una
         eccezione che non sia stata catturata e gestita;
         in pratica, questa porzione di codice non deve MAI visualizzare nulla.
         Esempio di input:
           1
           3
           4 gg
           ff 6
           2 2 2
           5
         Con questo input programma deve inserire nella pila i numeri: 1, 3, 4, 6, 2, 5
         (sotto forma di stringhe)
      */
      Scanner console = new Scanner(System.in);
     System.out.println("Inserisci tutti ii numeri interi che vuoi, quando vuoi terminare premi CTRL + Z");
     while(console.hasNextLine()){
        String linea = console.nextLine();
        Scanner scan = new Scanner(linea);
        while(scan.hasNext()){
            int valore = 0;
            try{
                String nuovoValore = scan.next();
                valore = Integer.valueOf(nuovoValore);
                stack.push(nuovoValore);
                break;
            }
            catch(NumberFormatException e){

            }
        }
     }
      // NON MODIFICARE QUI SOTTO
      String[] array = stack.toArray();
      for (int i = 0; i < array.length; i++)
         System.out.print(array[i] + " ");
	  System.out.println();
      array = stack.toSortedArray();
      for (int i = 0; i < array.length; i++)
         System.out.print(array[i] + " ");
	  System.out.println();
   }
   // NON E' NECESSARIO ANALIZZARE IL METODO SEGUENTE,
   // CHE NON PUO' ESSERE MODIFICATO
   private static void test()
   {  String message = "Collaudo NON riuscito";
      StringStack stack = new MyStringStack();
      for (int i = 0; i < 10; i++)
         stack.push(Integer.toString(i));
      if (stack.size() != 10)
         System.out.println(message);
      for (int i = 0; i < 8; i++)
         stack.pop();
      if (stack.size() != 2)
         System.out.println(message);
      stack.push(Integer.toString(2));
      if (stack.size() != 3)
         System.out.println(message);
      String[] x = stack.toArray();
      if (!x[0].equals("2") || !x[1].equals("1") || !x[2].equals("0"))
         System.out.println(message);
      x = stack.toSortedArray();
      if (!x[0].equals("0") || !x[1].equals("1") || !x[2].equals("2"))
         System.out.println(message);
      while (!stack.isEmpty())
         stack.pop();
      try {
         stack.pop();
         System.out.println(message);
      } catch (EmptyStackException e)
      { }   
   }
}
