public class Sol5_4
{ public static void main(String[] args){
     Stringa s = new Stringa("Un esercizio davvero facilissimo!"); //Un esercizio davvero facilissimo!
Stringa sa = new Stringa("UUnn "); //UUnn "
 Stringa sb = sa.substring(sa.indexOf(new Stringa("U")),
 sa.lastIndexOf(new Stringa("U"))); //U
 Stringa s2 = new Stringa(""); //""
 s2 = s2.concat(sb);//U
 s2 = s2.concat(sa.substring(2, 3));//Un
 s2 = s2.concat(sa.substring(sa.length()-1));//Un "
 sb = new Stringa("esercizio ");//esercizio
 if (sa.endsWith(new Stringa(" ")))
 s2 = s2.concat(sb);//Un esercizio "
 else
 s2 = s2.concat(sa);//Un Un "
 s2 = s2.concat(s.substring(s.indexOf(new Stringa("d"))));//Un esercizio davvero facilissimo! "
  int pippo = (s.indexOf(new Stringa("d")));
 if (s.compareTo(s2) == 0)
 System.out.println("Collaudo effettuato con successo");
 else
 System.out.println("Collaudo fallito");
    }
}

class Stringa{
    int l;
    private char[] stringa;
    public Stringa(String s){
        this.l = s.length();
        stringa = new char[l];
        for(int i = 0; i < l; i++){
            this.stringa[i] = s.charAt(i);
        }
    }
    public char charAt(int index){
        char risultato = stringa[index];
        return risultato;
    }
    public int compareTo(Stringa s){
        int risultato = 0;
        for(int i = 0; i < s.l; i++){
        risultato = this.stringa[i] - s.stringa[i];
            if(risultato != 0){
                break;
            }
        }
        return risultato;
    }
    public Stringa concat(Stringa s){
        String temp = "";
        for(int i =  0; i < this.l; i++){
            temp = temp + this.stringa[i];
        }
        for(int i = 0; i < s.l; i++){
            temp = temp + s.stringa[i];
        }
        Stringa pippo = new Stringa(temp);
        return pippo;
    }
    public boolean endsWith(Stringa s){
        String temp = "";
        boolean check = false;
            for(int i =  0; i < s.l; i++){
                temp = temp + s.stringa[i];
            }
        Stringa pippo = new Stringa(temp);
        for(int i  = (this.l - pippo.l); i < this.l; i++ ){
            for(int j = 0; j < pippo.l; j++){
                if(this.stringa[i + j] == pippo.stringa[j] ){
                    check = true;
                }
                else{
                    check = false;
                    break;
                }
                break;
            }
        }
         return check;
    }
    public int indexOf(Stringa s){
        String temp = "";
        int index = 0;
        boolean trovato = false;
            for(int i =  0; i < s.l; i++){
                temp = temp + s.stringa[i];
            }
        Stringa pippo = new Stringa(temp);
        for (int i = 0; i < this.l; i++){
   			int j;         
			for(j = 0; j < pippo.l; j++){
                if(this.stringa[i +j] == pippo.stringa[j]){
                    index = i;
                    trovato = true;
                    break;
                }
                else{
                    break;
                }
            }
            if(j == (pippo.l -1) && trovato == true){
                break;
            }
        }
         return index;
    }
    public int indexOf(Stringa s, int fromIndex){
        String temp = "";
        int index = 0;
        boolean trovato = false;
            for(int i =  0; i < s.l; i++){
                temp = temp + s.stringa[i];
            }
        Stringa pippo = new Stringa(temp);
        for (int i = fromIndex; i < this.l; i++){
   			int j;         
			for(j = 0; j < pippo.l; j++){
                if(this.stringa[i +j] != pippo.stringa[j]){
                     index = i;
                    trovato = true;
                    break;
                }
                else{
                    break;
                }
            }
             if(j == (pippo.l -1) && trovato == true ){
                break;
            }
        }
         return index;
    }
    public int lastIndexOf(Stringa s){
        String temp = "";
        int index = 0;
            for(int i =  0; i < s.l; i++){
                temp = temp + s.stringa[i];
            }
        Stringa pippo = new Stringa(temp);
        for (int i = 0; i < this.l; i++){
   			int j;         
			for(j = 0; j < pippo.l; j++){
                if(this.stringa[i +j] != pippo.stringa[j]){
                    break;
                }
                else{
                    index = i+j;
                }
            }
        }
         return index;
    }
    public int lastIndexOf(Stringa s, int fromIndex){
        String temp = "";
        int index = 0;
            for(int i =  0; i < s.l; i++){
                temp = temp + s.stringa[i];
            }
        Stringa pippo = new Stringa(temp);
        for (int i = fromIndex; i < this.l; i++){
   			int j;         
			for(j = 0; j < pippo.l; j++){
                if(this.stringa[i +j] != pippo.stringa[j]){
                    break;
                }
                else{
                    index = i+j;
                }
            }
        }
         return index;
    }
    public int length(){
        int lunghezza = this.l;
        return lunghezza;
    }
    public Stringa substring(int beginIndex){
        String temp = "";
            for(int i =  beginIndex; i < this.l; i++){
                temp = temp + this.stringa[i];
            }
        Stringa tempor = new Stringa(temp);
        return tempor;
    }
     public Stringa substring(int beginIndex, int endIndex){
        String temp = "";
            for(int i =  beginIndex; i < endIndex; i++){
                temp = temp + this.stringa[i];
            }
         Stringa tempor = new Stringa(temp);
        return tempor;
    }
     public void stampa(){
        String temp = "";
            for(int i = 0; i < this.l; i++){
                temp = temp + this.stringa[i];
            }
            System.out.println(temp);
        }
}