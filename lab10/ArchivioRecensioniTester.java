// nome e cognome del candidato, matricola, data,       numero postazione
// ..............                ......     ../../....  ADT..


// -------------- classe ArchivioRecensioniTester: da completare --------------
import java.io.*;
import java.util.*;
public class ArchivioRecensioniTester
{
    public static void main(String[] args)
    {   //controllo parametri del metodo main
        if (args.length != 1)
        { System.out.println("Uso: $java ArchivioRecensioniTester filename");
          System.exit(1);
        }
        String filename = args[0];

        //apertura di file1 in lettura
        Scanner file = null;
        try{  file = new Scanner(new FileReader(filename));  }
        catch(FileNotFoundException e)
        {   System.out.println("Problema in apertura File. Termino");
            System.exit(1); }

        //Creazione e  scrittura di recensioni
        ArchivioRecensioni movies = new ArchivioRecensioni();
        while (file.hasNextLine())
        {   String line = file.nextLine();
            Scanner linescan = new Scanner(line);
            linescan.useDelimiter(" :: ");
            try{
            String titolo = linescan.next(); //titolo film
            int voto = Integer.parseInt(linescan.next()); // voto utente
            String commento = linescan.next(); //commento utente
            movies.insert(titolo, new Recensione(voto,commento) );
            }//NoSuchElementException puo` essere lanciata da next se
            catch(NoSuchElementException e) //non vengono trovati token
            {   System.out.println("Formato riga sbagliato");  }
            //NumberFormatException puo` essere lanciata da parseInt se la
            catch(NumberFormatException e) //seconda stringa non e` un int
            {   System.out.println("Formato voto sbagliato");  }
        }
        file.close(); //controllo contenuto di iscritti e chiudo file

        // gestione dell'archivio di recensioni tramite ciclo-e-mezzo
        Scanner in = new Scanner(System.in);
        boolean done = false;
        while (!done)
        {   System.out.println("\n******************************************");
            System.out.println("Comandi:");
            System.out.println("\"P\" per stampare tutto l'archivio");
            System.out.println("\"FA <Titolo>\" per stampare tutte le");
            System.out.println("                recensioni del film Titolo");
            System.out.println("\"R\" <Titolo> <voto> <commento> per rimuovere");
            System.out.println("                la recensione corrispondente");
            System.out.println("\"Q\" per terminare");
            System.out.println("******************************************\n");

            String comando = in.nextLine();
            if (comando.equalsIgnoreCase("Q") )
            {   System.out.println("Chiusura applicazione");
                done = true;
            }
            else
            {   if (comando.equalsIgnoreCase("P") )
                {   System.out.println("Elenco recensioni:\n" + movies);
                }
                else if (comando.equalsIgnoreCase("FA") )
                {   System.out.println("Titolo da cercare?");
                    String titolo = in.nextLine();
                    try{Object[] a = movies.findAll(titolo);
                        System.out.print("Recensioni disponibili per ");
                        System.out.println("il film \"" + titolo +"\":");
                        for (int i = 0; i< a.length; i++)
                            System.out.println(a[i]);
                    }
                    catch (MultiMapItemNotFoundException e)
                    {   System.out.println("Titolo non presente.");
                    }
                }
                else if (comando.equalsIgnoreCase("R") )
                {   System.out.println("Recensione da rimuovere?");
                    String line = in.nextLine();
                    Scanner linescan = new Scanner(line);
                    linescan.useDelimiter(" :: ");
                    try{
                        String titolo = linescan.next();
                        int voto = Integer.parseInt(linescan.next());
                        String commento = linescan.next();
                        movies.remove(titolo, new Recensione(voto,commento) );
                        } //NoSuchElementException lanciata da next se
                    catch(NoSuchElementException e) //non vengono trovati token
                    {   System.out.println("Formato riga sbagliato");  }
                    //NumberFormatException lanciata da parseInt se la seconda
                    catch(NumberFormatException e) // stringa non e` un int
                    {   System.out.println("Formato voto sbagliato");  }
                    catch (MultiMapItemNotFoundException e)
                    {   System.out.println("Titolo non presente.");
                    }
                }
                else { System.out.println("Comando errato"); }
            }
        }
    }
}

// -------------------- classe Recensioni: da completare -------------------

/*
    Classe che implementa l'interfaccia MultiMap e gestisce coppie di tipo
    "voto commento" appartenenti alla classe Coppia (realizzata come classe 
    interna a Recensioni. Sovrascrive toString in modo che restituisca una
    stringa con il seguente formato: 
    (1) i dati di ogni coppia vengono scritti su una riga diversa;
    (2) in ogni riga i dati vengono scritti con il formato del metodo toString 
        della classe Coppia.
*/
class ArchivioRecensioni implements MultiMap
{   
    //costruttori e metodi pubblici di MultiMap ......da completare ......
    // ...
    private Coppia[] v;
    private int size;
    private static int INITSIZE = 10;
    public ArchivioRecensioni(){
        v = new Coppia[INITSIZE];
        size = 0;
    }
    public boolean isEmpty(){
        return (size == 0);
    }
    public int getSize(){
        return size;
    }
    private  void resize(){
        Coppia[] temp = new Coppia[2*v.length];
        System.arraycopy(v,0,temp,0,v.length);
        v = temp;
    }
    public void insert(Comparable key, Object value){
        if (key == null || !(key instanceof String)
                        || !(value instanceof Recensione) ){
                            throw new IllegalArgumentException();
                        }
        if (size == v.length){
            resize();
        } 
        v[size] = new Coppia((String) key , (Recensione) value);
        size++;
    }
    public void remove(Comparable key, Object value){
        int rimozione = 0;
        boolean trovato = false;
        for(int i = 0; i < size; i++){
            if((v[i].getKey()).equals( key) && (v[i].getValue()).equals(value)){
                rimozione = i;
                trovato = true;
                break;
            }
        }
        if(rimozione == 0 && trovato == false){
            throw new MultiMapItemNotFoundException();
        }
        int stop = size - rimozione;
        if(stop == 0){
            size--;
        }
        else{
            for(int i = rimozione; i<= stop; i++ ){
                v[i] = v[i + 1];
            }
            size--;
        }
    }
    public Object find(Comparable key){
        int rimozione = 0;
        boolean trovato = false;
        for(int i = 0; i < size; i++){
            if((v[i].getKey()).equals( key)){
                rimozione = i;
                trovato = true;
                break;
            }
        }
        if(rimozione == 0 && trovato == false){
            throw new MultiMapItemNotFoundException();
        }
        return (v[rimozione].getValue());
    }
    public int primo(String key){
        int rimozione = 0;
        boolean trovato = false;
        for(int i = 0; i < size; i++){
            if((v[i].getKey()).equals( key)){
                rimozione = i;
                trovato = true;
                break;
            }
        }
        if(rimozione == 0 && trovato == false){
            throw new MultiMapItemNotFoundException();
        }
        return rimozione;
    }
    public int ultimo(String key){
        int rimozione = 0;
        boolean trovato = false;
        for(int i = 0; i < size; i++){
            if((v[i].getKey()).equals( key)){
                rimozione = i;
                trovato = true;
            }
        }
        if(rimozione == 0 && trovato == false){
            throw new MultiMapItemNotFoundException();
        }
        return rimozione;
    }
    public Object[] findAll(Comparable key){
        int rimozione = 0;
        boolean trovato = false;
        int primo = primo((String) key);//inutili
        int ultimo = ultimo((String) key);//inutili
        int ripetzioni = 0;
        for(int i = 0; i < size; i++){
            if((v[i].getKey()).equals( key)){
                rimozione = i;
                trovato = true;
                ripetzioni++;
            }
        }
        if(ripetzioni == 0){
            throw new MultiMapItemNotFoundException();
        }
        int contatore = 0;
        Object[] recensioni = new Object[ripetzioni];
        for(int i = 0; i < size; i++){
            if((v[i].getKey()).equals( key)){
                rimozione = i;
                trovato = true;
                recensioni[contatore++] = v[i].getValue();
            }
        }
        if(rimozione == 0 && trovato == false){
            throw new MultiMapItemNotFoundException();
        }
        return recensioni;
    }
    //metodo toString ..... da completare secondo specifiche del compito ......
    public String toString()
    {
        String s = "";
        for (int i = 0; i < size; i++)
            s = s + v[i] + "\n"; 
        return s;
    }          

    //campi di esemplare ..... da completare ......
    // ...


    
    /* 
        --------- classe privata interna Coppia: non modificare!! ---------
    */
    private class Coppia
    {   public Coppia(String key, Recensione value) //costruttore
        {   setKey(key); 
            setValue(value); 
        }
        //metodi pubblici: toString, metodi modificatori e di accesso
        public String toString()
        {   String s = key + " :: " + value;
            return s;    
        } 
        public String getKey()
        {  return key; }
        public Recensione getValue()
        {  return value; }
        public void setKey(String key)
        {  this.key = key; }
        public void setValue(Recensione value)
        {   this.value = value; }     
        //campi di esemplare
        private String key;       //titolo dell'oggetto recensito 
        private Recensione value; //recensione (voto+commento) data all'oggetto
    }
}


// --------- classe Recensione: non modificare!! ---------
/* 
    Un oggetto di questa classe rappresenta una singola recensione inserita
    da un utente, ed e` composto da due campi di esemplare:
        1) un numero intero compreso tra 0 e 10, che rappresenta il voto dato
           dall'utente
        2) una stringa contenente un commento aggiuntivo scritto dall'utente
    Notare che questa classe sovrascrive il metodo equals di Object. E` quindi
    possibile verificare l'uguaglianza di 2 oggetti di tipo Recensione tramite
    il metodo equals. In particolare, 2 oggetti di tipo Recensione sono uguali
    se sono uguali entrambi i loro campi di esemplare (voto e commento)
*/
class Recensione
{   public Recensione(int voto, String commento) //costruttore
    {   setVoto(voto); 
        setCommento(commento); 
    }
    //metodi pubblici: toString, equals, metodi modificatori e di accesso
    public String toString()
    {   String s = voto + " :: " + commento;
        return s;    
    } 
    public boolean equals(Object o)
    {   Recensione altra = (Recensione) o;
        return (this.voto == altra.voto) && 
                ( (this.commento).equals(altra.commento) );
    }   
    public int getVoto()
    {  return voto; }
    public String getCommento()
    {  return commento; }
    public void setVoto(int voto)
    {   if (voto<0 || voto>10) throw new IllegalArgumentException();
        this.voto = voto; }
    public void setCommento(String commento)
    {  this.commento = commento; } 

    //campi di esemplare
    private int voto; // voto (tra 0 e 10) dato all'oggetto recensito
    private String commento; // commento sull'oggetto recensito
}



// ------------------ Interfaccia MultiMap: non modificare !!----------------

interface MultiMap  // non modificare!!
{
    boolean isEmpty(); // true: contenitore vuoto; false: contenitore non vuoto

    int getSize();       // restituisce il n. di elementi presenti nel contenitore

    /*
     Inserisce nella multimappa una nuova coppia specificata dai valori key e
     value. L'inserimento va sempre a buon fine:
     - se la chiave non e` gia` presente nel contenitore, la coppia viene
       inserita
     - se invece esistono gia` coppie con la chiave key, viene creata una
       nuova coppia con i valori key, value, e le coppie gia` esistenti 
       rimangono presenti nel contenitore senza venire cancellate o 
       sovrascritte
     Se key e` null lancia IllegalArgumentException
    */
    void insert(Comparable key, Object value);

    /*
     Rimuove dalla multimappa la coppia specificata dai valori key e value.
     Se la coppia non esiste, lancia MultiMapItemNotFoundException 
    */
    void remove(Comparable key, Object value);

    /*
     Cerca nella multimappa una coppia specificata dalla chiave key e 
     restituisce soltanto il valore ad essa associato.
     Se esistono piu` coppie aventi la stessa chiave key, restituisce il valore
     della prima coppia trovata (in pratica, restituisce un valore arbitrario
     tra i valori di tutte le coppie la cui chiave e` key).
     Se non esistono coppie con la chiave key, lancia
     MultiMapItemNotFoundException
    */
    Object find(Comparable key);

    /*
     Cerca nella multimappa tutte le coppie specificate dalla chiave key e
     restituisce un array pieno contenente i valori di tutte le coppie trovate.
     Se non esistono coppie con la chiave key, lancia
     MultiMapItemNotFoundException
    */
   Object[] findAll(Comparable key);
}

//Eccezione che segnala il mancato ritrovamento di una chiave o coppia
class MultiMapItemNotFoundException extends RuntimeException  {}
class IllegalArgumentException extends RuntimeException{}