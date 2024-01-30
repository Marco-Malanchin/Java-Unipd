// nome e cognome del candidato, matricola, data,       numero postazione
// ..............                ......     ../../....  ADT..


// -------------- classe StatPromossiTester: da completare -----------------
public class StatPromossiTester
{
    public static void main(String[] args)
    {
        // ....... da completare ............
    }


}


// -------------------- classe Studenti: da completare -------------------
/*
    Classe che implementa l'interfaccia Set.
    La classe realizza un tipo di dato astratto insieme e puo` contenere solo
    oggetti di tipo Studente (classe realizzata piu` sotto).
    La classe sovrascrive toString in modo che restituisca una stringa con il
    seguente formato: 
    (1) ogni oggetto viene scritto su una nuova riga
    (2) in ogni riga i dati sono scritti con il formato del metodo toString 
        della classe Studente
*/


class Studenti implements Set
{   
    //costruttori e metodi pubblici di Studenti .....da completare.....
    // ...


    //metodo toString ..... da completare secondo specifiche del compito ......
    public String toString()
    {
        // ...
    }          

    //campi di esemplare ..... da completare ......
    // ...

}



// ---------------- Classe Studente: non modificare!! ---------------------

class Studente implements Comparable
{
    public Studente(int matricola, String cognome, String nome)
    {   this.matricola = matricola;
        this.cognome = cognome;
        this.nome = nome;
    }

    public String toString()
    {   return matricola + " ; " + cognome + " ; " + nome;
    }

    public boolean equals(Object o)
    {   return this.matricola == ((Studente)o).matricola;
    }

    public int compareTo(Object o)
    {   return this.matricola - ((Studente)o).matricola;
    }

    public final int matricola;
    public final String cognome;
    public final String nome;
}    

// ------------------ Interfaccia Set: non modificare !!----------------

interface Set  // non modificare!!
{
    boolean isEmpty(); // true: contenitore vuoto; false: contenitore non vuoto

    int size();       // restituisce il n. di elementi presenti nel contenitore

    /*
     Inserisce l'oggetto obj nell'insieme se non e` gia` presente, altrimenti 
     fallisce silenziosamente.
    */
    void add(Comparable obj);

    /*
     Rimuove l'oggetto obj dall'insieme se e` presente, altrimenti fallisce
     silenziosamente.
    */
    void remove(Comparable obj);

   /*
    Restituisce true se e solo se l'oggetto comparabile obj appartiene  
    all'insieme. 
    */
    boolean contains(Comparable obj);

    /*
     Restituisce un array (pieno) di oggetti comparabili, contenente i 
     riferimenti a tutti gli elementi presenti nell'insieme
    */
    Comparable[] toArray();

    /*
     Riceve un riferimento ad un altro oggetto di Set e restituisce un nuovo
     riferimento Set contenente tutti gli elementi che appartengono alla
     intersezione (in senso insiemistico) dei due insiemi ricevuti come 
     parametro implicito e esplicito (cioe` l'insieme this e l'insieme s)
    */
    Set intersection(Set s);

    /*
     Riceve un riferimento ad un altro oggetto di Set e restituisce un nuovo
     riferimento Set contenente tutti gli elementi che appartengono alla
     unione (in senso insiemistico) dei due insiemi ricevuti come parametro
     implicito e esplicito (cioe` l'insieme this e l'insieme s)
    */
    Set union(Set s);
}