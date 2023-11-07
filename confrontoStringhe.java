import java.util.Scanner;
public class confrontoStringhe{
    public static void main(String[] arg){
      Scanner scan = new Scanner(System.in);
        System.out.println("inserisci la prima stringa");
        String string1 = scan.nextLine();
        System.out.println("inserisci la seconda stringa");
        String string2 = scan.nextLine();
        System.out.println("inserisci la terza stringa");
        String string3 = scan.nextLine();
        System.out.println("\n");
        if((string1.compareTo(string2) < 0) && (string2.compareTo(string3) < 0)){
             System.out.println(string1);
             System.out.println(string2);
             System.out.println(string3);
        }
        else if((string2.compareTo(string1) < 0) && (string1.compareTo(string3) < 0)){
             System.out.println(string2);
             System.out.println(string1);
             System.out.println(string3);
        }
        else if((string3.compareTo(string1) < 0) && (string1.compareTo(string2) < 0)){
             System.out.println(string3);
             System.out.println(string1);
             System.out.println(string2);
        }
        else if((string3.compareTo(string2) < 0) && (string2.compareTo(string1) < 0)){
             System.out.println(string3);
             System.out.println(string2);
             System.out.println(string1);
        }
        else if((string3.compareTo(string2) < 0) && (string2.compareTo(string1) < 0)){
             System.out.println(string3);
             System.out.println(string2);
             System.out.println(string1);
        }
        else if((string1.compareTo(string3) < 0) && (string3.compareTo(string2) < 0)){
             System.out.println(string1);
             System.out.println(string3);
             System.out.println(string2);
        }
        System.exit(0);
    }
}