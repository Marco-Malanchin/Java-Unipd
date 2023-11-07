public class potenze{
    public static void main(String[] arg){
        int minX = 1, minY = 1, maxX = 4, maxY = 5;
        for(int i = minX; i<=maxX; i++){
            for(int j = minY; j<=maxY; j++ ){
                double potenza = Math.pow(i,j);
                System.out.println(potenza);
            }
        }
        System.exit(0);
    }
}