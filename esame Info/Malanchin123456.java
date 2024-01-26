import java.util.Scanner;

public class Malanchin123456{
    public static void main(String[] args){
        System.out.println("Inserisci quante frasi vuoi\n  andando a capo per separare le frasi\n  premi ctrl + Z per fermare il programma.");
        Scanner scan = new Scanner(System.in);
        int inserimenti = 0;
        CircularChain pippo = new CircularChain();
        while(scan.hasNextLine()){
            String frase = scan.nextLine();
            pippo.add(frase);
            inserimenti++;
        }
        scan.close();
        int inserimentiTerzi = (inserimenti / 3);
        for(int i = 0; i < inserimentiTerzi; i++){
            pippo.remove();
        }
        Object[] pluto = pippo.toArray();
        for(int i = 0; i < pluto.length -1; i++){
            int pos = i;
            for(int j = pos + 1; j < pluto.length; j++){
                if((((String)pluto[j]).compareTo(((String)pluto[pos]))) < 0){
                    pos = j;
                }
            }
            if(pos != i){
                Object temp = pluto[i];
                pluto[i]  = pluto[pos];
                pluto[pos] = temp;
            }
        }
         for(int i = 0; i < pluto.length; i++)
      {
          System.out.println(pluto[i]);
      }
    }
}
    class CircularChain{
        public CircularChain(){
            head = null;
        }
        public void add(Object e){
            Node temp = new Node();
            temp.element = e;
            if(head != null){
                temp.next = head;
                temp.previus = head.previus;
                head.previus.next = temp;
                head.previus = temp;
            }
            else{
                temp.previus = temp.next = temp;
            }
            head = temp;
        }
        public void remove(){
            if(head == null){
                throw new IllegalStateException();
            }
            head.previus.previus.next = head;
            head.previus = head.previus.previus;
            return;
        }
        public  Object[] toArray(){
            if(head == null){
                throw new IllegalStateException();
            }
            Object[] temp = new Object[3];
            int sizeTemp = 0;
            Node tempObject = head;
            boolean flag = true;
            while(flag == true){
                if(sizeTemp == temp.length){
                    Object[] temp2 = new Object[2 *temp.length];
                    System.arraycopy(temp, 0, temp2, 0, sizeTemp);
                    temp = temp2;
                }
                temp[sizeTemp++] = head.element;
                head = head.next;
                if(head == tempObject){
                    flag = false;
                    Object[] temp2 = new Object[sizeTemp];
                    System.arraycopy(temp, 0, temp2, 0, sizeTemp);
                    temp = temp2;
                }
            }
            return temp;
        }
        private class Node{
            private Node next, previus;
            private Object element;
        }
        private Node head;
}