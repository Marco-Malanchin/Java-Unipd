import java.util.Scanner;
import java.lang.NumberFormatException;

public class DeleteDuplicate{
    public static void  main(String[] args){
        System.out.println("Inserisci numeri i quali vuoi invertire, per interrompere il programma manda a capo una riga vuota");
        boolean controllo = true;
        Scanner scan = new Scanner(System.in);
        StackX numeri = new StackX();
        StackX numeriConDoppi = new StackX();
        String riga = "";
        while(controllo = true){
            riga = scan.nextLine();
            if(riga == ""){
                        controllo = false;
                        break;
            }
            Scanner scan2 = new Scanner(riga);
             scan2.useDelimiter(" ");
            Integer temp;
            while(scan2.hasNext()){
                try{
                    String parola = scan2.next();
                    temp = Integer.valueOf(parola);
                    numeri.push(temp);
                    numeriConDoppi.push(temp);
                }
                catch(NumberFormatException e){
                    System.out.println("valore inserito in maniera errata!!!");
                    break;
                }
            } 
            scan2.close();
        }
         System.out.println("Stack con duplicati:");
        while(!numeriConDoppi.isEmpty()){
        System.out.println(numeriConDoppi.pop());
        }
        StackX.duplicate(numeri);
        System.out.println("\nStack senza duplicati:");
        while(!numeri.isEmpty()){
        System.out.println(numeri.pop());
        }
        scan.close();
    }
}
interface Container{
    void makeEmpty();
    boolean isEmpty();
}
interface Stack extends Container{
    void push(Object e);
    Object pop();
    Object top();
}
class StackX implements Stack{
    Object[] v;
    int vSize;
    public StackX(){
        v = new Object[100];
        makeEmpty();
    }
    public void makeEmpty(){
        vSize = 0;
    }
    public boolean isEmpty(){
        return (vSize == 0);
    }
    public Object[] resize(Object[] v, int x){
        Object[] temp = new Object[x];
        System.arraycopy(v, 0, temp, 0, v.length);
        return temp;
    }
    public void push(Object e){
        if(vSize == v.length){
            v = resize(v, 2*v.length);
        }
        v[vSize++] = e;
    }
    public Object top(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return v[vSize - 1];
    }
    public Object pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        Object temp = top();
        vSize--;
        return temp;
    }
    public boolean contains(Object e){
        for(int i = 0; i < v.length; i++){
            if (v[i] == e){
                  return true;
            }
        }
        return false;
    }
    public static void duplicate(StackX pippo){
        StackX temp = new StackX();
        while(!pippo.isEmpty()){
            Object numero = pippo.pop();
            if(!temp.contains(numero)){
                temp.push(numero);
            }
        }
        while(!temp.isEmpty()){
            pippo.push(temp.pop());
        }
    }
}
class EmptyStackException extends RuntimeException{}