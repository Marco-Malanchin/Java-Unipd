import java.util.Scanner;

public class Test{
    public static void main(String[] arg){
        Scanner scan = new Scanner(System.in);
        System.out.println("Inserisci nome prodotto 1");
        String  nome1 = scan.nextLine();
        System.out.println("Inserisci prezzo prodotto 1");
        double  prezzo1 = Double.parseDouble(scan.nextLine());
        Product prodotto1 = new Product(nome1, prezzo1);
        System.out.println("Inserisci nome prodotto 2");
        String  nome2 = scan.nextLine();
        System.out.println("Inserisci prezzo prodotto 2");
        double  prezzo2 = Double.parseDouble(scan.nextLine());
        Product prodotto2 = new Product(nome2, prezzo2);
         System.out.println("Inserisci sconto applicabile ai prodotti");
         double sconto = scan.nextDouble();
        System.out.println("Prodotti prima dello sconto:");

        if(prodotto1.getPrice() >prodotto2.getPrice() ){
            System.out.println(prodotto1.getName() + " " +prodotto1.getPrice());
            System.out.println(prodotto2.getName() + " " +prodotto2.getPrice());
            prodotto1.reducePrice(sconto);
            System.out.println("Prodotti dopo lo sconto:");
            if(prodotto1.getPrice() >prodotto2.getPrice() ){
            System.out.println(prodotto1.getName() + " " +prodotto1.getPrice());
            System.out.println(prodotto2.getName() + " " +prodotto2.getPrice());
             }
                else{
                System.out.println(prodotto2.getName() + " " +prodotto2.getPrice());
                System.out.println(prodotto1.getName() + " " +prodotto1.getPrice());
        }
        }
        else{
                System.out.println(prodotto2.getName() + " " +prodotto2.getPrice());
                System.out.println(prodotto1.getName() + " " +prodotto1.getPrice());
                prodotto2.reducePrice(sconto);
                System.out.println("Prodotti dopo lo sconto:");
                 if(prodotto1.getPrice() >prodotto2.getPrice() ){
            System.out.println(prodotto1.getName() + " " +prodotto1.getPrice());
            System.out.println(prodotto2.getName() + " " +prodotto2.getPrice());
             }
                else{
                System.out.println(prodotto2.getName() + " " +prodotto2.getPrice());
                System.out.println(prodotto1.getName() + " " +prodotto1.getPrice());
        }
        }
    }
}