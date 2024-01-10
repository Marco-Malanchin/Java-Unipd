// INSERIRE I PROPRI DATI PERSONALI
// nome e cognome del candidato, matricola, data,       numero postazione
//Marco Malanchin               ABC123     09/01/2024  ADT104


// -------------- classe TranslatorTester: da completare -----------------
import java.util.*;
import java.io.*;

public class TranslatorTester
{   public static void main(String[] args)
    {
        // ....... da completare ............
        if(args[0]== null){
            System.out.println("Errore, inserire nome file di testo");
            System.exit(1);
        }
        String filename = args[0];
        Scanner scan = null;
        try{
            scan = new Scanner(new FileReader(filename));
        }
        catch(FileNotFoundException e){
            System.out.println("Errore apertura file");
            System.exit(1);
        }
        Translator dizionario = new Translator(scan);
        scan.close();
        boolean controllo = false;
        Scanner scan2 = new Scanner(System.in);
        while(!controllo){
            System.out.println("Premi P per stampare tutto il dizionario" + "\n" + "Premi F per cercare una parola e stamparne le traduzioni"+ "\n" +"Premi FA per cercare tutte le parole che iniziano per un prefisso scelto" + "\n"+ "Premi Q per terminare il programma" );
            String scelta = scan2.nextLine();
            scelta = scelta.toUpperCase();
            if(scelta.equals("P")){
                String traduzioni = dizionario.toString();
                System.out.println(traduzioni);
            }
            else if(scelta.equals("F")){
                System.out.println("Inserisci la parola da cercare nel dizionario");
                String parola = scan2.nextLine();
                parola = parola.toLowerCase();
                parola += " ";
                try{
                    String tutteLeTraduzioni = (String)dizionario.find(parola);
                    System.out.println("Ecco tutte la traduzioni della parola:" + "\n" + tutteLeTraduzioni);
                }
                catch(MapItemNotFoundException e){
                    System.out.println("Parola  non trovata");
                }
            }
            else if(scelta.equals("FA")){
                System.out.println("Inserisci il suffisso da cercare nel dizionario");
                String suffix = scan2.nextLine();
                suffix= suffix.toLowerCase();
                  try{
                    String[] paroleConPrefisso = dizionario.findStartsWith(suffix);
                    System.out.println("Ecco tutte le parole che iniziano con il prefisso:" + "\n" );
                    for(int i = 0; i < paroleConPrefisso.length; i++){
                        System.out.println(paroleConPrefisso[i] + "\n");
                    }
                }
                catch(MapItemNotFoundException e){
                    System.out.println("Parole  non trovate");
                }
            }
            else if(scelta.equals("Q")){
                System.out.println("TERMINO IL PROGRAMMA...");
                controllo = true;
            }
            else{
                System.out.println("Comando inserito in maniera sbagliata");
            }
        }

    }
}


// -------------------- classe Translator: da completare -------------------


/*
    Classe che implementa l'interfaccia StringMap
    La classe contiene coppie di tipo "parola, traduzioni": una possibile 
    realizzazione di queste coppie e` data dalla classe WordPair, classe 
    interna di Translator. In ogni caso il campo valore delle coppie inserite 
    in contenitori di tipo Translator e` di tipo String[] (che e` comunque
    una sottoclasse di Object ...)
    Si presti particolare attenzione al metodo findStartsWith.
    - SUGGERIMENTO 1: studiando la documentazione della classe String e` 
        possibile trovare un modo per verificare se una stringa ha un'altra
        stringa come prefisso.
    - SUGGERIMENTO 2: una volta capito come verificare se una chiave ne ha
        un'altra come prefisso, e` abbastanza facile scrivere una realizzazione
        non-ottima del metodo findStartsWith (ovvero una realizzazione corretta
        con prestazioni O(n) ). Invece scrivere una realizzazione ottima (con 
        prestazioni O(log n) ) e` nettamente piu` complicato: si consiglia di
        provarci solo dopo avere completato una realizzazione non-ottima.
*/


class Translator implements StringMap
{
    //costruttori e metodi pubblici di StringMap .....da completare.....
    private WordPair[] v;
    private int vSize;
    public Translator(){
        v = new WordPair[4];
        vSize = 0;
    }
    public  boolean isEmpty(){
        return (vSize == 0);
    }
    public int size(){
        return vSize;
    }
    protected void resize(){
        WordPair[] temp = new WordPair[2 * v.length];
        System.arraycopy(v,0,temp,0,v.length);
        v = temp;
    }
    protected int search(String key){
        for(int i = 0; i < vSize; i++){
            if((v[i].getWord()).equals(key)){
                return i;
            }
        }
        return -1;
    }
    public void insert(String key, Object value){
        if(key == null || !(key instanceof String)){
            throw new IllegalArgumentException();
        }
        String lineaTemporanea = (String) value;
        Scanner scan3 = new Scanner(lineaTemporanea);
        String[] temp3 = new String[50];
        int counter = 0;
        while(scan3.hasNext()){
            temp3[counter++] = scan3.next();
        }
        String [] parole = new String[counter];
        for(int i = 0; i < counter; i++){
                    parole[i] =temp3[i];
        }
        if(vSize == v.length){
            resize();
        }
        int posizione = search(key);
        if(posizione != -1){
            v[posizione] = new WordPair(key, parole);
            int i = vSize - 1;
            while(i > 0 && ((v[i].getWord()).compareTo((v[i-1].getWord()))) < 0){
                WordPair tmp = v[i];
                v[i] = v[i - 1];
                v[i - 1] = tmp;
                i--;
            }
        }
        else{
            v[vSize++] =  new WordPair(key, parole);
            int i = vSize - 1;
            while(i > 0 && ((v[i].getWord()).compareTo((v[i-1].getWord()))) < 0){
                WordPair tmp = v[i];
                v[i] = v[i - 1];
                v[i - 1] = tmp;
                i--;
            }
        }
    }
    public Object find(String key){
        for(int i = 0; i < vSize; i++){
            if(v[i].getWord().equals(key)){
                String[] pippo = v[i].getTranslations();
                String s = "";
                for(int j = 0; j < pippo.length; j++){
                    s += pippo[j] + " ";
                }
                return s;
            }
        }
        throw new MapItemNotFoundException();
    }
     public void remove(String key){
        int posizione = search(key);
        if(posizione != -1){
            for(int i = posizione; i <  vSize -1; i++){
                v[i] = v[i+1];
            }
        }
        else{
            throw new MapItemNotFoundException();
        }
     }
     public String[] findStartsWith(String prefix){
        int counter = 0;
        for(int i = 0; i < vSize - 1; i++){
            if((v[i].getWord()).startsWith(prefix)){
                counter++;
            }
        }
        if(counter == 0){
            throw new MapItemNotFoundException();
        }
        String[] parole = new String[counter];
        int j = 0;
        for(int i = 0; i < vSize - 1; i++){
            if((v[i].getWord()).startsWith(prefix) && j < counter){
                parole[j] = (v[i].getWord());
                j++;
            }
        }
        return parole;
     }
    //costruttore .....  da completare secondo specifiche del compito ......
    public Translator(Scanner file)
    {
        v  = new WordPair[10];
        vSize = 0;
        while(file.hasNextLine()){
            if(vSize == v.length){
                WordPair[] temp = new WordPair[2 * v.length];
                System.arraycopy(v,0,temp,0,v.length);
                v = temp;
            }
            String linea = file.nextLine();
            Scanner temp1 = new Scanner(linea);
            temp1.useDelimiter(":");
            while(temp1.hasNext()){
                String parolaEng = temp1.next();
                String[] parolaTradottaTemp = new String[50];
                int counter = 0;
                String parolaDaDividere =temp1.next();
                Scanner temp2 = new Scanner(parolaDaDividere);
                temp2.useDelimiter(",");
                while(temp2.hasNext()){
                    parolaTradottaTemp[counter++] = temp2.next();
                }
                String[] parolaTradotta = new String[counter];
                for(int i = 0; i < counter; i++){
                    parolaTradotta[i] =parolaTradottaTemp[i];
                }
                String traduzioni = "";
                for(int i = 0; i < counter; i++){
                    traduzioni += parolaTradotta[i] + " ";
                }
                v[vSize++]= new WordPair(parolaEng, parolaTradotta);
            }
            temp1.close();
        }
    }

    //metodo toString ..... da completare secondo specifiche del compito ......
    public String toString()
    {
        // ...
        String s = "";
        for(int i = 0; i < vSize; i++){
            s += v[i] + "\n";
        }
        return s;
    }          
    
    //campi di esemplare ..... da completare ......
    // ...



    // --------- classe interna privata WordPair: non modificare!! ---------
    private class WordPair
    {   public WordPair(String word, String[] translations)
        {   this.word = word; 
            this.translations = translations;
        }
        public String getWord() 
        { return word; }
        public String[] getTranslations() 
        { return translations; }

        //  Restituisce una stringa nel formato
        //      word : traduzione1, traduzione2, traduzione3, ecc.
        public String toString() 
        {   String retString = word + " :";
            for (int i = 0; i < translations.length; i++)
	            retString += " " + translations[i] + ",";
            return retString.substring(0,retString.length()-1);
        }
        //campi di esemplare
        private String word;           // parola inglese
        private String[] translations; // array contenente una o piu` possibili
                                       // traduzioni in italiano
    }
}



// -------------- Interfaccia StringMap: non modificare !!---------------

interface StringMap // Definisce una mappa le cui chiavi sono stringhe
{
    boolean isEmpty(); // true: contenitore vuoto; false: contenitore non vuoto

    int size();       // restituisce il n. di elementi presenti nel contenitore

    // L'inserimento va sempre a buon fine; se la chiave non esiste, la coppia 
    // key/value viene aggiunta alla mappa; se la chiave esiste gia`, il valore
    // ad essa associato viene sovrascritto con il nuovo valore.
    void insert(String key, Object value);

    // La rimozione della chiave rimuove anche la corrispondente coppia.
    // Lancia MapItemNotFoundException se la chiave non esiste.
    void remove(String key);

    // La ricerca per chiave restituisce soltanto il valore ad essa associato
    // nella mappa. Lancia MapItemNotFoundException se la chiave non esiste.
    Object find(String key);

    // La ricerca per "prefisso" cerca nella mappa tutte le chiavi che iniziano
    // con la stringa prefix, e restituisce tali chiavi sotto forma di un array  
    // di stringhe (pieno).
    // Lancia MapItemNotFoundException se la mappa non contiene nessuna chiave 
    // che inizia con la stringa prefix.
    String[] findStartsWith(String prefix);

}

//Eccezione che segnala il mancato ritrovamento di una chiave
class MapItemNotFoundException extends RuntimeException {  }
class IllegalArgumentException extends RuntimeException{ }