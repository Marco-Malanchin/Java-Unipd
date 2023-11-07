import java.util.Scanner;

public class annoBisestile{
    public static void main(String[] arg){
        Scanner scan = new Scanner(System.in);
        int anno;
        do{
            System.out.println("inserisci un anno positivo");
            anno = scan.nextInt();
        }
        while(anno < 0);
        if( anno < 1582){
            if((anno % 4) == 0){
                System.out.println("anno bisestile");
                System.exit(0);
            }
            else{
                System.out.println("anno non bisestile");
                 System.exit(0);
            }
        }
        else{
                if((anno % 4) == 0){
                    if(((anno % 100) == 0) && ((anno % 400) == 0)){
                         System.out.println("anno bisestile");
                         System.exit(0);
                    }
                    else if(((anno % 100) == 0) && ((anno % 400) != 0)){
                         System.out.println("anno non bisestile");
                         System.exit(0);
                    }
                    else{
                        System.out.println("anno bisestile");
                         System.exit(0);
                    }
                }
                else{
                     System.out.println("anno non bisestile");
                         System.exit(0);
                }
            }
        }
}