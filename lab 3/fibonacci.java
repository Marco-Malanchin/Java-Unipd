import java.util.Scanner;
public class fibonacci{
    public static void main(String[] arg){
        Scanner scan = new Scanner(System.in);
        int n;
        do{
            System.out.println("Inserisci un valore n che indichera' quanto avanti la sequenza di Fibonocci dovra' andare avanti");
            n = scan.nextInt();
        }while(n <0);
        int valore1 = 1 ;
       int  valore2 = 1 ;
       int valoreN;
            if(n == 0 || n == 1 || n == 2){
                valoreN = 1;
                System.out.println("Il valore della sequenza e' "+ valoreN);
                System.exit(0);
            }
            else if(n > 2){
                  valore1 = 1 ;
                  valore2 = 1 ;
                  valoreN = 2;
                  for(int i = 2; i < n; i++){
                    valore1 = valore2;
                    valore2 = valoreN;
                    valoreN = valore1 + valore2;
                  }
                  System.out.println("Il valore della sequenza e' "+ valoreN);
                  System.exit(0);
            }
        }
    }