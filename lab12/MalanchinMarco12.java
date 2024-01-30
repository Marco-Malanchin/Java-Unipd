import java.util.Scanner;
public class MalanchinMarco12{
  public static void main(String[] args){
    if(args.length <= 0){
        throw new IllegalArgumentException();
    }
    int grandezza = 0;
    try{
        grandezza = Integer.valueOf(args[0]);
    }
    catch(NumberFormatException e){
        System.out.println("Inserisci un valore di lunghezza valido");
    }
    QM q = null;
    try{
        q = new QM(grandezza);
    }
    catch(IllegalArgumentException e){
        System.out.println("Inserisci un valore di lunghezza maggiore o uguale a 2");
        System.exit(0);
    }
    int contatore = 0;
    for(int i = 1; i < args.length; i++){
        if(contatore == grandezza){
            contatore = 0;
        }
        q.enqueue(args[i], contatore);
        contatore++;
    }
    System.out.println("Inserisci quante parole vuoi, premi CTRL + Z per terminare il programma");
    Scanner scan = new Scanner(System.in);
    contatore = 0;
    while(scan.hasNextLine()){
        String linea = scan.nextLine();
        Scanner scan2 = new Scanner(linea);
        while(scan2.hasNext()){
            String parola = scan2.next();
            if(contatore == grandezza){
                contatore = 0;
            }
            q.enqueue(parola, contatore);
            contatore++;
        }
        scan2.close();
    }
    scan.close();
    try{
		q.dequeue(0);  ////Per il metodo di inserimento, le code di rango 0 e 1 sono le prime ad avere un elemento
		q.dequeue(1);
	}catch(EmptyQueueException e){
		System.out.println("Impossibile fare due rimozioni. Continuo.");
	}
    System.out.println("Stampo la multicoda intera");
    for(int i = 0; i < grandezza; i++){
        System.out.println(q.toString(i) + "\n");
    }
  }
}


interface CQueue  // --Interfaccia CQueue
{
  
   boolean isEmpty();
  
    int size();
 
   void enqueue(Comparable x);

    Object dequeue() throws EmptyQueueException;
}

//La classe Q realizza l'interfaccia CQueue:

class Q implements CQueue // --Coda di Elementi Comparabili
{
    private Comparable[] v; //tutto cio' che serve
    private int front;
    private int  back;

    public Q(){
        v = new Comparable[10];
        front = back = 0;
    }
    
    public boolean isEmpty(){
        return (front == back);
    }
  
    public int size(){
        return (back - front) - 1;
    }
    private int increment(int index){
        return (index + 1) % v.length;
    }
    private void resize(){
        Comparable[] temp = new Comparable[2 * v.length];
        System.arraycopy(v, 0, temp, 0, v.length);
        v = temp;
    }
   public void enqueue(Comparable x){
        if(increment(back) == v.length){
            resize();
            if(back < front){
                System.arraycopy(v, 0, v, v.length/2, back);
                back += v.length/2; 
            }
        }
        v[back] = x;
        back = increment(back);
   }

   public Object dequeue() throws EmptyQueueException{
        if(isEmpty()){
            throw new EmptyQueueException();
        }
        Object removal = v[front];
        front = increment(front);
        return removal;
   }
   public String toString() {
        String s = "";
        for(int i = back - 1; i >= front; i--){
            s += v[i] + " ";
        }
        return s;
   }
   public Comparable[] toSortedArray() {
        Comparable[] temp = new Comparable[size()];
        System.arraycopy(v,front, temp, 0, size());
        for(int i = 0; i < temp.length - 1; i++){
            int pos = i;
            for(int j = pos + 1; j < temp.length; j++){
                if(temp[j].compareTo(temp[pos]) < 0){
                    pos = j;
                }
            }
            if(pos != i){
                Comparable pippo = temp[i];
                temp[i] = temp[pos];
                temp[pos] = pippo;
            }
        }
        return temp;
    }
}

//La classe QM definisce la Coda Multipla:
 class QM // --Coda Multipla
{
    private Q[] a;//tutto cio' che serve
    public final int length; //rappresenta il numero di code contenute nella coda multipla

     public QM(int n) {
        if(!(n >= 2)){
            throw new IllegalArgumentException();
        }
        a =new Q[n];
        length = n;
        for(int i = 0; i < n; i++){
            a[i] = new Q();
        }
     }

      public void enqueue(Comparable x, int k) {
        if(k >= length){
            throw new java.lang.IndexOutOfBoundsException();
        }
        a[k].enqueue(x);
      }

      public Object dequeue(int k) {
       if(k >= length){
            throw new java.lang.IndexOutOfBoundsException();
        }
        Object temp = a[k].dequeue();
        return temp;
      }

      public String toString(int k) {
        if(k >= length){
            throw new java.lang.IndexOutOfBoundsException();
        }
        String s = a[k].toString();
        return s;
      }

      public Comparable[] toSortedArray() {
        int lunghezzaTot = 0;
        int start = 0;
        for(int i = 0; i < length; i++){
            lunghezzaTot = a[i].size();
        }
        Comparable[] temp = new Comparable[lunghezzaTot];
            for(int i = 0; i < length; i++){
                Comparable[] coda = a[i].toSortedArray();
                System.arraycopy(coda, 0, temp, start, coda.length);
                start +=  coda.length;
            }
            for(int i = 0; i < temp.length - 1; i++){
            int pos = i;
            for(int j = pos + 1; j < temp.length; j++){
                if(temp[j].compareTo(temp[pos]) < 0){
                    pos = j;
                }
            }
            if(pos != i){
                Comparable pippo = temp[i];
                temp[i] = temp[pos];
                temp[pos] = pippo;
            }
        }
        return temp;
    }
}
class EmptyQueueException extends RuntimeException{}