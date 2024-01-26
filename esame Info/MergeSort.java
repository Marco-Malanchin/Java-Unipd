public class MergeSort{
    public static void main(String[] args){
        int[] a = {3,5,7,1,7,9,4,10,0,6};
        for (int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }
        ordinamentoPerFusione(a);
        for (int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }
    }
    public static void ordinamentoPerFusione(int[] a){
        if( a.length < 2){
            return; //c aso base
        }
        int mid = (1 + a.length) / 2;
        int[] left = new int[mid];
        int[] rigth = new int[a.length - mid]; //creo due array dividendo l'array principale a metà
        System.arraycopy(a, 0, left, 0, mid);
        System.arraycopy(a, mid, rigth, 0, a.length - mid); //copio gli elementi
        ordinamentoPerFusione(left);//ricorsione doppia
        ordinamentoPerFusione(rigth);
        merge(a, left, rigth);// fondo gli array
    } 
    private static void merge(int[] a, int[ ] b, int[] c){
        int ai = 0; int bi = 0; int ci = 0; 
        while(bi < b.length && ci < c.length){// ficnhe non supero con i contatori la lunghezza degli array, faccio il confronto
            if(b[bi] < c[ci]){
                a[ai++] = b[bi++];
            }
            else{
                 a[ai++] = c[ci++];
            }
        }
        while(bi < b.length){ // se gli elemnti di c finiscono mentre quelli di b no, continuo a copiare gli elementi
            a[ai++] = b[bi++];
        }
        while(ci < c.length){ // caso contrario;
            a[ai++] = c[ci++];
        }
    }
}