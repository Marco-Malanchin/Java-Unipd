public class LinkedListIterator Prova{
    public static void main(String[] args){

    }
}
class Lista{
    private Node head, tail;
    public Lista(){
        makeEmpty();
    }
    public void makeEmpty(){
        head = tail = new Node();
    }
    public boolean isEmpty(){
        return (head == tail);
    }
    public Object getFirst(){
        if(isEmpty()){
            return new EmptyLinkedListExceptio();
        }
        return head.getNext().getElement();
    }
    public Object getLast(){
        if(isEmpty()){
            return new EmptyLinkedListExceptio();
        }
        return tail.getElement();
    }
    public void addFirst(Object e){
        head.setElement(e);
        Node temp = new Node();
        temp.setNext(head);
        head = temp;
    }
    public Object removeFirst(){
        Object temp = getFirst();
        head = head.getNext();
        head.setElement(null);
        return temp;
    }
    public void addLast(Object e){
        Node temp = new Node(e, null);
        tail.setNext(temp);
        tail = tail.getNext();
    }
    public Object removeLast(){
        Object removal = getLast();
        Node temp = head
        while(temp.getNext() != tail){
            temp = temp.getNext();
        }
        tail = temp;
        tail.setNext(null);
        return removal;
    }
    public Iteratore getIterator(){ 
        return new Iteratore(head); 
    }
    private class Node{
        private Object element;
        private Node next;
        public Node(Object element, Node next){
           this. element = element;
            this.next = next;
        }
        public Node(){
            element = null;
            next = null;
        }
         public Object getElement(){
            return element;
        }
        public void setElement(Object e){
            element = e;
        }
         public Object getNext(){
            return next;
        }
        public void setNext(Node e){
            next = e;
        }
    }
    private class Iteratore implements ListIterator{
       private Node current;
       private Node previus;
        public Iteratore(Node head){
            current = head;
            previus = null;
        }
        public boolean hasNext(){
            return current.getNext() != null;
        }
        public Object next(){
            if(!hasNext()){
                throw new IllegalStateException();
            }
            previus = current;
            current = current.getNext();
            return current.getElement();
        }
        public void add(Object x){
             Node temp = new Node(x, current.getNext());
             current.setNext(temp);
             previus = current;
             current = current.getNext();
             if(!hasNext()){
                Lista.this.tail = current;
            }
        }
        public void remove(){
            if(previus == null){
                throw new IllegalStateException();
            }
            previus.setNext(current.getNext());
            current = previus;
            previus = null;
            if(!hasNext()){
                Lista.this.tail = current;
            }
        }
    }
}
public interface ListIterator
{ // Funzionamento del costruttore:
 // quando viene costruito, l’iteratore si
 // trova nella prima posizione,
 // cioè DOPO il nodo header

 // se l’iteratore si trova alla fine della
 // catena, lancia IllegalStateException,
 // altrimenti restituisce l’oggetto che si
 // trova nel nodo posto DOPO la posizione
 // attuale e sposta l’iteratore di una
 // posizione in avanti lungo la catena
 Object next();
 // verifica se è possibile invocare next()
 // senza che venga lanciata un’eccezione
 boolean hasNext();
}
class EmptyLinkedListExceptio extends RuntimeException{}
class IllegalStateException extends RuntimeException{}