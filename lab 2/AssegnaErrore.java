/*In questa classe si evidenziano alcuni errori nelle assegnazioni */

public class AssegnaErrore {
	public static void main(String arg[]){
		int a = 8;
		double b = 3.5;
	        System.out.println("a = " + a + " b = " + b);
		b = a;			//nuovo valore per b
	        System.out.println("b = " + b);  

		char lettera;		
		lettera = 'x';  

		int c2 = 0;
		a=c2;
		System.out.println("a = " + a + " carattere = " + lettera);

		int c = 7;
		//c1 = c; non potra' mai andare perche' c1 non e mai stato inizializzato
	}//fine main

}//fine classe

