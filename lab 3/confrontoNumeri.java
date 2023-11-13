import java.util.Scanner;

public class confrontoNumeri{
    public static void main(String[] arg){
        Scanner scan = new Scanner(System.in);
        System.out.println("Inserisci numero 1");
        double num1 = scan.nextDouble();
        double arrotondo1 = Math.round(num1 * 100.0) / 100.0;
        double num2;
        do{
            System.out.println("Inserisci numero 2 minore di numero1");
             num2 = scan.nextDouble();
        }
        while(num2 > num1);
        double arrotondo2 = Math.round(num2 * 100.0) / 100.0;
        final double differenza = 0.01;
        if((arrotondo1 - arrotondo2)<= differenza){
            System.out.println("Approssimativamente  uguali");
            System.exit(0);
        }
        else{
             System.out.println("Non approssimativamente  uguali");
             System.exit(0);
        }
    }
}