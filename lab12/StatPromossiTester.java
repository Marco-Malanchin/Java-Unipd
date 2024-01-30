// nome e cognome del candidato, matricola, data,       numero postazione
// ..............                ......     ../../....  ADT..
import java.io.*;
import java.util.Scanner;
// -------------- classe StatPromossiTester: da completare -----------------
public class StatPromossiTester
{
    public static void main(String[] args)
    {
        // ....... da completare ............
        Scanner scan1 = new Scanner(System.in);
        String input1 = scan1.nextLine();
        String input2 = scan1.nextLine();
        scan1.close();
        Studenti totaliFondamenti = new Studenti();
        Studenti passatiFondamenti = new Studenti();
        Studenti totaliAnalisi = new Studenti();
        Studenti passatiAnalisi = new Studenti();
        Scanner scan2 = null;
        try{
             scan2 = new Scanner(new FileReader (input1));
        }
        catch(FileNotFoundException e){
            System.out.println("Errore apertura file");
        }
        while(scan2.hasNextLine()){
            String linea = scan2.nextLine();
            Scanner scan3  = new Scanner(linea);
            scan3.useDelimiter("[\\p{javaWhitespace};]+");
            while(scan3.hasNext()){
                int matricola = Integer.valueOf(scan3.next());
                String cognome = scan3.next();
                String nome = scan3.next();
                String promosso = "";
                if(scan3.hasNext()){
                    promosso = scan3.next();
                }
                Studente temp = new Studente(matricola, cognome, nome);
                totaliFondamenti.add(temp);
                if(promosso.equals("P")){
                    passatiFondamenti.add(temp);
                }
            }
            scan3.close();
        }
        scan2.close();
        Scanner scan4 = null;
        try{
             scan4 = new Scanner(new FileReader (input2));
        }
        catch(FileNotFoundException e){
            System.out.println("Errore apertura file");
        }
        while(scan4.hasNextLine()){
            String linea = scan4.nextLine();
            Scanner scan5  = new Scanner(linea);
            scan5.useDelimiter("[\\p{javaWhitespace};]+");
            while(scan5.hasNext()){
                int matricola = Integer.valueOf(scan5.next());
                String cognome = scan5.next();
                String nome = scan5.next();
                String promosso = "";
                if(scan5.hasNext()){
                    promosso = scan5.next();
                }
                Studente temp = new Studente(matricola, cognome, nome);
                totaliAnalisi.add(temp);
                if(promosso.equals("P")){
                    passatiAnalisi.add(temp);
                }
            }
            scan5.close();
        }
        scan4.close();
        double numeroTotFondamenti = (double)totaliFondamenti.size();
        double numeroPassatiFondamenti =(double) passatiFondamenti.size();
        double numeroTotAnalisi = (double) totaliAnalisi.size();
        double numeroPassatiAnalisi = (double) passatiAnalisi.size();
        double percentualePassatiAnalisi = (numeroPassatiAnalisi/numeroTotAnalisi) * 100;
        double percentualePassatiFondamenti = (numeroPassatiFondamenti/numeroTotFondamenti) * 100;
        Studenti passatiEntrambi =(Studenti) passatiFondamenti.intersection(passatiAnalisi);
        Studenti totali = (Studenti) totaliAnalisi.union(totaliFondamenti);
        double numeroPassatiEntrami = (double) passatiEntrambi.size();
        double numeroTotali = (double) totali.size();
        double percentualePassatiEntrambi = (numeroPassatiEntrami/numeroTotali) * 100;
        Studenti passatiAlmenoUno = (Studenti) passatiFondamenti.union(passatiAnalisi);
        double numeroPassatiAlmenoUno = (double) passatiAlmenoUno.size();
        double percentualePassatiAlmenoUno =  (numeroPassatiAlmenoUno/numeroTotali) * 100;
        System.out.println("Studenti passati ad analisi: " + percentualePassatiAnalisi + "%\n" + "Studenti passati ad fondamenti: " + percentualePassatiFondamenti + "%\n" + "Studenti passati ad almeno uno: " + percentualePassatiAlmenoUno + "%\n" +  "Studenti passati entrambi: " + percentualePassatiEntrambi + "%\n");
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
    //campi di esemplare ..... da completare ......
    // ...
    private Studente[] v;
    private int vSize;
    //costruttori e metodi pubblici di Studenti .....da completare.....
    // ...
    public Studenti(){
        v = new Studente[20];
        vSize = 0;
    }
    public int size(){
        return vSize;
    }
    public boolean isEmpty(){
        return (vSize == 0);
    }
    public boolean contains(Comparable obj){
        if( binarySearch(0, vSize - 1, obj) != -1){
            return true;
        }
        return false;
    }
    private int binarySearch(int start, int end, Comparable obj){
        if(start > end){
            return -1;
        }
        int mid = (start + end)/2;
        Studente middle = v[mid];
        if(middle.compareTo(obj) == 0){
            return mid;
        }
        else if(middle.compareTo(obj) < 0){
            return binarySearch(mid + 1, end, obj);
        }
        else{
            return binarySearch(0, mid - 1, obj);
        }
    }
    public void add(Comparable obj){
        if(contains(obj)){
            return;
        }
        if(vSize == v.length){
            resize();
        }
        v[vSize++] = (Studente)obj;
        for(int i = 0; i < vSize; i++){
            Studente temp = v[i];
            int j;
            for(j = i; j > 0 && (temp.compareTo(v[j-1]) < 0); j--){
                v[j] = v[j-1];
            }
            v[j] = temp;
        }
    }
    private void resize(){
        Studente[] temp = new Studente[2 * v.length];
        System.arraycopy(v, 0, temp, 0, vSize);
        v = temp;
    }
    public void remove(Comparable obj){
        if(contains(obj)){
            int temp = binarySearch(0,vSize, obj);
            vSize--;
            for(int i = temp; i < vSize; i++){
                v[i] = v[i +1];
            }       
        }
        else{
            return;
        }
    }
    public Comparable[] toArray(){
        Comparable[] temp = new Comparable[vSize];
        System.arraycopy(v, 0, temp, 0, vSize);
        return temp;
    }
    //metodo toString ..... da completare secondo specifiche del compito ......
    public String toString()
    {
        String s = "";
        for(int i = 0; i < vSize; i++){
            s += v[i].toString() + "\n";
        }
        return s;
    }          
    public Set union(Set s){
        Studenti ss = (Studenti)s;
        Studente[] s1 = this.v;
        Studente[] s2 = ss.v;
        Studenti union = new Studenti(); //union deve essere di tipo Studenti
        union.v = new Studente[this.size() + ss.size()];
        int bi = 0; int ci = 0;
        while(bi < this.size() && ci < ss.size()){
            if((s1[bi]).compareTo(s2[ci]) < 0){
                union.v[union.vSize++] = s1[bi++];
            }
            else if(s1[bi].compareTo(s2[ci]) > 0){
                union.v[union.vSize++] = s2[ci++];
            }
            else{
                union.v[union.vSize++] = s1[bi++];
                ci++;
            }
        }
        while(bi <this.size()){
            union.v[union.vSize++] = s1[bi++];
        }
        while(ci < ss.size()){
            union.v[union.vSize++] = s2[ci++];
        }
        return union;
    }
    public Set intersection(Set s){
        Set inters = new Studenti();
        for (int i = 0; i < vSize; i++)
            if (s.contains(v[i])){
                inters.add(v[i]);  // //inseriamo solo elementi che appartengono anche a s
            } 
        return inters; 
     }
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