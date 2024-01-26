public class SelectionSort{
    public static void main(String[] args){
        int[] a = {3,5,7,1,2,9,4,10,0,6};
        for (int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }
       for(int i = 0; i<a.length - 1; i++){
            int pos = i;
            for(int j = pos + 1; j < a.length; j++){//trovo il numero più piccolo e riassegno la posizione
                if(a[j] < a[pos]){
                    pos = j;
                }
            }
            if(pos != i){
                int temp = a[i];
                a[i] = a[pos];
                a[pos] = temp;
            }
       }
        for (int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }
    }
}