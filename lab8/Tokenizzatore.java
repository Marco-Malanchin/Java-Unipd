import java.util.Scanner;
import java.io.*;

public class Tokenizzatore{
    public static void main(String[] args) throws IOException{
        if(args.length != 2){
            System.out.println("Numero di parametri passati errato\n Inserisci un file di Input e un file di Output" );
            System.exit(1);
        }
        FileReader reader = new FileReader(args[0]);
        Scanner scan = new Scanner(reader);
        FileWriter writer = new FileWriter(args[1]);
        PrintWriter pr = new PrintWriter(writer);
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            Scanner riga = new Scanner(line);
            riga.useDelimiter(" ");
            String temp = "";
            while(riga.hasNext()){
                String parola = riga.next();
                char primoCarattere = parola.charAt(0);
                primoCarattere = Character.toUpperCase(primoCarattere);
                String parteRimanente = parola.substring(1);
                parteRimanente = parteRimanente.toLowerCase();
                parola = primoCarattere + parteRimanente;
                parola = parola + " ";
                temp = temp + parola;
            }
            pr.println(temp);
        }
        reader.close();
        scan.close();
        writer.close();
        pr.close();
    }
}