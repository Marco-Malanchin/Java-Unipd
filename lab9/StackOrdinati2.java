import java.util.Scanner;

public class StackOrdinati2{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		StackX numeri = new StackX();
		StackX numeriNonOrdinati = new StackX();
		System.out.println("Inserisci i numeri che vuoi mettere dentro alla pila. \nQuando vuoi terminare l'inserimento lascia la linea vuota e premi invio");
		boolean controllo1 = false;
		while(!controllo1){
			String riga = scan.nextLine();
			if(riga == ""){
				controllo1 = true;
				break;
			}
			Scanner line = new Scanner(riga);
			while(line.hasNext()){
				try{
					String parola = line.next();
					Integer numero = Integer.valueOf(parola);
					numeri.push(numero);
					numeriNonOrdinati.push(numero);
				}
				catch(NumberFormatException e){
					System.out.println("Inserisci solo numeri interi");
				}
			}
			line.close();
		}
		scan.close();
		System.out.println("Numeri prima dell'ordinamento");
		while(!numeriNonOrdinati.isEmpty()){
        		System.out.println(numeriNonOrdinati.pop());
        	}
        	numeri.insertionSort();
        	StackX.inverti(numeri);
        	System.out.println("Numeri dopo l'ordinamento");
        	while(!numeri.isEmpty()){
        		System.out.println(numeri.pop());
        	}
	}
}
interface Container{
	boolean isEmpty();
	void makeEmpty();
}
interface Stack extends Container{
	void push(Object e);
	Object top();
	Object pop();	
}
class StackX implements Stack{
	Object[] v;
	int vSize;
	public StackX(){
		v = new Object[100];
		makeEmpty();
	}
	public void makeEmpty(){
		vSize = 0;
	}
	public boolean isEmpty(){
		return (vSize == 0);
	}
	protected static Object[] resize(Object[] e, int l){
		if(l < e.length){
			throw new IllegalArgumentException();
		}
		Object[] temp = new Object[l];
		System.arraycopy(e,0, temp,0,e.length);
		return temp;
	}
	public void push(Object e){
		if(vSize == v.length){
			v = resize(v, 2*v.length);
		}
		v[vSize++] = e;
	}
	public Object top(){
		if(isEmpty()){
			throw new EmptyStackException();
		}
		return v[vSize - 1];
	}
	public Object pop(){
		Object temp = top();
		vSize--;
		return temp;
	}
	protected static int compare(int a, int e){
		if(a < e){
			return 1;
		}
		if(a > e){
			return -1;
		}
		return 0;
	}
	public void insertionSort(){
		for(int i = 1; i < vSize; i++){
			Object temp = v[i];
			int j;
			for(j = i; j > 0 && compare((int)v[j-1], (int)temp) == -1; j--){
				v[j] = v[j-1];
			}
			v[j] = temp;
		}
		
	}
	public static void inverti(StackX a){
		// creiamo la pila temporanea
      		Stack temp1 = new StackX();
      		// contiamo gli elementi presenti nella pila originaria:
     		// per farlo occorre trasferire tutti gli elementi nella
      		// pila temporanea, contandoli;             al termine del conteggio
      		// gli elementi verranno riportati nella pila originaria
      		int count = 0;
      		while (!a.isEmpty()){
      			temp1.push(a.pop());
         		count++;
      		}
      		while (!temp1.isEmpty())
         	a.push(temp1.pop());
      		// ciclo principale
      		while (count > 0){
      			// decremento della lunghezza della pila temporanea
         		count--;
         		// memorizzazione dell'elemento in cima alla pila
         		Object obj = a.pop();
         		// trasferimento di tutti gli altri elementi
         		for (int i = 0; i < count; i++){
            			temp1.push(a.pop());
            		}	
         		// inserimento nella pila originaria dell'elemento
         		// memorizzato
         		a.push(obj);
         		// trasferimento di tutti gli altri elementi
         		for (int i = 0; i < count; i++){
            			a.push(temp1.pop());
            		}
      		}
		
	}
}
class IllegalArgumentException extends RuntimeException
{}
class EmptyStackException extends RuntimeException
{}
