public class ListIteratorTester{
	public static void main(String[] args)
{  LinkedList list = new LinkedList();
   list.addFirst("A");
   list.addLast("B");
   list.addFirst("C");
   ListIterator iter = list.getIterator();
   iter.next();
   iter.add("I");
   while (iter.hasNext()){
      iter.next();}
   iter.remove();
   list.addLast("O");
   iter = list.getIterator();
   while (iter.hasNext())
      System.out.print(iter.next());
	}
}
interface List extends Container{
		ListIterator getIterator();
	}
interface ListIterator{
  	/*
      comportamento del costruttore di una
      classe che realizza questa interfaccia:
      quando viene costruito, l'iteratore si
      trova nella sua prima posizione valida,
      cio� PRIMA del primo elemento; l'ultima
      posizione valida dell'iteratore � quella
      che si trova DOPO l'ultimo elemento
   	*/

	/*
      se l'iteratore si trova nella sua ultima
      posizione valida, lancia IllegalStateException;
      altrimenti restituisce un riferimento all'oggetto
      che si trova nella posizione successiva alla
      posizione dell'iteratore e fa avanzare di una
      posizione l'iteratore
   	*/
		Object next();

	/*
     restituisce true se e solo se � possibile invocare 
next senza che venga lanciata un'eccezione
   	*/
		boolean hasNext();

	/*
     inserisce l'oggetto ricevuto in un nuovo nodo che
     viene collocato PRIMA della posizione dell'iteratore,
     senza modificare la posizione dell'iteratore
   	*/
		void add(Object obj);

	/*
     se, a partire dal momento della costruzione dell'iteratore
     o dall'ultima invocazione del metodo remove, non � stato invocato
     il metodo next o il metodo add, lancia IllegalStateException;
     altrimenti elimina il nodo che si trova nella posizione che
     precede la posizione dell'iteratore (cio� il nodo pi�
     recentemente esaminato da next o inserito da add), senza
     modificare la posizione dell'iteratore (cio� il nodo che
     verr� restituito da una successiva invocazione di next �
     lo stesso che sarebbe stato restituito se non fosse stato
     invocato il metodo remove)
   	*/
		void remove();
}
class LinkedList implements List{
		private class ListNode{
			private Object element;
			private ListNode next;
			public ListNode(){
				element = null;
				next = null;
			}
			public ListNode(Object e, ListNode n){
				element = e;
				next = n;
			}
			public Object getElement(){
				return element;
			}
			public ListNode getNext(){
				return next;
			}
			public void setElement(Object e){
				element = e;	
			}
			public void setNext(ListNode n){
				next = n;
			}
		}
		private class LinkedListIterator implements ListIterator{
			private ListNode current;
			private ListNode previous;
			public LinkedListIterator(ListNode head){
				current = head;
				previous = null;
			}
			public boolean hasNext(){
				return current.getNext() != null;
			}
			public Object next(){
				if(!hasNext()){
					throw new IllegalStateException();
				}
				previous = current;
				current = current.getNext();
				return current.getElement();
			}
			public void add(Object obj){
				ListNode n = new ListNode(obj, current.getNext());
				current.setNext(n);
				previous = current;
				current = current.getNext();
				if(!hasNext()){
					LinkedList.this.tail = current;
				}
			}
			public void remove(){
				if(previous == null){
					throw new IllegalStateException();
				}
				previous.setNext(current.getNext());
				current = previous;
				previous = null;
				if(!hasNext()){
					LinkedList.this.tail = current;
				}
			}
		}
		private ListNode head;
		private ListNode tail;
		public LinkedList(){
			makeEmpty();
		} 
		public void makeEmpty(){
			head = tail = new ListNode();
		}
		public boolean isEmpty(){
			return (head == tail);
		}
		public Object getFirst(){
			if(isEmpty()){
				throw new EmptyLinkedListException();
			}
			return head.getNext().getElement();
		}
		public Object getLast(){
			if(isEmpty()){
				throw new EmptyLinkedListException();
			}
			return tail.getElement();
		}
		public void addFirst(Object e){
			head.setElement(e);
			ListNode n = new ListNode();
			n.setNext(head);
			head = n;	
		}
		public Object removeFirst(){
			Object e = getFirst();
			head = head.getNext();
			head.setElement(null);
			return e;
		}
		public void addLast(Object e){
			tail.setNext(new ListNode(e, null));
			tail = tail.getNext();
		}
		public Object removeLast(){
			Object e = getLast();
			ListNode temp = head;
			while(temp.getNext() != tail){
				temp = temp.getNext();
			}
			tail = temp;
			tail.setNext(null);
			return e;
		}
		public ListIterator getIterator(){
			
			return new LinkedListIterator(head);
		}
}
class EmptyLinkedListException extends RuntimeException{
}
interface Container{
		boolean isEmpty();
		void makeEmpty();
}
