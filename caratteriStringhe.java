import java.util.Scanner;

class caratteriStringhe {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Inserisci la prima stringa");
        String stringa1 = scan.nextLine();
		int lunghezza1 = stringa1.length();
        stringa1 = stringa1.toLowerCase();
		int lunghezza2;
         String stringa2;
		do{
		System.out.println("Inserisci la seconda stringa");
       stringa2 = scan.nextLine();
		lunghezza2 = stringa2.length();
         stringa2 = stringa2.toLowerCase();
		}while(lunghezza2 >= lunghezza1);
		boolean trovato = false;
        for (int i = 0; i < lunghezza1; i++){
   			int j;         
			for(j = 0; j < lunghezza2; j++){
                if(stringa1.charAt(i + j) != stringa2.charAt(j)){
                    break;
                }
            }
			if(j == lunghezza2){
				trovato = true;
                break;
			}
			else{
				trovato = false;
			}
        }
        if(trovato == true){
			System.out.println("Stringa 2 e' una sotto stringa");
		}
		else{
			System.out.println("Stringa 2 non e' una sotto stringa");
		}
    }
}