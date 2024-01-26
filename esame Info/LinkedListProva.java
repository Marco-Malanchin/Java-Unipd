public class LinkedListProva{
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
         private Object getElement(){
            return element;
        }
        private void setElement(Object e){
            element = e;
        }
         private Object getNext(){
            return next;
        }
        private void setNext(Node e){
            next = e;
        }
    }
}
class EmptyLinkedListExceptio extends RuntimeException{}