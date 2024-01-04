// nome e cognome del candidato, matricola, data,       numero postazione
// ..............                ......     ../../....  ADT..


// --------------- classe FavoriteListTester: da completare ------------------
import java.util.*;
import java.io.*;
public class FavoriteListTester
{
    public static void main(String[] args)
    {   
        // ....... da completare ............
        if(args.length < 1){
            System.out.println("Errore programma avviato in modo errato");
        }
        String filename = args[0];
        Scanner scan = null;
        try{scan  = new Scanner(new FileReader(filename));}
        catch(FileNotFoundException e){
            System.out.println("File not Found");
        }
        ListaDownload download = new ListaDownload();
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            download.access(line);
        }
        scan.close();
        Scanner scan2 = new Scanner(System.in);
        String[] downloads = new String[5];
        downloads = download.top(5);
        for(int i = 0; i< 5; i++){
            System.out.println(downloads[i]);
        }
        System.out.println("Inserisci nome del file che vuoi eliminare");
        String line = scan2.nextLine();
        download.remove(line);
        downloads = download.top(5);
        for(int i = 0; i< 5; i++){
            System.out.println(downloads[i]);
        }
    }
}

// ------------------- classe ListaDowload: da completare --------------------

/*
    Classe che implementa l'interfaccia FavoriteList e contiene coppie di tipo
    "file accessi" appartenenti alla classe Coppia (realizzata come classe 
    interna a ListaDownload).
    La classe interna Coppia contribuisce a realizzare il tipo di dato astratto
    FavoriteList (cfr. commenti all'interfaccia FavoriteList). In particolare 
    la variabile intera "accessi" di ciascuna coppia rappresenta il contatore
    degli accessi di ciascun oggetto (un file, in questo caso) presente nella
    lista dei preferiti.
*/
class ListaDownload implements FavoriteList
{   
    private Coppia[] v;
    private int vSize;
    private static int INITSIZE = 10;
    public ListaDownload(){
        v = new Coppia[INITSIZE];
        vSize = 0;
    }
    public boolean isEmpty(){
        return(vSize == 0);
    }
    public int size(){
        return vSize;
    }
    private void  resize(){
        Coppia[] temp = new Coppia[2 * v.length];
        System.arraycopy(v, 0, temp, 0, v.length);
        v = temp;
    }
    private int search(String file){
        if(file == null || !(file instanceof String)){
            throw new IllegalArgumentException();
        }
        for(int i = 0; i < vSize; i++){
            if((v[i].getFile()).equals(file)){
                return i;
            }
        }
        return -1;
    }
    public void access(Object obj){
        int poszione = search((String) obj);
        if(poszione != -1){
            v[poszione].setAccessi(v[poszione].getAccessi() + 1);
            int i = poszione;
            while (i > 0 && v[i-1].compareTo(v[i]) < 0){
                Coppia tmp = v[i];
                v[i] = v[i-1];
                v[i-1] = tmp;
                i--;
            }
        }
        else{
            if(vSize == v.length  ){
                resize();
            }
            v[vSize++] = new Coppia((String)obj);
        }
    }
    public void remove(Object obj){
        int poszione = search((String) obj);
        if(poszione == -1){
            throw new FLItemNotFoundException();
        }
        for(int i = poszione; i < vSize - 1; i++){
            v[i] = v[i+1];
        }
        vSize--;
    }
    public  String[] top(int k){
        if(k <= 0 || k > vSize){
            throw new IllegalArgumentException();
        }
        String[] classifica = new String[k];
        for (int i = 0; i < k; i++)
            classifica[i] = v[i].toString();
        return classifica;
    }
    //costruttori e metodi pubblici di FavoriteList ......da completare ......
    // ...


    //campi di esemplare ..... da completare ......
    // ...


    // --------- classe interna privata Coppia: non modificare!! ---------
    protected class Coppia implements Comparable
    {
        // Costruttore: inizializza il campo "file" con il valore del suo
        // parametro esplicito, e assegna il valore 1 al campo "accessi"  
        public Coppia(String file)
        {   setFile(file); 
            setAccessi(1); 
        }

        // Costruttore: inizializza entrambi i campi  
        public Coppia(String file, int accessi)
        {   setFile(file); 
            setAccessi(accessi); 
        }

        //metodi pubblici: toString, compareTo, met. modificatori e di accesso

        public String toString()
        {  return file + " :: " + accessi; } 

        // Compara due oggetti di tipo Coppia secondo i loro numeri di accessi.
        // Una coppia e` "maggiore" di un'altra se ha un numero di accessi piu`
        // alto.
        public int compareTo(Object o)
        {   return (accessi - ( (Coppia) o).accessi);
        }

        public String getFile()
        {  return file; }
        public int getAccessi()
        {  return accessi; }
        public void setFile(String file)
        {  this.file = file; }
        public void setAccessi(int accessi)
        {  this.accessi = accessi; } 

        //campi di esemplare
        private String file; //stringa che rappresenta il nome del file
        private int accessi; //intero che rappresenta il n. di accessi al file
    }
}



// ---------------- Interfaccia FavoriteList: non modificare !!--------------
 
/*
    Il tipo di dato astratto FavoriteList (lista dei preferiti) rappresenta
    un contenitore di oggetti in cui e` possibile tenere traccia del numero
    di accessi che sono stati fatti a ciascun oggetto.
    Tramite l'informazione sul numero di accessi a ciascun oggetto, e` 
    possibile conoscere quali sono gli oggetti "preferiti" (ovvero quelli che 
    hanno piu` accessi) tra tutti quelli presenti nel contenitore.
*/
interface FavoriteList  // non modificare!!
{
    /*
     Metodo isEmpty
     Restituisce true se la lista dei preferiti e` vuota, false altrimenti
    */
    boolean isEmpty(); 

    /*
     Metodo size
     Restituisce il numero di elementi presenti nella lista dei preferiti
    */
    int size(); 

    /*
     Metodo access
     Effettua un accesso all'oggetto obj (parametro esplicito del metodo).
     1) Se obj non e` gia` presente nella lista dei preferiti (ovvero se e` 
        la prima volta che si fa un accesso a obj), lo aggiunge assegnando il
        valore 1 al contatore dei suoi accessi.
     2) Se obj e` gia` presente (ovvero se in precedenza sono gia` stati 
        fatti accessi a obj), incrementa di 1 il contatore dei suoi accessi. 
     Lancia IllegalArgumentException se obj e` null. 
    */
    void access(Object obj);

    /*
     Metodo remove
     Rimuove l'oggetto obj (e il contatore dei suoi accessi) dalla lista dei 
     preferiti. Lancia FLItemNotFoundException se obj non e` presente
    */
    void remove(Object obj);

    /*
     Metodo top
     Restituisce un array di lunghezza k (parametro esplicito del metodo). 
     L'array restituito contiene k stringhe che rappresentano i k oggetti 
     "preferiti", ordinati per numero di accessi. Quindi:
     - L'elemento di indice 0 dell'array restituito contiene una stringa
       che rappresenta l'oggetto con il maggior numero di accessi tra tutti 
       gli oggetti presenti nella lista dei preferiti.
     - L'elemento di indice 1 contiene una stringa che rappresenta il
       secondo oggetto per numero di accessi.
     - E cosi` via. 
     - Esempio: l'invocazione top(10) restituisce un array di 10 stringhe
       contenenti la "top-ten" della lista dei preferiti, ovvero i primi 10
       oggetti per numero di accessi, ordinati dal primo al decimo.
     Lancia IllegalArgumentException se il valore di k e` minore di 1 oppure e`
     maggiore del numero degli oggetti presenti nella lista dei preferiti.
    */
    String[] top(int k);
}

/*
 Eccezione che segnala il mancato ritrovamento di un oggetto nella lista dei
 preferiti
*/
class FLItemNotFoundException extends RuntimeException {  }
class IllegalArgumentException extends RuntimeException{}