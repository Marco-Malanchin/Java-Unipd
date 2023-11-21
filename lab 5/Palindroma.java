import java.util.Scanner;

public class Palindroma{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("inserisci una stringa, il programma controllera' se tale stringa e' palindroma");
		String parola = scan.nextLine();
		parola = parola.toLowerCase();
		int lunghezza = parola.length();
		String confronto = "";
		for(int i = lunghezza - 1; i >= 0; i--){
			confronto = confronto + String.valueOf(parola.charAt(i));
		}
		if(parola.equals(confronto) == true){
			System.out.println("parola palindroma");
		}
		else{
			System.out.println("parola non palindroma");
		}
		scan.close();
	}
}
