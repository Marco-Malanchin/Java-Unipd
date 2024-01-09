public class InsiemeProva{
    public static void main(String[] args){

    }
}

interface Container{
    void makeEmpty();
    boolean isEmpty();
}
interface Set extends Container{
    void add(Object e);
    boolean contains(Object e);
    Object[] toArray();
}

class ArraySet implements Set{
    private Object[] v;
    private int vSize;
    public ArraySet(){
        v = new Object[10];
        makeEmpty();
    }
    public void makeEmpty(){
        vSize = 0;
    }
    public boolean isEmpty(){
        return (vSize == 0);
    }
    public Object[] toArray(){
        Object[] temp = new Object[vSize];
        System.arraycopy(v, 0 , temp, 0, vSize);
        return temp;
    }
     public Object[] resize(Object[] e, int l){
        if( l < e.length){
            throw new IllegalArgumentException();
        }
        Object[] temp = new Object[l];
        System.arraycopy(v, 0 , temp, 0, e.length);
        return temp;
     }
     public boolean contains(Object e){
        if(isEmpty()){
            throw new EmptySetException();
        }
        for(int i = 0; i < vSize; i++){
            if(v[i].equals(e)){
                return true;
            }
        }
        return false;
     }
     public void add(Object e){
        if(contains(e) == true){
            return;
        }
        if (vSize == v.length){
            v = resize(v, 2 * vSize);
        }
        v[vSize++] = e;
     }
    public static Set union(Set s1, Set s2){
        Set temp = new ArraySet();
        Object[] v  = s1.toArray();
        for(int i = 0; i< v.length; i++){//Inserisco gli elementi del primo insieme
            temp.add(v[i]);
        }
        v = s2.toArray();
        for(int i = 0; i< v.length; i++){//Inserisco gli elementi del secondo insieme, non ci sono duplicati perche' add non consente di aggiunger elementi duplicati
            temp.add(v[i]);
        }
        return temp;
    }
    public static Set intersection(Set s1, Set s2){
        Set temp = new ArraySet();
        Object[] v = s1.toArray();
        for(int i = 0; i < v.length; i++){
            if(s2.contains(v[i])){
                temp.add(v[i]);
            }
        }
        return temp;
    }
    public static Set subtract(Set s1, Set s2){
        Set temp = new ArraySet();
        Object[] v = s1.toArray();
        for(int i  = 0; i < v.length; i++){
            if(!s2.contains(v[i])){
                temp.add(v[i]);
            }
        }
        return temp;
    }
}
class IllegalArgumentException extends RuntimeException{}
class EmptySetException extends RuntimeException{}