import java.util.Scanner;
import java.lang.Math;

public class latiTriangolo{
	public static void main(String[] arg){
		Scanner lato = new Scanner(System.in);
		double cateto1 = 0;
		do{
			System.out.println("Inserisci il valore del primo lato");
		cateto1 = lato.nextDouble();
		}
		while(cateto1 <= 0);
		double cateto2 = 0;
		do{
			System.out.println("Inserisci il valore del secondo lato");
		cateto2 = lato.nextDouble();
		}
		while(cateto2 <= 0);
		if(cateto1 == cateto2){
			System.out.println("inserisci due lati diversi");
			System.exit(1);
		}else{
			double cateto1alla2 = Math.pow(cateto1, 2);
		double cateto2alla2 = Math.pow(cateto2, 2);
		double somma = cateto1alla2 + cateto2alla2;
		double lato3 = Math.sqrt(somma);
		double perimetro = cateto1 + cateto2 + lato3;
		double area = (cateto1 * cateto2) / 2;
		System.out.printf("l'ipotenusa vale: %5.2f%n", lato3);
		System.out.printf("Il perimetro vale: %5.2f%n", perimetro);
		System.out.printf("l'area vale: %5.2f%n", area);
		double catetoMinore = 0;
		double catetoMaggiore = 0;
		if(cateto1 < cateto2){
			catetoMinore = cateto1;
			catetoMaggiore = cateto2;
		}
		else{
			catetoMinore = cateto2;
			catetoMaggiore = cateto1;
		}
		double angolo = catetoMinore / catetoMaggiore;
		double angoloMinore = Math.atan(angolo);
		angoloMinore = Math.toDegrees(angoloMinore);
		double angoloMaggiore = 90 - angoloMinore;
		System.out.printf("l' angolo minore vale: %5.2f%n", angoloMinore);
		System.out.printf("l' angolo maggiore vale: %5.2f%n", angoloMaggiore);
		System.exit(0);
		}
		
	}
}
