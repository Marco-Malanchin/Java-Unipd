// INSERIRE I PROPRI DATI PERSONALI
// nome e cognome del candidato, matricola, data,       numero postazione
// Marco Malanchin                ABC123     09/01/2024  ADT104


// -------------- classe EncoderTester: da completare -----------------
import java.io.*;
import java.util.*;
public class EncoderTester
{   public static void main(String[] args)
    {
      // ....... da completare ............
      if(args[0] == null){
        System.out.println("Errore, Inserisci un file per prendere il cifrario");
        System.exit(1);
      }
      String cifrario = args[0];
      Scanner scan = null;
      try{
            scan = new Scanner(new FileReader(cifrario));
      }
      catch(FileNotFoundException e){
            System.out.println("File not Found");
        }
        Encoder pippo = new Encoder();
        while(scan.hasNextLine()){
            String coppia = scan.nextLine();
            Scanner scan2 = new Scanner(coppia);
            while(scan2.hasNext()){
                try{
                    String codice = scan2.next();
                    String valore = scan2.next();
                    pippo.insert(codice , valore);
                }
                catch (NoSuchElementException e){
                    System.out.println("Formato riga sbagliato");
                }
            }
            scan2.close();
        }
        scan.close();
        Scanner scan3 = new Scanner(System.in);
        String fraseCambiata = "";
        while(scan3.hasNextLine()){
           String frase =scan3.nextLine();
            Scanner scan4 = new Scanner(frase);
            while(scan4.hasNext()){
                String parola = scan4.next();
                try{
                    parola = (String)pippo.find(parola);
                    fraseCambiata += parola +" ";
                }
                catch(MapItemNotFoundException e){
                    fraseCambiata += parola + " ";
                }
            }
            scan4.close();
        }
        scan3.close();
        System.out.println(fraseCambiata);
        Encoder pippo2 = new Encoder();
        pippo2 = (Encoder)pippo.invert();
        String fraseRicambiata = "";
        Scanner scan5 = new Scanner(fraseCambiata);
        while(scan5.hasNext()){
            String parola = scan5.next();
            try{
                parola = (String)pippo2.find(parola);
                fraseRicambiata += parola + " ";
            }
            catch(MapItemNotFoundException e){
                fraseRicambiata += parola + " ";
            }
        }
        scan5.close();
        System.out.println(fraseRicambiata);
    }
} 


// -------------------- classe Encoder: da completare -------------------

class Encoder implements InvertibleMap
{

    //costruttori e metodi pubblici di InvertibleMap .....da completare.....
    private StringPair[] v;
    private int vSize;
    public Encoder(){
        v = new StringPair[10];
        vSize = 0;
    }
    public Encoder(int dim){
        v = new StringPair[dim];
        vSize = 0;
    }
    public boolean isEmpty(){
        return (vSize == 0);
    }
    public int size(){
        return vSize;
    }
    private void resize(){
        StringPair[] temp = new StringPair[2 * v.length];
        System.arraycopy(v,0,temp,0,v.length);
        v = temp;
    }
    private int search(String key){
        if(key == null || !(key instanceof String)){
            throw new IllegalArgumentException();
        }
        for(int i = 0; i < vSize; i++){
            if((v[i].getWord()).equals(key)){
                return i;
            }
        }
        return -1;
    }
    public void insert(Comparable key, Comparable value){
        if(key == null || !(key instanceof String) || !(value instanceof String)){
            throw new IllegalArgumentException();
        }
        if(vSize == v.length){
            resize();
        }
        int posizione = search((String) key);
        if(posizione != -1){
            v[posizione] = new StringPair((String) key , (String) value);
            int i = posizione;
            while(i > 0 && (v[i].getWord()).compareTo(v[i -1].getWord()) <  0){
                StringPair tmp = v[i];
                v[i] = v[i -1];
                v[i-1] = tmp;
                i--;
            }
        }
        else{
            v[vSize++] = new StringPair((String) key, (String) value);
            int i = vSize - 1;
            while(i > 0 && (v[i].getWord()).compareTo(v[i -1].getWord()) <  0){
                StringPair tmp = v[i];
                v[i] = v[i -1];
                v[i-1] = tmp;
                i--;
            }
        }
    }
    public void remove(Comparable key){
        int poszione = search((String) key);
        if(poszione != -1){
            for(int i = poszione; i < vSize - 1; i++){
                v[i] = v[i +1];
            }
            vSize--;
        }
        else{
            throw new MapItemNotFoundException();
        }
    }
    public Comparable find(Comparable key){
        if(key == null || !(key instanceof String)){
            throw new IllegalArgumentException();
        }
        int low = 0 , high = vSize - 1;
        while(low <= high){
            int mid = (low + high)/2;
            if((v[mid].getWord()).equals(key)){
                return (v[mid].getCode());
            }
            else if(key.compareTo(v[mid].getWord()) < 0){
                high = mid -1;
            }
            else{
                low = mid +1;
            }
        }
        throw new MapItemNotFoundException();
    }
    public InvertibleMap invert(){
        Encoder temp = new Encoder(vSize);
        for(int i = 0; i < vSize; i++){
           temp.insert((v[i].getCode()), (v[i].getWord()));   
        }
        return temp;
    }
    //metodo toString ..... da completare secondo specifiche del compito ......
    public String toString()
    {
        String s ="";
        for(int i = 0; i  < vSize; i++){
            s += v[i] + "\n"; 
        }
        return s;
    }          
    
    //campi di esemplare ..... da completare ......
    // ...

    
    /* --------- classe interna privata StringPair: non modificare!! ---------

        Un oggetto StringPair contiene una coppia "parola codice" entrambi di
        tipo String. Il primo campo e` una parola da cifrare, il secondo e` il 
        codice corrispondente alla parola. 
    */
    private class StringPair
    {   public StringPair(String word, String code)
        {   this.word = word; 
            this.code = code;
        }      
        // metodi (pubblici) di accesso
        public String getWord() 
        { return word; }
        public String getCode() 
        { return code; }
        //metodo toString sovrascritto
        public String toString() 
        {   return word + " " + code;
        }
        //campi di esemplare (privati)
        private String word;  //parola da cifrare
        private String code;  //codice associato alla parola
    }
}


/* -------------- Interfaccia InvertibleMap: non modificare !!---------------
  
    Questo tipo di dato astratto definisce un contenitore di coppie 
    "chiave valore", che hanno l'usuale significato.
    Si tratta di un tipo di dato astratto "mappa", con la particolarita` che 
    entrambi i campi sono di tipo Comparable, e con la proprieta` aggiuntiva
    che e` possibile creare la "mappa inversa" (si vedano piu` sotto i commenti
    al metodo invert).
*/

interface InvertibleMap   //non modificare!!
{
    boolean isEmpty(); // true: contenitore vuoto; false: contenitore non vuoto

    int size();       // restituisce il n. di elementi presenti nel contenitore

    /* 
        L'inserimento va sempre a buon fine; se la chiave non esiste, la coppia 
        key/value viene aggiunta alla mappa; se la chiave esiste gia`, il 
        valore ad essa associato viene sovrascritto con il nuovo valore; se key
        e` null viene lanciata IllegalArgumentException.
    */
    void insert(Comparable key, Comparable value);

    /* 
        La rimozione della chiave rimuove anche la corrispondente coppia.
        Lancia MapItemNotFoundException se la chiave non esiste
    */
    void remove(Comparable key);

    /* 
        La ricerca per chiave restituisce soltanto il valore ad essa associato
        nella mappa. Lancia MapItemNotFoundException se la chiave non esiste.
    */
    Comparable find(Comparable key);

    /* 
        Metodo che crea la "mappa inversa", ovvero un nuovo oggetto di tipo 
        InvertibleMap che, per ogni coppia key/value della mappa originale 
        (parametro implicito), contiene una corrispondente "coppia inversa" 
        value/key.
        Notare che l'operazione e` possibile perche` key e value sono entrambi
        oggetti di tipo Comparable: quindi e` possibile usare i valori value 
        come chiavi della mappa inversa.
        Se nella mappa originale (parametro implicito) sono presenti piu`
        coppie con lo stesso campo value, nella mappa inversa verra` inserita 
        una qualsiasi delle coppie inverse.
    */
    InvertibleMap invert();
}

class MapItemNotFoundException extends RuntimeException  {}
class IllegalArgumentException extends RuntimeException{}