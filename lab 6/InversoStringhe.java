import java.util.Scanner;

public class InversoStringhe{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		String string1 = "";
		String string2 = "";
		if(args.length > 2){
			System.out.println("Numero di argomenti errato, inserisci solo due stringhe");
			System.exit(1);
		}
		else if(args.length == 2){
			string1 = args[0];
			string2 = args[1];
		}
		else if(args.length == 0){
			System.out.println("Inserisci la prima stringa per fare il controllo");
			string1 = scan.nextLine();
			System.out.println("Inserisci la seconda stringa per fare il controllo");
			string2 = scan.nextLine();
		}
		else if(args.length == 1){
			System.out.println("Inserisci la seconda stringa per fare il controllo");
			string2 = scan.nextLine();
			string1 = args[0];
		}
		string1 = string1.toLowerCase();
		string2 = string2.toLowerCase();
		char[] s1 = InversoStringhe.toArray(string1);
		char[] s2 = InversoStringhe.toArray(string2);
		boolean controllo = InversoStringhe.reverseEquals(s1, s2);
		if(controllo == true){
			System.out.println("Le stringhe " + string1 + " e " + string2 + " sono  una l'inversa dell'altra");
		}
		else{
			System.out.println("Le stringhe " + string1 + " e " + string2 + " non  sono  una l'inversa dell'altra");
		}
		scan.close();
	}
	public static char[] toArray(String s){
		int l = s.length();
		char[] pippo = new char[l];
		for(int i = 0; i < l; i++){
			pippo[i] = s.charAt(i);
		}
		return pippo;
	}
	public static boolean reverseEquals(char[] a, char[] b){ 
		boolean controllo = true;
		for(int i = 0, j = b.length - 1; i < a.length && j >=  0;  i++, j-- ){
			if (a[i] != b[j]){
				controllo = false;
				break;
			}
		}
		return  controllo;
	}
}
