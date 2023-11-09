import java.util.Scanner;

class caratteriStringhe {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Inserisci la prima stringa");
        String frase1 = scan.nextLine();
        frase1 = frase1.toLowerCase();
        System.out.println("Inserisci la seeconda stringa");
        String frase2 = scan.nextLine();
        frase2 = frase2.toLowerCase();
        int lunghezza1 = frase1.lenght();
        int lunghezza2 = frase2.lenght();
        for (int i = 0; i < lunghezza1; i++){
            for(int j = 0; j < lunghezza2; j++){
                if(frase1.charAt(i) == frase2.charAt(j)){
                    
                }
            }
        }
        
        
    }
}