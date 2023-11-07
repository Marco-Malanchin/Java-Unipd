import java.util.Scanner;
public class es33{
	public static void main(String[] arg){
	Scanner scan = new Scanner(System.in);
	int numero;
	do{
		System.out.println("inserisci un numero maggiore di 10");
		numero = scan.nextInt();
	}
	while(numero <= 10);
	for(int i = 10; i < numero; i++){
	if(i != 10){
	System.out.println(i);
	}
	}
	System.exit(0);
	}
}
