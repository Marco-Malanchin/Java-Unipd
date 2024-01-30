public class CodaCatena(){
    public static void main(String[] args){
    
    }        
}
   interface Container{
     boolean isEmpty();
     void makeEmpty();
}
interface Queue extends Container{
    void enqueue(Object e);
    Object getFront();
    Object dequeue();
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
    }
class EmptyLinkedListExceptio extends RuntimeException{}
public class LinkedListQueue implements Queue{
    private LinkedList list = new LinkedList();
    public void enqueue(Object obj){
        list.addLast(obj);
    }
    public Object dequeue(){
        return list.removeFirst();
    }
    public Object getFront(){
        return list.getFirst();
    }
     public void makeEmpty(){
        list.makeEmpty();
    }
    public boolean isEmpty(){
        return list.isEmpty();
    }
}