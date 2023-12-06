java.util.*
public class Malanchin123456 // sostituire con il nome opportuno
{
    public static void main(String[] args)
    { 
        if(args.length == 0){
            throw new IllegalArgumentException();
        }
        int nPile = Integer.parseInt(args[0]);
        MyMultistack p = new MyMultiStack(nPile);
        for(int i = 1; i< args.length; i++){
            p.add(args[i], nPile -1);
        }
        Scanner c = new Scanner(System.in);
        while(c.hasNextLine()){
            Scanner riga = new Scanner(c.nextLine());
            while(riga.hasNext()){
                p.add(riga.next());
            }
        }
        p.remove();
        p.remove();
        System.out.println(p);
    }
}

interface MultiStack extends Container
{

//restituisce la dimensione della pila di indice i, cioe' il numero di elementi //contenuti nella pila di indice i;lancia IllegalArgumentException se il valore di //i non e' corretto;
    int dim(int i);
    
//aggiunge x nella pila di indice i della multipila
//richiede x!= null; lancia IllegalArgumentException se il valore di i non e' corretto;
    void add(Object x, int i);

//aggiunge x nella pila della multipila che contiene il minor numero di elementi
//richiede x!= null;
    void add(Object x);

//viene eliminato il dato dalla pila che contiene il maggior numero di elementi;
//richiede che la multipila non sia vuota
    void remove();
}

class MyMultiStack implements MultiStack
{
    private Stack[] v;
    
    public MyMultiStack(int n){
        if(n < 2){
            throw new IllegalArgumentException();
        }
        v = new Stack[n];
        for(int i = 0; i < v.length; i++){
            v[i] = new ArrayStack();
        }
    }
    //restituisce la dimensione della pila di indice i, cioe' il numero di elementi //contenuti nella pila di indice i;lancia IllegalArgumentException se il valore di //i non e' corretto;
    public int dim(int i){
        if(i < 0 || i >= v.length){
            throw new IllegalArgumentException();
        }
        Stack temp = new ArrayStack();
        int count = 0;
        while(!v[i].isEmpty()){
            temp.push(v[i].pop());
            count++;
        }
        v[i] = temp;
        return count;
    }
    
//aggiunge x nella pila di indice i della multipila
//richiede x!= null; lancia IllegalArgumentException se il valore di i non e' corretto;
    public void add(Object x, int i){
        if(x == null || i < 0 || i >= v.length){
            throw new IllegalArgumentException();
        }
        v[i].push(x);
    }

//aggiunge x nella pila della multipila che contiene il minor numero di elementi
//richiede x!= null;
    public void add(Object x){
        if(x == null){
            throw new IllegalArgumentException();
        }
        int iMin = 0;
        for(int i = 0; i < v.length; i++){
            if(dim(iMin) > dim(i)){
                iMin = i;
            }
            v[iMin].push(x);
        }
    }

//viene eliminato il dato dalla pila che contiene il maggior numero di elementi;
//richiede che la multipila non sia vuota
    public void remove(){
        if(isEmpty()){
            throw new EmptyMultiStackException();
        }
        int iMax = 0;
        for(int i = 1; i < v.length; i++){
            if(dim(iMax) < dim(i)){
                iMax = i;
            }
        }
        v[iMax].pop();
    }
    /*
    verifica se il contenitore e' vuoto
    restituisce true se il contenitore e' vuoto, false altrimenti
  */
  public boolean isEmpty(){
      
      for(int i = 0; i< v.length; i++){
          if(!v[i].isEmpty()){
              return false;
          }
      }
      return true;
  }

  /*
    rende vuoto il contenitore
  */
  public void makeEmpty(){
      for(int i = 0; i< v.length; i++){
          v[i].makeEmpty();
      }
  }
// questa classe non puo' avere variabili statiche;
    public String toString(){
        String count = "";
        for(i = 0; i < )
    }
}
interface Container
{
  /*
    verifica se il contenitore e' vuoto
    restituisce true se il contenitore e' vuoto, false altrimenti
  */
  boolean isEmpty();

  /*
    rende vuoto il contenitore
  */
  void makeEmpty();
}
interface Stack extends Container
{  void push(Object obj);
   Object pop();
   Object top();
}
class EmptyStackException extends RuntimeException
{}
class ArrayStack implements Stack
{  protected Object[] v;
   protected int vSize;
   public ArrayStack()
   {  v = new Object[100];
      makeEmpty();
   }
   public void makeEmpty()
   {  vSize = 0;
   }
   public boolean isEmpty()
   {  return (vSize == 0);
   }
   public void push(Object obj)
   {  if (vSize == v.length)
         v = resize(v, 2*vSize);
      v[vSize++] = obj;
   }
   public Object top()
   {  if (isEmpty())
         throw new EmptyStackException();
      return v[vSize - 1];
   }
   public Object pop()
   {  Object obj = top();
      vSize--;
      return obj;
   }
   protected Object[] resize(Object[] oldArray, int newLength)
   {  if (newLength < oldArray.length)
         throw new IllegalArgumentException();
      Object[] newArray = new Object[newLength];
      System.arraycopy(oldArray, 0, newArray, 0, oldArray.length);
      return newArray;
   }
}
class EmptyMultiStackException extends RuntimeException
{}

