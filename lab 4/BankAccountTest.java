import java.util.Scanner;

public class BankAccountTest{
    public static void main(String[] arg){
        Scanner scan = new Scanner(System.in);
        boolean continua = true;
        BankAccount account1 = new BankAccount();
        while(continua == true){
            System.out.println(" I comandi disponibili sono:" + "\n" + "Q (Quit): termina il programma" + "\n" + "B (Balance): visualizza il saldo del conto" + "\n" + "D x (Deposit): versa nel conto la somma x"  + "\n" + "W x (Withdraw): preleva dal conto la somma x"  + "\n" + "A x (Add interest):" + "\n" );
            String risposta =  scan.nextLine();
            risposta = risposta.toUpperCase();
            int lunghezza = risposta.length();
            char comando1 = risposta.charAt(0);
            String comando2 = "";
            double x = 0;
            if(lunghezza > 2 ){
                comando2  = risposta.substring(2);
                x  = Double.parseDouble(comando2);
            }
            if(comando1 == 'Q'){
                System.out.println("Termino il programma");
                continua = false;
                System.exit(0);
            }
            else if(comando1 =='B'){
                System.out.println("Saldo del conto: " + "\n" + account1.getBalance() + "\n");
                continua = true;
            }
            else if(comando1 == 'D' &&  x > 0){
                System.out.println("Aggiungo al  conto: " + "\n" + x + "\n");
                 continua = account1.deposit(x);
                 System.out.println("Saldo del conto: " + "\n" + account1.getBalance() + "\n");
            }
            else if(comando1 == 'W' && x > 0 && x <= account1.getBalance() ){
                 System.out.println("Prelevo dal  conto: " + "\n" + x + "\n");
                 continua = account1.withdraw(x);
                 System.out.println("Saldo del conto: " + "\n" + account1.getBalance() + "\n"); 
            }
            else if(comando1 == 'A' && x > 0){
                System.out.println("Aggiungo al  conto gli interessi: " + "\n" + x + "\n");
                double interessi = account1.getBalance();
                interessi = ((account1.getBalance() * x) / 100);
                 continua = account1.deposit(interessi);
                 System.out.println("Saldo del conto: " + "\n" + account1.getBalance() + "\n"); 
            }
            else{
                continua = true;
            }
        }
    }
}