public class Product{
     public Product(String name, double price){
           this. name = name;
            this.price = price;
     }
     public String getName(){
            return name;
     }
      public double getPrice(){
        return price;
     }
      public void reducePrice(double rate){
        price =price - ( price * rate/100);
     }
     private String name;
     private double price;
}