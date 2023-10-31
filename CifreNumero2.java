import java.util.Scanner;
public class CifreNumero2{
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
			String sub1 = numeri.substring(0, 1);
			String sub2 = numeri.substring(1, 2);
			String sub3 = numeri.substring(2, 3);
			String sub4 = numeri.substring(3, 4);
			String sub5 = numeri.substring(4, 5);
			System.out.println("numero inserito:" + cifre + "\n" + "cifra 1:" + sub1 + "\n" + "cifra 2:" + sub2 + "\n" + "cifra 3:" + sub3 + "\n" + "cifra 4:" + sub4 + "\n" + "cifra 5:" + sub5);
		}
		else if(lunghezza == 3){
			numeri = "00" + numeri;
		String sub1 = numeri.substring(0, 1);
			String sub2 = numeri.substring(1, 2);
			String sub3 = numeri.substring(2, 3);
			String sub4 = numeri.substring(3, 4);
			String sub5 = numeri.substring(4, 5);
			System.out.println("numero inserito:" + cifre + "\n" + "cifra 1:" + sub1 + "\n" + "cifra 2:" + sub2 + "\n" + "cifra 3:" + sub3 + "\n" + "cifra 4:" + sub4 + "\n" + "cifra 5:" + sub5);
		}
		else if(lunghezza == 2){
			numeri = "000" + numeri;
			String sub1 = numeri.substring(0, 1);
			String sub2 = numeri.substring(1, 2);
			String sub3 = numeri.substring(2, 3);
			String sub4 = numeri.substring(3, 4);
			String sub5 = numeri.substring(4, 5);
			System.out.println("numero inserito:" + cifre + "\n" + "cifra 1:" + sub1 + "\n" + "cifra 2:" + sub2 + "\n" + "cifra 3:" + sub3 + "\n" + "cifra 4:" + sub4 + "\n" + "cifra 5:" + sub5);
		}
		else if(lunghezza == 1){
			numeri = "0000" + numeri;
			String sub1 = numeri.substring(0, 1);
			String sub2 = numeri.substring(1, 2);
			String sub3 = numeri.substring(2, 3);
			String sub4 = numeri.substring(3, 4);
			String sub5 = numeri.substring(4, 5);
			System.out.println("numero inserito:" + cifre + "\n" + "cifra 1:" + sub1 + "\n" + "cifra 2:" + sub2 + "\n" + "cifra 3:" + sub3 + "\n" + "cifra 4:" + sub4 + "\n" + "cifra 5:" + sub5);
		}
		else{
			String sub1 = numeri.substring(0, 1);
			String sub2 = numeri.substring(1, 2);
			String sub3 = numeri.substring(2, 3);
			String sub4 = numeri.substring(3, 4);
			String sub5 = numeri.substring(4, 5);
			System.out.println("numero inserito:" + cifre + "\n" + "cifra 1:" + sub1 + "\n" + "cifra 2:" + sub2 + "\n" + "cifra 3:" + sub3 + "\n" + "cifra 4:" + sub4 + "\n" + "cifra 5:" + sub5);
		}
		
		}
}
