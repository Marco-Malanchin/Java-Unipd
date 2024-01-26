import java.util.*;
import java.io.*;

public class CognomeMatricola1
{
   public static void main(String[] args)
   {
      CircularChain catena = new CircularChain();
      Scanner console = new Scanner(System.in);
      int conta = 0;
      
      while (console.hasNextLine())
      {
         String s = console.nextLine();  
         catena.add(s);
         conta++;     
      }
      
      for(int i = 0; i < conta/3; i++)
      {
         catena.remove();
      }
      
      Object [] elenco = catena.toArray();
      
      // ordina
      for(int i = 0; i < elenco.length-1; i++)
      {
		int posMin = i;
		for(int j = i+1; j < elenco.length; j++)
		{
			if (((String)elenco[posMin]).compareTo((String)elenco[j]) > 0)
		        {
				posMin = j;
		        }
		}
                Object temp = elenco[i];
                elenco[i] = elenco[posMin];
                elenco[posMin] = temp;
      }
      
      for(int i = 0; i < elenco.length; i++)
      {
          System.out.println(elenco[i]);
      }
   
   }
}

class CircularChain
{
  private Node head;
  public CircularChain()
  {
    head = null;
  }

  public void add(Object x)
  {  
     Node nuovo = new Node();
     nuovo.element = x;
          
     if(head != null)
     {
       nuovo.next = head;   
       nuovo.prev=head.prev;
       head.prev.next = nuovo;
       head.prev = nuovo;
     }
     else
     {
        nuovo.prev=nuovo.next=nuovo;
     }
     head = nuovo;
 }
  public void remove()
  {  
     if(head != null)      {
        head.prev = head.prev.prev;
        return;
     }
     throw new IllegalStateException();
  }

  public Object[] toArray()
  {
      Object[] lista = new Object[10];
      int listaSize = 0;
      Node nodo = head;
      do
      {
        lista[listaSize++] = nodo.element;
        nodo = nodo.next;
      } while (nodo != head);
      Object[] completo = new Object[listaSize];
      System.arraycopy(lista, 0, completo, 0, listaSize);
      return completo;
  }
  private class Node
  {
      private Node next, prev;
      private Object element;
  }

}