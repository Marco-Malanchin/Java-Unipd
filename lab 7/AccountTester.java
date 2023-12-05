public class AccountTester
{
    public static void main(String[] args)
    { 
        // test metodi di BankAccount
        BankAccount a = new BankAccount();
        testAccount(a);

        // test metodi di SavingsAccount
        a = new SavingsAccount(.5);
        testAccount(a);

        // test metodi di CheckingAccount
        a = new CheckingAccount();
        testAccount(a);
    }
    

    // Metodo statico ausiliario per effettuare il collaudo con operazioni
    // diverse a seconda del tipo dell'oggetto a cui punta il riferimento a
    private static void testAccount(BankAccount a)
    {
        System.out.println("\n********** Collaudo di " + a.getClass().getName()
                            +"**********");

        /*  Le seguenti operazioni di versamento e prelievo vengono effettuate
            qualunque sia il tipo dell'oggetto. Pero` i risultati possono 
            cambiare di volta in volta, per il polimorfismo 
        */
        a.deposit(1000);
        System.out.println("Stato dopo Versamento:\n     " + a);
        a.withdraw(500);
        System.out.println("Stato dopo Prelievo:\n     " + a);

        BankAccount newa = null; 


        //Le seguenti operazioni si possono eseguire solo se l'oggetto e`...

        if (a instanceof SavingsAccount)  //... di tipo SavingsAccount
        {   SavingsAccount sa = (SavingsAccount) a;
            sa.addInterest();
            System.out.println("Interessi fine mese:\n     " + a);
            newa = new SavingsAccount(sa.getBalance(), sa.getInterestRate()); 
        }
        else if (a instanceof CheckingAccount) //... di tipo CheckingAccount
        {   CheckingAccount ca = (CheckingAccount) a;   
            for (int i = 0; i < 5; i++)     //facciamo un po' 
                {   ca.deposit(100);        // di operazioni
                    ca.withdraw(100);       // a saldo nullo
                }
            System.out.println("Effettuate " + ca.getTransactionCount() +
                                " operazioni, di cui " + ca.FREE_TRANSACTIONS + 
                                " operazioni gratuite");
            ca.deductFees();
            System.out.println("Addebito operazioni:\n     " + a);
            newa = new CheckingAccount(ca.getBalance(),ca.getTransactionCount());
        }
        else  // ... di tipo BankAccount
            newa = new BankAccount(a.getBalance());



        /*  Ora il riferimento newa punta ad un oggetto identico a quello
            puntato da a, perche` lo abbiamo costruito inizializzandolo con lo
            stato attuale di a
        */
        System.out.println();
        System.out.println("Stato attuale del conto a:\n     " +a);
        System.out.println("Stato del nuovo conto newa:\n     " +newa);
        System.out.println("Check di uguaglianza: " + a.equals(newa));

        //modifichiamo i due conti trasferendo soldi dall'uno all'altro
        a.transfer(100, newa);
        System.out.println("Stato del conto a dopo bonifico:\n     " +a);
        System.out.println("Stato del conto newa dopo bonifico:\n     "+newa);
        System.out.println("Check di uguaglianza: " + a.equals(newa));

    }
}
class BankAccount
{
    public BankAccount()
    {
        balance = 0;
    }

    public BankAccount(double initialBalance)
    {   
        deposit(initialBalance);
    }

    public void deposit(double amount)
    {
        if (amount <= 0)
            throw new IllegalArgumentException();
        balance = balance + amount;
    }

    public void withdraw(double amount)
    {
        if (amount > balance || amount <= 0)
            throw new IllegalArgumentException();
        balance = balance - amount;
    }

    public void transfer(double amount, BankAccount other)
    { 
        withdraw(amount);
        other.deposit(amount);
    }


    // ------- metodi di accesso --------

    public double getBalance()
    {   
        return balance;
    }


    // ------ metodi di Object da sovrascrivere ---------
    // ......... toString e equals ......................
    public String toString(){
        return "BankAccount[balance = " + this.balance  + "]";
    }
    public boolean equals(BankAccount a){
        if(this.getBalance() == a.getBalance()){
            return true;
        }
        else{
            return false;
        }
    }


    // -------- campi di esemplare ---------

    private double balance;
}
class SavingsAccount extends BankAccount
{  
    public SavingsAccount(double rate)
    {
        super();               // costruttore della superclasse
        interestRate = rate;
    }

    public SavingsAccount(double initialBalance, double rate)
    {
        super(initialBalance); // costruttore della superclasse
        interestRate = rate;
    }

    //accredita gli interessi al termine del mese. Attenzione: usa il metodo
    //deposit della superclasse, altrimenti verrebbe addebitata la penale FEE
    public void addInterest()     //NUOVO METODO
    {
        super.deposit(getBalance() * interestRate / 100);
    }


    // ------- metodi di accesso --------

    public double getInterestRate()
    {   
        return interestRate;
    }


    // ------ metodi di Object sovrascritti ---------
    // ........... toString, equals .................
     public String toString(){
        return "SavingsAccount[balance = " + this.getBalance() + ",  interestRate = " + this.interestRate + "]";
    }
    public boolean equals(SavingsAccount a){
        if((this.getBalance() == a.getBalance()) && (this.getInterestRate() == a.getInterestRate())){
            return true;
        }
        return false;
    }


    //-------- nuovi campi di esemplare ----------------

    private double interestRate;
}
class CheckingAccount extends BankAccount
{
    public CheckingAccount()
    {
        super();               // costruttore della superclasse
        transactionCount = 0;  // azzera conteggio transaz.
    }

    public CheckingAccount(double initialBalance)
    {
        super(initialBalance); // costruttore della superclasse
        transactionCount = 0;  // azzera conteggio transaz.
    }

    public CheckingAccount(double initialBalance, int initialTransCount)
    {
        super(initialBalance); // costruttore della superclasse
        transactionCount = initialTransCount; // transazioni iniziali
    }

    public void deposit(double amount)  //SOVRASCRITTO
    {
        super.deposit(amount); // aggiungi amount al saldo
        transactionCount++;        
    }

    public void withdraw(double amount) //SOVRASCRITTO
    {
        super.withdraw(amount); // sottrai amount dal saldo
        transactionCount++;
    } 

    //applica le commissioni sulle operazioni in eccedenza
    public void deductFees()  //NUOVO METODO
    {
        if (transactionCount > FREE_TRANSACTIONS)
        {
            double fees = TRANSACTION_FEE *
                            (transactionCount - FREE_TRANSACTIONS);
            super.withdraw(fees);
        }
        transactionCount = 0;
    }


    // ------- metodi di accesso --------

    public int getTransactionCount()
    {
        return transactionCount;
    }



    // ------ metodi di Object sovrascritti ---------
    // ........... toString, equals .................
    public String toString(){
        return "CheckingAccount[balance = " + this.getBalance()  + ",   transactionCount = " + this.transactionCount +" ,  FREE_TRANSACTIONS = " +  this.FREE_TRANSACTIONS + " , TRANSACTION_FEE = " + this.TRANSACTION_FEE +  "]";
    }
    public boolean equals(CheckingAccount a){
        if((this.getBalance() == a.getBalance()) && (this.getTransactionCount() == a.getTransactionCount()) && (this.FREE_TRANSACTIONS == a.FREE_TRANSACTIONS) && (this.TRANSACTION_FEE == a.TRANSACTION_FEE)){
            return true;
        }
        return false;
    }



    //-------- nuovi campi di esemplare e variabili statiche ----------------
    private int transactionCount;
    public static final int FREE_TRANSACTIONS = 3;
    public static final double TRANSACTION_FEE = 2.0;

}