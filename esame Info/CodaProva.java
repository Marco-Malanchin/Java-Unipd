 public class CodaProva{
    public static void main(String[] args){
        QueueArray pippo = new QueueArray();
        pippo.enqueue(10);
        pippo.enqueue(9);
        pippo.enqueue(8);
        pippo.enqueue(7);
        while(!pippo.isEmpty()){
            System.out.println(pippo.dequeue());
        }
    }
}
interface Container{
    void makeEmpty();
    boolean isEmpty();
}
interface Queue extends Container{
    void enqueue(Object e);
    Object getFront();
    Object dequeue();
}
class QueueArray implements Queue{
    protected Object[] v;
    protected int back, front;
    public QueueArray(){
        v = new Object[2];
        makeEmpty();
    }
    public void makeEmpty(){
        back = front = 0;
    }
    public boolean isEmpty(){
        return (back == front);
    }
    protected Object[] resize(Object[] e, int l){
        if(l < e.length){
            throw new IllegalArgumentException();
        }
        Object[] temp = new Object[l];
        System.arraycopy(e, 0, temp, 0, e.length);
        return temp;
    }
    protected int increment(int index){//O(1)
        return (index + 1) % v.length;
    }
    public void enqueue(Object e){//O(1)
        if(increment(back) == front){
            v = resize(v, v.length * 2);
            if(back < front){
                System.arraycopy(v,0,v,v.length/2, back);
                back += v.length/2;
            }
        }
        v[back] = e;
        back = increment(back);
    }
    public Object getFront(){//O(1)
        if(isEmpty()){
            throw new EmptyQueueException();
        }
        return v[front];
    }
    public Object dequeue(){//O(1)
        Object temp = getFront();
        front =increment(front);
        return temp;
    }
}
class IllegalArgumentException extends RuntimeException{}
class EmptyQueueException extends RuntimeException{}