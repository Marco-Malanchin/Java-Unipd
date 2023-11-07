public class multipli2{
    public static void main(String[] arg){
        int minX = 10,  maxX = 100;
        for(int i = maxX; i>=minX; i--){
            if((i%5)==0){
                System.out.println(i);
            }
        }
        System.exit(0);
    }
}