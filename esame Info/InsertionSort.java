public class InsertionSort{
    public static void main(String[] args){
         int[] a = {3,5,7,1,2,9,4,10,0,6};
        for (int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }
        for(int i = 1; i < a.length; i++){
            int temp = a[i];
            int j;
            for(j = i; j > 0 && temp < a[j-1]; j--){
                a[j] = a[j-1];
            }
            a[j]  = temp;
        }
        for (int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        } 
    }
}