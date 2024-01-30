public class Mappa{
    public static void main(String[] args){
         
    }
}
interface Container{
    void makeEmpty();
    boolean isEmpty();
}
interface Map extends Container{
    Object find(Comparable key);
    void insert(Comparable key, Object e);
    void remove(Comparable key);
}
class MappaArray implements Map{
    private Pair[] v;
    private  int vSize;
    public MappaArray(){
        v = new Pair[10];
        makeEmpty();
    }
    public void makeEmpty(){
        vSize = 0;
    }
    public boolean isEmpty(){
        return (vSize == 0);
    }
    public Object find(Comparable key){
        return v[linearySearch(Comparable key)].getValue();
    }
    private int linearySearch(Comparable key){
        for(int i = 0; i < vSize; i++){
            if(v[i].getKey().equals(key)){
                return i;
            }
        }
        return MapItemNotFound();
    }
    public void  remove(Comparable key){
        v[linearySearch(key)] = v[--vSize]; // mette l'ultimo elemento inserito al posto dell elemento cercato, quando farò un inserimento, l'elemnto inserito per ultimo verrà sovrascritto quindi non ci sarnno problemi.
    }
    public void insert(Comparable key, Object value){
        try{
            remove(key);
        }
        catch(MapItemNotFound e){

        }
        if(vSize == v.length){
            resize();
        }
        v[vSize++] = new Pair(key, value);
    }
    private void resize(){
        Pair[] temp = new Pair[2 * v.length];
        System.arraycopy(v, 0, temp, 0, v.length);
        v = temp;
    }
    private class Pair{
        private Comparable key;
        private Object value;
        public Pair(Comparable key, Object value){
            setkey(key);
            setValue(value);
        }
        public void setKey(Comparable key){
            this.key = key
        }
        public Comparable getKey(){
            return key;
        }
         public void setValue(Object value){
            this.value = value
        }
        public Comparable getValue(){
            return value;
        }
    }
    class MapItemNotFound extends RuntimeException{ }//interna alla mappa

}