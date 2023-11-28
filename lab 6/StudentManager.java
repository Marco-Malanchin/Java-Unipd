import java.util.Scanner;
import java.util.NoSuchElementException;

public class StudentManager{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String studente;
        String cognome;
        double scritto;
        double orale;
        String votoOrale;
        String votoScritto;
        boolean check = false;
        boolean check1 = true;
        Student[]  studenti = new Student[0];
        if(args.length> 0 && args[0] != "studenti.txt"){
             System.out.println("file sbagliato");
            System.exit(1);
        }
        System.out.println("Inserisci l'elenco di studenti ricordando di inserire cognome, voto(scritto), voto(orale) e separarli con il tasto per andare a capo riga, premi control + Z per interrompere l'inserimento degli studenti");
        while(check1 = true){
             studente = scan.nextLine();
             if(studente == ""){
                break;
             }
            int indexCognome = studente.indexOf(" ");
            cognome = studente.substring(0, indexCognome);
            int indexVotoScritto = studente.indexOf(" ", indexCognome + 1);
            votoScritto = studente.substring(indexCognome + 1, indexVotoScritto);
            scritto = Double.valueOf(votoScritto);
            votoOrale = studente.substring(indexVotoScritto + 1);
            orale = Double.valueOf(votoOrale);
            Student studenteSingolo = new Student(cognome, scritto, orale);
            studenti = studenteSingolo.resize(studenti, studenti.length);
            studenteSingolo.add(studenti, studenti.length, studenteSingolo);
        }
        String valore;
        char valore1;
        while(!check){
            System.out.println("PREMI S PER CERCARE UN COGNOME E VEDERE LA MEDIA DEI VOTI" +"\n" + "PREMI Q PER TERMINARE IL PROGRAMMA");
            valore = scan.nextLine();
            valore = valore.toUpperCase();
            valore1 = valore.charAt(0);
            if(valore1 == 'Q'){
                check = true;
            }
            else if(valore1 == 'S'){
                String cognomeTrovare;
                System.out.println("Inserisci cognome da trovare");
                cognomeTrovare = scan.nextLine();
                String maiuscola = cognomeTrovare.substring(0,1);
                maiuscola = maiuscola.toUpperCase();
                cognomeTrovare =  maiuscola + (cognomeTrovare.substring(1));
                boolean trovato = false;
                double media = 0;
                for(int i = 0; i < studenti.length; i++){
                    if( cognomeTrovare.equals(studenti[i].getCognome())){
                        media = (studenti[i].getOrale() +  studenti[i].getScritto())/2;
                        trovato = true;
                        break;
                    }
                }
                if(trovato == true){
                    System.out.println("media:" + media);
                }
                else{
                    System.out.println("Alunno non trovato");
                }
            }
            else{
                System.out.println("Comando errato, digitare comando valido");
                check = false;
            }
        }
         scan.close();
    }
}

class Student{
    private String cognome;
    private double votoOrale;
    private double votoScritto;
    public Student(){
        this.cognome = "";
        this. votoOrale = 0;
        this.votoScritto = 0;
    }
    public Student(String cognome, double votoOrale, double votoScritto){
        this.cognome = cognome;
        this.votoOrale = votoOrale;
        this.votoScritto = votoScritto;
    }
    public Student[] resize(Student[] studenti, int l){
        int lunghezza = l  + 1;
        Student[] studentiNew = new Student[lunghezza];
        for(int i = 0; i < l; i++){
            studentiNew[i] = studenti[i];
        }
        return  studentiNew;
    } 
    public void  add(Student[] studenti, int l, Student pippo){
        studenti[l - 1] = pippo;
    } 
    public String getCognome(){
        return cognome;
    }
    public double getOrale(){
        return votoOrale;
    }
    public double getScritto(){
        return votoScritto;
    }
}