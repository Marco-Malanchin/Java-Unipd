public class sommaMoltiplicazione{
	public static void main(String[] arg){
	System.out.println("Questo programma stampa la somma dei primi 10 numeri interi");
	int somma = 0;
	int prodotto = 1;
	for(int i = 1; i<=10; i++){
	somma = somma + i;
	prodotto = prodotto * i;
		}
	System.out.println("Somma :" + somma + "\n" + "prodotto: " + prodotto);
	System.exit(0);
	}
}
