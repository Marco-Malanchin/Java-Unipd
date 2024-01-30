public class CognomeMatricola123456 { // MODIFICARE CognomeMatricola, ma NON il
                                // contenuto
    public static void main(String[] args) {
        MultiSet s = new MyMultiSet();
        String s1 = "ok";    String s2 = "no";
        s.add("ok");   s.add("ok");   s.add("ok");
        s.add("no");    s.add("no");
        s.remove("ok");   s.remove("no");
        System.out.print(s.molt(s1) + s.molt(s2));  // deve visualizzare 3
    }
}
interface Container { // comportamento definito a lezione
  void makeEmpty(); 
   boolean isEmpty();
}
interface MultiSet extends Container {
//aggiunge x in una posizione qualunque di this; richiede x!= null;
  void add(Object x);
//viene eliminata una qualunque (e una sola) occorrenza di x; richiede x!= null;
  void remove(Object x) throws IllegalStateException;
//restituisce la molteplicità di x, cioe' il numero di elementi E di this per i //quali x.equals(E) vale true; richiede x!= null;
  int molt(Object x);
}

interface Set extends Container{ // comportamento definito a lezione
  void add(Object x);   
  boolean contains(Object x);   
  Object[] toArray();
}

class MySet implements Set {
    private Object[] v;
    private int vSize;
    public MySet(){
        v = new Object[10];
        makeEmpty();
    }
    public void makeEmpty(){
        vSize = 0;
    }
    public boolean isEmpty(){
        return (vSize == 0);
    }
    public void add(Object x){
       if(contains(x)){
        return; 
       }
       if(vSize == v.length){
            resize();
       }
        v[vSize++] = x;
    }
    private void resize(){
        Object[] temp = new Object[2 *v.length];
        System.arraycopy(v, 0, temp, 0, vSize);
        v = temp;
    }
    public boolean contains(Object x){
       for(int i = 0; i < vSize; i++ ){
            if(v[i].equals(x)){
                return true;
            }
       }
        return false;
    }
    public Object[] toArray(){
        Object[] temp = new Object[vSize];
        System.arraycopy(v, 0, temp, 0, vSize);
        return temp;
    }
 }
class MyMultiSet implements MultiSet { 
    public MyMultiSet(){
        s = new MySet();
        makeEmpty();
    }
    public void makeEmpty(){
       s.makeEmpty();
    }
    public boolean isEmpty(){
        return s.isEmpty();
    }
    public void add(Object x){
        if(x == null){
            return;
        }
        Object[] temp = s.toArray();
        boolean done = false;
        for(int i = 0; i < temp.length && !done; i++){
            Coppia pair = (Coppia)temp[i];
            if(pair.obj.equals(x)){
                done = true;
                pair.i++;
            }
        }
        if(!done){
            s.add(new Coppia(x, 1));
        }
    }
    public void remove(Object x){
        if(x == null){
           return;
        }
        Object[] temp = s.toArray();
        boolean done = false;
        for(int i = 0; i < temp.length && !done; i++){
            Coppia pair = (Coppia)temp[i];
            if(pair.obj.equals(x)){
                if(pair.i>1){
                    done = true;
                    pair.i--;
                }
            }
        }
        if(!done){
            throw new IllegalStateException();
        }
    }
    public int molt(Object x){
        if(x == null){
            return 0;
        }
        Object[] temp = s.toArray();
        for(int i = 0; i < temp.length; i++){
            Coppia pair = (Coppia)temp[i];
            if(pair.obj.equals(x)){
                return pair.i;
            }
        }
        return 0;
    }

  // questa classe non può avere variabili statiche;
  private class Coppia { //classe interna a MyMultiSet
    //rappresenta una coppia (Object,int)
        Object obj;     
        int i;   
        Coppia(Object o, int m) {
            obj=o; 
            i= m;
        }
        public boolean equals(Object z){
            if(!(z instanceof Coppia)){
                return false;
            }
            Coppia pair = (Coppia)z;
            if(pair.obj.equals(this.obj) && pair.i == this.i){
                return true;
            }
            return false;
        } //e' necessario sovrascrivere equals
   }
  private MySet s; // non ci possono essere altre variabili di esemplare
} 
class IllegalStateException extends RuntimeException{}