public class StackProva{
    public static void main(String[] args){
        StackArray pippo = new StackArray();
        pippo.push(1);
        pippo.push(2);
        pippo.push(3);
        pippo.push(4);
        while(!pippo.isEmpty()){
            System.out.println(pippo.pop());
        }
    }
}
interface Container{
     boolean isEmpty();
     void makeEmpty();
}
interface Stack extends Container{
     void push(Object e);
     Object top();
     Object pop();
}

class StackArray implements Stack{
    protected Object[]v;
    protected int vSize;
    public StackArray(){
        v = new Object[100];
        makeEmpty();
    }
    protected static Object[] resize(Object[] v, int l){
        if(l < v.length){
            throw new IllegalArgumentException();
        }
        Object[] temp = new Object[l];
        System.arraycopy(v, 0, temp, 0, v.length);
        return temp;
    }
    public void makeEmpty(){
        vSize = 0;
    }
    public boolean isEmpty(){
        return(vSize == 0);
    }
    public void push(Object e){
        if(vSize == v.length){
            v = resize(v, 2* v.length);
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
        Object temp = top();
        vSize--;
        return temp;
    }
}
class EmptyStackException extends RuntimeException{}
class IllegalArgumentException extends RuntimeException{}