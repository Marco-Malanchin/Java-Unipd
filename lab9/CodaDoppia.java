import java.util.Scanner;

public class CodaDoppia{
    public static void main(String[] args){
        ArrayQueue pippo = new ArrayQueue();
        ArrayQueue pippo2 = new ArrayQueue();
        ArrayQueue pippo3 = new ArrayQueue();
        Scanner scan = new Scanner(System.in);
        System.out.println("Inserisci tutti i numeri che vuoi, per terminare premi CTRL + Z");
        while(scan.hasNextLine()){
            String riga = scan.nextLine();
            Scanner line = new Scanner(riga);
            while(line.hasNext()){
                String parola = line.next();
                try{
                    Integer numero = Integer.valueOf(parola);
                    pippo.addLast(numero);
                }
                catch(NumberFormatException e){
                    System.out.println("Inserisci solo numeri interi");
                }
            }
        }
        while(!pippo.isEmpty()){
            pippo2.addFirst(pippo.removeLast());
        }
         while(!pippo2.isEmpty()){
            pippo3.addLast(pippo2.removeFirst());
        }
        while(!pippo3.isEmpty()){
            System.out.println(pippo3.removeFirst());
        }
    }
}
interface Container{
    void makeEmpty();
    boolean isEmpty();
}
interface CD extends Container{
  int size();
  boolean isEmpty();
  void addFirst (Object x);
  void addLast (Object x);
  Object removeFirst () throws EmptyCDException;
  Object removeLast () throws EmptyCDException;
  Object getFirst () throws EmptyCDException;
  Object getLast ()  throws EmptyCDException;
}
class ArrayQueue implements CD{
    Object[] v;
    int first;
    int last;
    int counter;
    public ArrayQueue(){
        v = new Object[4];
        makeEmpty();
    }
    public int size(){
        return counter;
    }
    public void makeEmpty(){
        counter = 0;
        first = 0;
        last = first;
    }
    public boolean isEmpty(){
        return (size() == 0);
    }
    protected int incrementFirst(int first){
        return ((first - 1 +v.length) % v.length);
    }
     protected int incrementLast(int last){
        return (last + 1);
    }
     protected Object[] resize(Object[] e, int l){
        if(l < e.length){
            throw new IllegalArgumentException();
        }
        Object[] temp = new Object[l];
        System.arraycopy(e, 0, temp, 0, e.length);
        return temp;
    }
    public void addFirst(Object e){
        if((size()+1) == v.length){
            int quantita = v.length - first - 1;
            v =  resize(v, v.length * 2);
            System.arraycopy(v,first+1, v,(v.length-quantita), quantita);
            first = v.length-quantita - 1;
        }
         v[first] = e;
        first = incrementFirst(first);
        counter++;
    }
     public Object getFirst( ){
        if(isEmpty()){
            throw new EmptyCDException();
        }
        if(first + 1 == v.length){
            return v[0];
        }
        return(v[first + 1]);
     }
     public Object removeFirst(){
        Object temp = getFirst();
        if(first + 1  == v.length){
            first = 0;
            counter--;
            return temp;
        }
        first++;
        counter--;
        return temp;
     }
     public void addLast(Object e){
        if(last == 0){
           last = incrementLast(last);
        }
        if((size()+1) == v.length){
            if(first == v.length){
                first  = -1;
                v =  resize(v, v.length * 2);
                System.arraycopy(v,first+1, v,(v.length-1), 1);
                first = v.length -2;
            }
            if(first == 0){
                v =  resize(v, v.length * 2);
            }
            else{
                int quantita = v.length - first - 1;
                v =  resize(v, v.length * 2);
                System.arraycopy(v,first+1, v,(v.length-quantita), quantita);
                first = v.length-quantita - 1;
            }
        }
         v[last] = e;
        last = incrementLast(last);
        counter++;
    }
    public Object getLast( ){
        if(isEmpty()){
            throw new EmptyCDException();
        }
        if(last == 0){
            return v[0];
        }
        return(v[last - 1]);
     }
      public Object removeLast(){
        Object temp = getLast();
        if(last == 0){
            last = v.length;
            v =  resize(v, v.length * 2);
            counter--;
            return temp;
        }
        last--;
        counter--;
        return temp;
     }
}
class EmptyCDException extends RuntimeException{}
class IllegalArgumentException extends RuntimeException{}