import java.util.Scanner;

class caratteriStringhe {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Inserisci la prima stringa");
        String frase1 = scan.nextLine();
        frase1 = frase1.toLowerCase();
		int lunghezza1 = frase1.lenght();
		int lunghezza2;
		do{
		System.out.println("Inserisci la seconda stringa");
        String frase2 = scan.nextLine();
		lunghezza2 = frase2.lenght();
		}while(lunghezza2 >= lunghezza1);
        frase2 = frase2.toLowerCase();
		boolean trovato;
        for (int i = 0; i < lunghezza1; i++){
   			int j;         
			for(j = 0; j < lunghezza2; j++){
                if(frase1.charAt(i + j) != frase2.charAt(j)){
                    break;
                }
            }
			if(j == lunghezza2){
				trovato = true;
			}
			else{
				trovato == false;
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