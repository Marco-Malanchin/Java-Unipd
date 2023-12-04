import java.util.Scanner;

public class RicorsioneInverso{
    public static void main(String[] args){
        if (args.length != 0){
            System.out.println(inverti(args[0]));
        }
        else{
            System.exit(1);
        }
    }
    public static String inverti(String s){
        if(s == null){
            throw new IllegalArgumentException("Non posso invertire una stringa vuota");
        }
        if(s.length() < 2){
            return s;
        }
        return s.charAt(s.length() - 1) + inverti(s.substring(0,s.length()-1));
    }
} 