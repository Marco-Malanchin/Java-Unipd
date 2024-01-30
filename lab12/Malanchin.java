public class Malanchin{
  public static void main(String[] args){
    if(args.length <= 0){
        throw new IllegalArgumentException();
    }
    int size = 0;
    try{
        size = Integer.parseInt(args[0]);
    }
    catch(NumberFormatException e){
        System.out.println("Inserisci un valore di lunghezza valido");
    }
    QM q = new QM(size);
    int argsSize = 1;
	int rango = 0;
	while(argsSize < args.length){
		q.enqueue(args[argsSize++], rango);
		rango = (rango+1)%size;
	}
    q.dequeue(0);
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
        back = front = 0;
    }
    
    public boolean isEmpty(){
        return (back == front);
    }
  
    public int size(){
        return back - front;
    }
    private void resize(){
        Comparable[] temp = new Comparable[2 * v.length];
        System.arraycopy(v, 0, temp, 0, v.length);
        v = temp;
    }
   public void enqueue(Comparable x){
        if(back == v.length){
            resize();
        }
        v[back++] = x;
   }

   public Object dequeue() throws EmptyQueueException{
        if(isEmpty()){
            throw new EmptyQueueException();
        }
        return v[front++];
   }
   public String toString() {
        String s = "";
        for(int i = back-1; i >= front; i--){
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
    public Q[] a;//tutto cio' che serve
    public final int length; //rappresenta il numero di code contenute nella coda multipla

     public QM(int n) {
        if(!(n >= 2)){
            throw new IllegalArgumentException();
        }
        a = new Q[n];
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