public class SortedSet{
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
public interface SortedSet extends Set{
    void add(Comparable obj);
    Comparable[] toSortedArray();
}

class InsiemeOrdinato implements SortedSet{
    private Comparable[] v;
    private int vSize;
    public InsiemeOrdinato(){
        v = new Comparable[5];
        makeEmpty();
    }
    public void makeEmpty(){
        vSize == 0;
    }
    public boolean isEmpty(){
        return (vSize == 0);
    }
    private void resize(Comparable[] e, int l){
        Comparable[] temp = new Comparable[l];
        System.arraycopy(e, 0, temp, 0, e.length):
        e = temp;
    }
    public boolean contains(Comparable e, int start, int end){
        if(start > end){
            return false;
        }
        int mid = (start + end) / 2;
        Comparable middle = v[mid];
        if(middle.equals(e)){
            return true;
        }
        if(middle.compareTo(e ) < 0){
            return contains(e, mid + 1, end);
        }
        else{
            return contains(e, start, mid - 1);
        }
    }
    public void add(Object x)
 { throw new IllegalArgumentException(); }

    public void add(Comparable e){
        if(contains(e, 0, vSize)){
            return
        }
        if(vSize == v.length){
            resize(v, v.length * 2);
        }
        v[vSize++] = e;
        for(int i = 0; i < vSize; i++){
            Comparable temp = v[i];
            int j;
            for(j = i; j > 0 && (temp.compareTo(v[j-1] ) < 0); j--){
                v[j] = v[j -1];
            }
            v[j] = 0;
        }
    }
    public Comparable[] toSortedArray(){ // O(n)
        Comparable[] x = new Comparable[vSize];
        System.arraycopy(v, 0, x, 0, vSize);
        return x; 
    }
    public Object[] toArray(){
        return toSortedArray();
    }
    public static SortedSet union(SortedSet s1,SortedSet s2)
{ SortedSet x = new ArraySortedSet();
    Comparable[] v1 = s1.toSortedArray();
    Comparable[] v2 = s2.toSortedArray();
    int i = 0, j = 0;
    while (i < v1.length && j < v2.length){
        if (v1[i].compareTo(v2[j]) < 0){
            x.add(v1[i++]);
        }
        else if (v1[i].compareTo(v2[j]) > 0){
            x.add(v2[j++]);
        }
        else // sono uguali
        { x.add(v1[i++]);
            j++;
        }
    }    
    while (i < v1.length){
        x.add(v1[i++]);
    }
    while (j < v2.length){
         x.add(v2[j++]);
    }
    return x;
} // prestazioni O(n log n) anziché quadratiche

public static SortedSet intersection(ArraySortedSet s1,ArraySortedSet s2)
{ 
    SortedSet x = new ArraySortedSet();
    Comparable[] v1 = s1.toSortedArray();
    Comparable[] v2 = s2.toSortedArray();
    for (int i = 0, j = 0; i < v1.length; i++)
    { while (j < v2.length && v1[i].compareTo(v2[j]) > 0){
            j++;
        }
        if (j == v2.length){
                break;
        }
        if (v1[i].compareTo(v2[j]) == 0){
            x.add(v1[i]); j++;
        }
    }
 return x;
} // prestazioni O(n log n) anziché quadratiche
public static SortedSet subtract(ArraySortedSet s1,ArraySortedSet s2)
{ SortedSet x = new ArraySortedSet();
    Comparable[] v1 = s1.toSortedArray();
    Comparable[] v2 = s2.toSortedArray();
    int i;
    for (i = 0, j = 0; i < v1.length; i++)
    { while (j < v2.length && v1[i].compareTo(v2[j]) > 0){
         j++;
        }
        if (j == v2.length){
             break;
        }
         if (v1[i].compareTo(v2[j]) != 0){
            x.add(v1[i]);
         }
 }
 while (i < v1.length) {
    x.add(v[i++]);
 }
 return x;
} // prestazioni O(n log n) anziché quadratiche
}