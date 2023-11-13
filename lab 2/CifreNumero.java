import java.util.Scanner;
public class CifreNumero{
	public static void main(String[] arg){
		Scanner numero = new Scanner(System.in);
		System.out.println("Scrivi un numero di massimo 5 cifre intero e positivo");
		int cifre = numero.nextInt();
		String numeri = "" + cifre;
		int lunghezza = numeri.length();
		if(lunghezza > 5){
			System.out.println("Errore numero inserito troppo grande");
		}
		else if(cifre < 0){
			System.out.println("Errore numero inserito negativo");
			}
		else if(cifre < 0){
			System.out.println("Errore numero inserito negativo");
			}
		else if(lunghezza == 4){
			numeri = "0" + numeri;
			int sub1 = 0;
			int sub2 = (cifre % 10000) /1000; 
			int sub3 = (cifre % 1000) /100; 
			int sub4 = (cifre % 100) /10; 
			int sub5 = (cifre % 10); 
			System.out.println("numero inserito:" + cifre + "\n" + "cifra 1:" + sub1 + "\n" + "cifra 2:" + sub2 + "\n" + "cifra 3:" + sub3 + "\n" + "cifra 4:" + sub4 + "\n" + "cifra 5:" + sub5);
		}
		else if(lunghezza == 3){
			numeri = "00" + numeri;
			int sub1 = 0;
			int sub2 = 0; 
			int sub3 = (cifre % 1000) /100; 
			int sub4 = (cifre % 100) /10; 
			int sub5 = (cifre % 10); 
			System.out.println("numero inserito:" + cifre + "\n" + "cifra 1:" + sub1 + "\n" + "cifra 2:" + sub2 + "\n" + "cifra 3:" + sub3 + "\n" + "cifra 4:" + sub4 + "\n" + "cifra 5:" + sub5);
			
		}
		else if(lunghezza == 2){
			numeri = "000" + numeri;
			int sub1 = 0;
			int sub2 = 0; 
			int sub3 = 0; 
			int sub4 = (cifre % 100) /10; 
			int sub5 = (cifre % 10); 
			System.out.println("numero inserito:" + cifre + "\n" + "cifra 1:" + sub1 + "\n" + "cifra 2:" + sub2 + "\n" + "cifra 3:" + sub3 + "\n" + "cifra 4:" + sub4 + "\n" + "cifra 5:" + sub5);
		}
		else if(lunghezza == 1){
			numeri = "0000" + numeri;
			int sub1 = 0;
			int sub2 = 0;
			int sub3 = 0;
			int sub4 = 0;
			int sub5 = (cifre % 10); 
			System.out.println("numero inserito:" + cifre + "\n" + "cifra 1:" + sub1 + "\n" + "cifra 2:" + sub2 + "\n" + "cifra 3:" + sub3 + "\n" + "cifra 4:" + sub4 + "\n" + "cifra 5:" + sub5);
		}
		else{
			int sub1 = cifre / 10000;
			int sub2 = (cifre % 10000) /1000; 
			int sub3 = (cifre % 1000) /100; 
			int sub4 = (cifre % 100) /10; 
			int sub5 = (cifre % 10); 
			System.out.println("numero inserito:" + cifre + "\n" + "cifra 1:" + sub1 + "\n" + "cifra 2:" + sub2 + "\n" + "cifra 3:" + sub3 + "\n" + "cifra 4:" + sub4 + "\n" + "cifra 5:" + sub5);
		}
		
		}
}
