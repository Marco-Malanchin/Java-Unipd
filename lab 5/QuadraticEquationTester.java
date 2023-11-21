import java.util.Scanner;
import java.util.InputMismatchException;

public class QuadraticEquationTester{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		boolean controllo1 = false;
		boolean controllo2 = false;
		boolean controllo3 = false;
		double a = 0;
		double b = 0;
		double c = 0;
		while(controllo1 == false){
			try{
				System.out.println("Inserisci il valore del membro ax^2: ");
				a = scan.nextDouble();
				controllo1 = true;
			}
			catch(InputMismatchException e){
				System.out.println("Inserisci un valore valido");
				scan.nextLine();
			}
		}
		while(controllo2 == false){
			try{
				System.out.println("Inserisci il valore del membro bx: ");
				b = scan.nextDouble();
				controllo2 = true;
			}
			catch(InputMismatchException e){
				System.out.println("Inserisci un valore valido");
				scan.nextLine();
			}
		}
		while(controllo3 == false){
			try{
				System.out.println("Inserisci il valore del membro c: ");
				c = scan.nextDouble();
				controllo3 = true;
			}
			catch(InputMismatchException e){
				System.out.println("Inserisci un valore valido");
				scan.nextLine();
			}
		}
		QuadraticEquation funzione = new QuadraticEquation(a, b, c);
		int casi = funzione.getCase(funzione);
		if(casi == 0){
			System.out.println("La funzione non ha soluzioni");
		}
		else if(casi == 3){
			System.out.println("La funzione ha infinite soluzioni");
		}
		else if(casi == 1){
			double soluzione1 = funzione.getSolution3(funzione);
			System.out.println("La funzione ha soluzione: " + "\n" + soluzione1);
		}
		else if(casi == 2){
			double soluzione1 = funzione.getSolution1(funzione);
			double soluzione2 = funzione.getSolution2(funzione);
			System.out.println("La funzione ha soluzioni: " + "\n" + soluzione1 + "\n" + soluzione2 );
		}
		
		scan.close();
	}
}

class QuadraticEquation
{                               
	private double acoeff;
	private double bcoeff;
	private double ccoeff;
	
    public QuadraticEquation()
    {
      acoeff = 0;
      bcoeff = 0;
      ccoeff = 0;
    }

    public QuadraticEquation(double acoeff, double bcoeff, double ccoeff)
    {

        this.acoeff = acoeff;
        this.bcoeff = bcoeff;
        this.ccoeff = ccoeff;

    }
    
    public int getCase(QuadraticEquation z){
    	int controllo = 2;
    	if((z.acoeff == z.bcoeff) && (z.bcoeff == 0) && (z.ccoeff != 0)){
    		controllo = 0;
    	}
    	else if((z.acoeff == 0) && (z.bcoeff != 0)){
    		controllo = 1;
    		
    	}
    	else if((z.acoeff == z.bcoeff) && (z.bcoeff == z.ccoeff) && (z.ccoeff == 0)){
    		controllo = 3;
    		
    	}
    	else{
    		controllo = 2;
    		
    	}
    	return controllo;
    }
    public double getSolution3(QuadraticEquation z){
    	double solution3 = (-z.ccoeff) / z.bcoeff;
    	return solution3;
    }
    public double getSolution1(QuadraticEquation z)
    {
        double solution1 = (-z.bcoeff + (Math.sqrt((Math.pow(z.bcoeff , 2)) - (4 * z.acoeff * z.ccoeff)))) / (2 * z.acoeff);
        return solution1;
    }
    
    public double getSolution2(QuadraticEquation z)
    {
        double solution2 = (-z.bcoeff - (Math.sqrt((Math.pow(z.bcoeff , 2)) - (4 * z.acoeff * z.ccoeff)))) / (2 * z.acoeff);
        return solution2;
    }
    
}
