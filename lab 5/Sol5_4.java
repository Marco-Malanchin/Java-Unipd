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
    public Stringa(int i){
        this.l = i;
        stringa = new char[i];
        for(int j = 0; j < i; j++){
            this.stringa[j] = ' ';
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
        int lunghezza = this.l + s.l;
        Stringa pippo = new Stringa(lunghezza);
        for(int i =  0; i < this.l; i++){
            pippo.stringa[i] = this.stringa[i];
        }
        for(int i = this.l, j = 0; i < lunghezza && j < s.l; i++, j++){
            pippo.stringa[i] = s.stringa[j];
        }
        return pippo;
    }
    public boolean endsWith(Stringa s){
        Stringa pippo = new Stringa(s.l);
        boolean check = false;
            for(int i =  0; i < s.l; i++){
                pippo.stringa[i] = s.stringa[i];
            }
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
        Stringa pippo = new Stringa(s.l);
        int index = 0;
        boolean trovato = false;
            for(int i =  0; i < s.l; i++){
                pippo.stringa[i] = s.stringa[i];
            }
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
        Stringa pippo = new Stringa(s.l);
        int index = 0;
        boolean trovato = false;
            for(int i =  0; i < s.l; i++){
                pippo.stringa[i] = s.stringa[i];
            }
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
        Stringa pippo = new Stringa(s.l);
        int index = 0;
            for(int i =  0; i < s.l; i++){
                pippo.stringa[i] =  s.stringa[i];
            }
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
        Stringa pippo = new Stringa(s.l);
        int index = 0;
            for(int i =  0; i < s.l; i++){
                pippo.stringa[i] = s.stringa[i];
            }
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
        int lunghezza = this.l - beginIndex;
        Stringa pippo = new Stringa(lunghezza);
            for(int i =  beginIndex, j = 0; i < this.l && j< lunghezza; i++ , j++){
                pippo.stringa[j] = this.stringa[i];
            }
        return pippo;
    }
     public Stringa substring(int beginIndex, int endIndex){
            int lunghezza = endIndex - beginIndex;
             Stringa pippo = new Stringa(lunghezza);
            for(int i =  beginIndex, j = 0; i < endIndex && j< lunghezza; i++, j++){
                pippo.stringa[j] = this.stringa[i];
            }
        return pippo;
    }
     public void stampa(){
        String temp = "";
            for(int i = 0; i < this.l; i++){
                temp = temp + this.stringa[i];
            }
            System.out.println(temp);
        }
}