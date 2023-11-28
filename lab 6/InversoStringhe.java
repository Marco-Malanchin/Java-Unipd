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
			System.out.println("Inserisci prima stringa per fare il controllo");
			string1 = scan.nextLine();
			System.out.println("Inserisci seconda stringa per fare il controllo");
			string2 = scan.nextLine();
		}
		else if(args.length == 1){
			System.out.println("Inserisci seconda stringa per fare il controllo");
			string2 = scan.nextLine();
			string1 = args[0];
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
}
