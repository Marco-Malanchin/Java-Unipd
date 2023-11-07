import java.util.Scanner;
import java.lang.Math;

public class angolo{
	public static void main(String[] arg){
	Scanner scan = new Scanner(System.in);
	double angolo = 0;
	do{
		System.out.println("Inserisci un angolo");
		angolo = scan.nextDouble();
	}
	while(angolo < 0);
	angolo = Math.toRadians(angolo);
	double seno = Math.sin(angolo);
	double coseno = Math.cos(angolo);
	double tangente = Math.tan(angolo);
	angolo = angolo / Math.PI;
	System.out.printf("angolo in radianti: %5.3f%n", angolo);
	System.out.printf("seno in radianti: %5.3f%n", seno);
	System.out.printf("coseno in radianti: %5.3f%n", coseno);
	System.out.printf("tangente in radianti: %5.3f%n", tangente);
	System.exit(0);
	}
}
