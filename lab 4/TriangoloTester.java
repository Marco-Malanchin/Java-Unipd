import java.util.Scanner;
import java.util.Locale;

public class TriangoloTester
{
   public static void main (String[] args)
   {
      Scanner in = new Scanner(System.in);
      in.useLocale(Locale.US);

      // lettura dei dati da Standard Input
      System.out.print ("Introduci lati a, b, c: ");
      double a = in.nextDouble();
      double b = in.nextDouble();
      double c = in.nextDouble();

      // creazione di una istanza del triangolo
      Triangolo triangolo = new Triangolo(a, b, c);

      // emissione a Standard Output dell'elaborazione
      System.out.println(triangolo +  ": " + triangolo.info());
      System.out.println("area = " + triangolo.area());
      System.out.println("h = " + triangolo.h());
   }
}
class Triangolo{
  //... campi di esemplare... da completare
  //...
   double la, lb, lc;
   /*
      Construttore della classe Triangolo
   */
   public Triangolo (double la, double lb, double lc)
   {
	this.la = la;
    this.lb = lb;
    this.lc = lc;
   }

   /*
      restituisce informazioni sul triangolo. le informazioni sono relative
      ai lati:     equilatero,  isoscele,    scaleno.
      agli angoli: acutangolo,  rettangolo,  ottusangolo.
      Esempio: per il triangolo di lati 3, 4, 5 restituisce la stringa
      "scaleno rettangolo".
   */
   public String info(){
        String triangolo = "";
	    if(la == lb && lb  == lc){
            double angoloEq = (lc * lc) - (la * la) - (lb * lb);
            if (angoloEq < 0){
                triangolo = "Acutangolo" +  " Equilatero";
            }
            else if(angoloEq == 0){
                 triangolo =  "Rettangolo" + " Equilatero";
            }
            else if (angoloEq > 0){
                triangolo =  "Ottusangolo" + " Equilatero";
            }
        }
            else if((la == lb && la != lc) || (la == lc && la != lb) || (lc == lb && lc != la)){
                double angoloEq = (lc * lc) - (la * la) - (lb * lb);
                if (angoloEq < 0){
                    triangolo =  "Acutangolo" + "  Isoscele";
                }
                else if(angoloEq == 0){
                    triangolo =  "Rettangolo" + "  Isoscele";
                }   
                else if (angoloEq > 0){
                    triangolo =  "Ottusangolo" +  "  Isoscele";
                }
            }
            else if(la != lb && la != lc && lb != lc){
                double angoloEq = (lc * lc) - (la * la) - (lb * lb);
                if (angoloEq < 0){
                    triangolo =  "Acutangolo" + " Scaleno";
                }    
                else if(angoloEq == 0){
                    triangolo =  "Rettangolo" + "  Scaleno";
                }   
                else if (angoloEq > 0){
                    triangolo =  "Ottusangolo" +  "  Scaleno";
                }
            }
         return triangolo;
    }

   /*
      restituisce una stringa contenente una descrizione testuale dell'oggetto
      nel formato T(a, b, c)
      Esempio "T(3, 4, 5)"
   */
   public String toString ()
   {
         String triangolo = "";
        triangolo = String.valueOf(la) + String.valueOf(lb) + String.valueOf(lc);
        return triangolo;
   }

    /*
       calcola e restituisce l'area del triangolo.
       Usa la formula di Erone:
            area * area = p * (p - a) * (p - b) * (p - c)
       dove p e` il semiperimetro, ovvero p = (a + b + c) / 2
    */
    public double area()
    {
            double p = (la + lc + lb) / 2;
            double areaT = Math.sqrt(p * (p - la) * (p - lb) * (p - lc));
            return areaT;
    }

    /*
       calcola e restituisce l'altezze del triangolo relativa al lato maggiore:
    */
    public double h()
    {
        double altezza = 0;
        if(la > lb && lb > lc){
            double p = (la + lc + lb) / 2;
            double areaT = Math.sqrt(p * (p - la) * (p - lb) * (p - lc));
            altezza = (areaT * 2) / la;
        }
        if(lc > lb && lb > la){
            double p = (la + lc + lb) / 2;
            double areaT = Math.sqrt(p * (p - la) * (p - lb) * (p - lc));
            altezza = (areaT * 2) / lc;
        }
        if(lb > lc && lc > la){
            double p = (la + lc + lb) / 2;
            double areaT = Math.sqrt(p * (p - la) * (p - lb) * (p - lc));
            altezza = (areaT * 2) / lb;
        }
         return altezza;
    }
}