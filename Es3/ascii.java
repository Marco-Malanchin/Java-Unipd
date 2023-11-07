public class ascii{
    public static void main(String[] arg){
       System.out.println("Questo programma stampa l'intera tabella ascii");
        for(int i = 0; i<=255; i++){
            char valore = (char) i;
            System.out.println("valore " + i + " : " + valore);
        }
        System.exit(0);
    }
}
