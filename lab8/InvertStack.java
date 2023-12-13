import java.util.Scanner;
import java.lang.NumberFormatException;

public class InvertStack{
    public static void main(String[] args){
        System.out.println("Inserisci numeri i quali vuoi invertire, per interrompere il programma manda a capo una riga vuota");
        boolean controllo = true;
        Scanner scan = new Scanner(System.in);
        StackX numeri = new StackX();
        StackX numeriNonInvertiti = new StackX();
        String riga = "";
        while(controllo = true){
            riga = scan.nextLine();
            if(riga == ""){
                        controllo = false;
                        break;
            }
            Scanner scan2 = new Scanner(riga);
             scan2.useDelimiter(" ");
            int temp = 0;
            while(scan2.hasNext()){
                try{
                    String parola = scan2.next();
                    temp = Integer.valueOf(parola);
                    numeri.push(temp);
                    numeriNonInvertiti.push(temp);
                }
                catch(NumberFormatException e){
                    System.out.println("valore inserito in maniera errata!!!");
                    break;
                }
            }
            scan2.close();
        }
         System.out.println("Stack prima di  essere invertito:");
        while(!numeriNonInvertiti.isEmpty()){
        System.out.println(numeriNonInvertiti.pop());
        }
        StackX.inverti(numeri);
        System.out.println("\nStack dopo essere stato invertito:");
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
interface Stack extends  Container{
    void push(int i);
    int top();
    int pop();    
}
class StackX implements Stack{
    private int[] v;
    private int vSize;
    public StackX(){
        v = new int[100];
        makeEmpty();
    }
    public boolean isEmpty(){
        return (vSize == 0);
    }
    public void makeEmpty(){
        vSize = 0;
    }
    public void push(int x){
        if(vSize == v.length){
             v = resize(v, 2*v.length);
        }
        v[vSize++] = x;
    }
    public int top(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return v[vSize - 1];
    }
    public int pop(){
         if(isEmpty()){
            throw new EmptyStackException();
        }
        int temp = top();
        vSize--;
        return temp;
    }
    public int[] resize(int[] v, int i ){
        int[] temp = new int[i];
        System.arraycopy(v, 0, temp, 0, v.length);
        return temp;
    }
    public static void inverti(StackX pippo){
        StackX temp = new StackX();
        StackX temp2 = new StackX();
        while(!pippo.isEmpty()){
            temp.push(pippo.pop());
        }
        while(!temp.isEmpty()){
            temp2.push(temp.pop());
        }
        while(!temp2.isEmpty()){
            pippo.push(temp2.pop());
        }
    }
}
class EmptyStackException extends RuntimeException{}