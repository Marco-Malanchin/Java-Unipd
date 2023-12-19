import java.util.Scanner;
public class RipetizioniCoda{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        ArrayQueue numeri = new ArrayQueue();
        ArrayQueue numeriDuplicazione = new ArrayQueue();
        System.out.println("Inserisci i numeri che vuoi mettere dentro alla pila. \nQuando vuoi terminare l'inserimento lascia la linea vuota e premi invio");
		boolean controllo1 = false;
        while(!controllo1){
            String riga = scan.nextLine();
            if(riga == ""){
                controllo1 = true;
                break;
            }
            Scanner line = new Scanner(riga);
            while(line.hasNext()){
                String parola = line.next();
                try{
                    Integer numero = Integer.valueOf(parola);
                    numeri.enqueue(numero);
                    numeriDuplicazione.enqueue(numero);
                }
                catch(NumberFormatException e){
                    System.out.println("Inserisci solo numeri interi");
                }
            }
            line.close();
        }
        scan.close();
        System.out.println("Numeri prima del controllo");
        while(!numeriDuplicazione.isEmpty()){
            System.out.println(numeriDuplicazione.dequeue());
        }
        System.out.println("\nNumeri dopo il controllo");
        ArrayQueue.deleteDuplicate(numeri);
        while(!numeri.isEmpty()){
            System.out.println(numeri.dequeue());
        }
    }
}
interface Container{
    boolean isEmpty();
    void makeEmpty();
}
interface Queue extends Container{
    void enqueue(Object e);
    Object getFront();
    Object dequeue();
}
class ArrayQueue implements Queue{
    Object[] v;
    int front, back;
    public ArrayQueue(){
        v = new Object[100];
        makeEmpty();
    }
    public void makeEmpty(){
        front = back = 0; 
    }
    public boolean isEmpty(){
        return(back == front);
    }
    protected int increment(int index){
        return (index + 1) % v.length;
    }
    protected Object[] resize(Object[] v, int l){
        if(l < v.length){
            throw new IllegalArgumentException();
        }
        Object[] temp = new Object[l];
        System.arraycopy(v,0, temp, 0, v.length );
        return temp;
    }
    public void enqueue(Object e){
        if(increment(back) == front){
            v = resize(v, 2*v.length);
            if(back < front) {  
                System.arraycopy(v, 0, v, v.length/2, back);
                back += v.length/2;
            }
        }
        v[back] = e;
        back = increment(back);
    }
    public Object getFront(){
        if(isEmpty()){
            throw new EmptyQueueException();
        }
        return v[front];
    }
    public Object dequeue(){
        Object e = getFront();
        front = increment(front);
        return e;
    }
    public static void deleteDuplicate(ArrayQueue e){
        e.enqueue(null);
        int count = -1;
        Object temp;
        do{
            temp = e.dequeue();
            e.enqueue(temp);
            count++;
        }while(temp != null);
        while(count > 0){
            temp = e.dequeue();
            count--;
            for(int i = count; i > 0; i--){
                Object temp2 = e.dequeue();
                if(temp.equals(temp2)){
                    count--;
                }
                else{
                    e.enqueue(temp2);
                }
            }
            e.enqueue(temp);
            do{
                temp = e.dequeue();
                e.enqueue(temp);
            }while(temp != null);
        }
        while (true){  
            temp =e.dequeue();
            if (temp == null){
                break;
            }
            e.enqueue(temp);
      }
    }
}
class EmptyQueueException extends RuntimeException{}
class IllegalArgumentException extends RuntimeException{}