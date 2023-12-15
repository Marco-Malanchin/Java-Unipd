import java.util.Scanner;

public class IterativeBinSearch{
    public static void main(String[] args){
       Scanner scan = new Scanner(System.in);
        String[] parole = new String[3];
        System.out.println("Inserisci le stringhe:");
        boolean controllo = false;    
        int paroleSize = 0;
        while(!controllo){
            String riga = scan.nextLine();
             if(riga == ""){
                    controllo = true;
                    break;
                }
            Scanner frase = new Scanner(riga);
            while(frase.hasNext()){
                String temp = frase.next();
                if(parole.length == paroleSize){
                     parole = resize(parole, 2*parole.length);
                }
                parole[paroleSize++] = temp;
            }
            frase.close();
        }
        riordina(parole, paroleSize);
        System.out.println("Inserisci la parola da trovare");
        String trovare = scan.nextLine();
        scan.close();
        int indice = BinSearch(parole, trovare, paroleSize);
        if(indice == -1){
            System.out.println("parola non trovata");
        }
        else{
            System.out.println("parola trovata in indice: " + indice);
        }
    }
    public static int BinSearch(String[] pippo, String ricerca, int lunghezza){
        boolean trovato = false;
        int inizio = 0;
        int fine = lunghezza;
        int index = -1;
        while(fine >=  inizio){
            int meta = inizio + ( (fine - inizio)/2);
            if(ricerca.compareTo(pippo[meta]) == 0){
                index = meta;
                break;
            }
              if(ricerca.compareTo(pippo[meta]) > 0){
                    inizio = meta + 1;
              }
              if(ricerca.compareTo(pippo[meta]) <  0){
                    fine = meta - 1 ;
              }
        }
        return index;
    }
    public static String[] resize(String[] pippo, int x){
         String[] temp = new String[x];
        System.arraycopy(pippo, 0, temp, 0, pippo.length);
        return temp;
    }
    public static void riordina(String[] pippo, int lunghezza){
        boolean controllo = false;
        while(!controllo){
             boolean scambio = false;
            for(int i = 0; i < lunghezza - 1; i++){
                if(pippo[i].compareTo(pippo[i +1]) > 0){
                    String temp = pippo[i];
                    pippo[i] = pippo[i + 1];
                    pippo[i + 1] = temp;
                    scambio = true;
                }
                if(i == pippo.length || scambio == false){
                    controllo = true;
                }
            }
        }
    }
}
