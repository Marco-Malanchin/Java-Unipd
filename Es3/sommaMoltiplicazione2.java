public class sommaMoltiplicazione2{
	public static void main(String[] arg){
	System.out.println("Questo programma stampa la somma dei primi 10 numeri interi pari");
	int somma = 0;
	long prodotto = 1;
	for(int i = 1; i<=20; i++){
		if((i%2)== 0){
		somma = somma + i;
		prodotto = prodotto * i;
		}
		}
	System.out.println("Somma :" + somma + "\n" + "prodotto: " + prodotto);
	System.exit(0);
	
	}
}
