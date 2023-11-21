import java.util.Scanner;
import java.util.InputMismatchException;

public class NumeriPrimi{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		boolean controllo = false;
		int max = 0;
		while(controllo == false){
			try{
				System.out.println("Inserisci un numero massimo maggiore di 1, il programma stampera' i numeri primi fino a quel numero");
				max = scan.nextInt();
				if(max <= 1){
					controllo = false;
				}
				else{
					controllo = true;
				}
			}
			catch(InputMismatchException e){
				System.out.println("Inserisci un numero valido");
				scan.nextLine();
			}
		}
		boolean[] numeri = new boolean[max];
		for(int i = 0; i < max; i++){
			numeri[i] = false;
		}
		for(int i = 0; i < max; i++){
			if(i == 0){
				numeri[i] = true;
			}
			else{
				for(int j = 1; j < max; j++){
					if((i % j) == 0){
						numeri[i] = true;
					}
				}
			}
			
		}
		scan.close();
	}
}
