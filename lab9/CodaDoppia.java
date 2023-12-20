public class CodaDoppia{
    public static void main(String[] args){

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
    int front;
    int back;
    int counter;
    public ArrayQueue(){
        v = new Object[100];
        makeEmpty();
    }
    public int size(){
        return counter;
    }
    public void makeEmpty(){
        counter = 0;
    }
    public boolean isEmpty(){
        return (size() == 0);
    }
    public void addFirst(Object e){
        if(size() == v.length){
            resize(v, v.length * 2);
        }
        
    }
}
class EmptyCDException extends RuntimeException{}