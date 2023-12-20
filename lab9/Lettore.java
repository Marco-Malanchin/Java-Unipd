import java.util.Scanner;

public class Lettore{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int size = 0;
        Riga[] testo = new Riga[10];
        System.out.println("Inserisci le righe da analizzare, valgono anche le righe vuote. \nPer terminare il programma premere CTR + Z.");
        while(scan.hasNextLine()){
            if(size ==  testo.length){
                testo = resize(testo, 2*testo.length);
            }
            String riga = scan.nextLine();
            Riga pippo = new Riga();
            if(riga == ""){
                String temp1 = "";
                int x = 0;
                pippo.setCaratteri(x);
                pippo.setContatre(x);
                pippo.setParole(temp1);
                testo[size] = pippo;
                size++;
            }
            else{
                pippo.parole = riga;
                Scanner line = new Scanner(riga);
                while(line.hasNext()){
                    String parola = line.next();
                    pippo.caratteri += parola.length();
                    pippo.contatore++;
                }
                testo[size] = pippo;
                size++;
            }
        }
        riordina(testo, size);
         System.out.println("Righe dopo essere state ordinate:\n");
        for (int i = 0; i < size; i++){
            System.out.println(testo[i].getParole());
        }
    }
    public static Riga[] resize(Riga[] e, int l){
        Riga[] temp = new Riga[l];
        System.arraycopy(e, 0, temp, 0, e.length);
        return temp;
    }
    public static void riordina(Riga[] e, int size){
       for(int i = 0; i < size - 1; i++) {
            boolean flag = false;
            if(size == 1){
                break;
            }
            for(int j = 0; j < size - 1; j++){
                if(e[j].getContatore() > e[j+1].getContatore()){
                  Riga temp = new Riga();
                   temp = e[j];
                    e[j] = e[j+1];
                    e[j+1] = temp;
                    flag = true;
                }
                else if(e[j].getContatore() ==  e[j+1].getContatore()){
                    if(e[j].getCaratteri() >  e[j+1].getCaratteri()){
                         Riga temp = new Riga();
                        temp = e[j];
                        e[j] = e[j+1];
                        e[j+1] = temp;
                        flag = true;
                    }
                    else if(e[j].getCaratteri() ==  e[j+1].getCaratteri()){
                        String temp1 = e[j].getParole();
                        String temp2 = e[j+1].getParole();
                        if((temp1.compareTo(temp2)) > 0){
                            Riga temp = new Riga();
                            temp = e[j];
                            e[j] = e[j+1];
                            e[j+1] = temp;
                            flag = true;
                        }
                    }
                }
            }
            if(!flag){
                break;
            }
        }
    }
}
class Riga{
    int contatore;
    String parole;
    int caratteri;
    public Riga(){
        contatore = 0;
        parole = "";
        caratteri = 0;
    }
    public String getParole(){
        return parole;
    }
     public void setParole(String e){
        this.parole = e;
    }
    public void setContatre(int e){
        this.contatore = e;
    }
    public void setCaratteri(int e){
        this.caratteri = e;
    }
    public int getContatore(){
        return contatore;
    }
    public int getCaratteri(){
        return caratteri;
    }
}