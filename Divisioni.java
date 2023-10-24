public class Divisioni{
	public static void main(String [] args){
		int m = 11; //numeri Interi
		int n = 5;
		System.out.println("Il risultato della divisione tra il numero m e quello n e':" +m/n); //stampo risultato divisione
		System.out.println("Il quoziente della divisione tra il numero m e quello n e':" +m%n); //stampo quoziente divisione
		
		double x = 7.0; //numeri reali
		double y = 0.0;
		System.out.println("Il risultato della divisione tra il numero x e quello y e':" +x/y); //stampo risultato divisione che dara' infinity, -infinity o Nan a seconda dei casi
		System.out.println("Il quoziente della divisione tra il numero m e quello n e':" +x%y); //stampo quoziente divisione che dara' sempre Nan
	}
}
