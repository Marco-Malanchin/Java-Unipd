public class BankAccount{
      public BankAccount(){
         this. balance = 0;
     }
    public double getBalance(){
          return balance;
   }
   public boolean deposit(double amount){
      if (amount > 0)
      {  balance += amount;
         return true;
      } 
      return false;
   }
   public boolean withdraw(double amount){  
    if (amount > 0 && amount <= getBalance())
      {  balance -= amount;
         return true;
      }
      return false;
   }

   private double balance;

}