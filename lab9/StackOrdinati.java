import java.util.Scanner;

public class StackOrdinati{
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
		StackX temp1 = new StackX();
		StackX temp2 = new StackX();
		while(!a.isEmpty()){
			temp1.push(a.pop());
		}
		while(!temp1.isEmpty()){
			temp2.push(temp1.pop());
		}
		while(!temp2.isEmpty()){
			a.push(temp2.pop());
		}
	}
}
class IllegalArgumentException extends RuntimeException
{}
class EmptyStackException extends RuntimeException
{}
