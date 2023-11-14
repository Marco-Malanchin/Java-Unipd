/*
    L'insieme C dei numeri complessi e' l'insieme delle coppie ordinate (x,y) 
    con x e y appartenenti a R (insieme dei numeri reali).
    Dato il numero complesso z = x + i *y,  i numeri reali x e y sono detti
    parte reale e parte immaginaria di z.
    Nei commenti che seguono, facciamo riferimento ai numeri complessi
        z = x + i*y, z1 = x1 + i*y1, z2 = x2 + i*y2
*/


// Attenzione: 
// 1) Ovviamente il file va rinominato nel file MyComplex.java
// 2) notate che, sebbene i corpi dei metodi non siano ancora  
//    stati scritti, questo codice compila correttamente perche` 
//    abbiamo inserito degli enunciati di return. 


public class MyComplex
{
    private double reale, immaginaria;
    // inizializza il numero complesso al valore 0 + i0 (zero complesso)
    public MyComplex( )
    {
        reale = 0;
        immaginaria = 0;
    }

    // inizializza il numero complesso al valore re + i*im
    public MyComplex(double realPart, double imagPart)
    {
        this.reale = realPart;
        this.immaginaria = imagPart;
    }

    //Somma a questo numero complesso il numero complesso z
    //somma di due complessi: z = z1+z2 = (x1+x2) + i(y1+y2)
    public MyComplex add(MyComplex z)
    {
        double sommaRe = this.reale + z.reale;
        double sommaIm = this.immaginaria + z.immaginaria;
        MyComplex somma = new MyComplex(sommaRe, sommaIm);
        return somma;
    }

    //Sottrae a questo numero complesso il numero complesso z
    //sottrazione di due complessi: z = z1-z2 = (x1-x2) +i(y1-y2)
    public MyComplex sub(MyComplex z)
    {
         double differenzaRe = this.reale -  z.reale;
        double differenzaIm = this.immaginaria - z.immaginaria;
        MyComplex differenza = new MyComplex(differenzaRe, differenzaIm);
        return differenza;
    }

    //Moltiplica questo numero complesso per il numero complesso z
    //prodotto di due complessi: z = z1*z2 = (x1*x2 -y1*y2) + i*(x1*y2 + x2*y1)
    public MyComplex mult(MyComplex z)
    {
        double prodottoRe = (this.reale  *  z.reale) -  (this.immaginaria * z.immaginaria );
        double prodottoIm =  (this.reale  *  z.immaginaria) +  (z.reale - this.immaginaria );
        MyComplex prodotto = new MyComplex(prodottoRe, prodottoIm);
        return prodotto;
    }

    //Divide questo numero complesso per il numero complesso z
    //divisione fra due complessi: z1/z2 = z1 *1/z2, per z2 != 0
    public MyComplex div(MyComplex z)
    {
        double denominatore = Math.pow(z.reale, 2) + Math.pow(z.immaginaria, 2);
        double  risultatoReale = (this.reale * z.reale + this.immaginaria * z.immaginaria) / denominatore;
        double risultatoImmaginario = (this.immaginaria * z.reale - this.reale * z.immaginaria) / denominatore;
        MyComplex divisione = new MyComplex(risultatoReale, risultatoImmaginario);
        return divisione;
    }
          
    //Calcola il coniugato di questo numero complesso
    //coniugato del complesso z:  z^= x - i*y
    public MyComplex conj()
    {
        this.immaginaria = this.immaginaria * (-1);
        MyComplex coniugato = new MyComplex(this.reale, this.immaginaria);
        return coniugato;
    }
          
    //Calcola l'inverso rispetto al prodotto di un numero complesso
    //inverso del complesso z: 1/z = x/(|z|*|z|) -i*y/(|z|*|z|), per z != 0
    public MyComplex inv()
    {
        if (reale != 0 || immaginaria != 0) {
            double denominatore = Math.pow(reale, 2) + Math.pow(immaginaria, 2);

            double parteRealeInversa = reale / denominatore;
            double parteImmaginariaInversa = -immaginaria / denominatore;
            MyComplex inverso = new MyComplex(parteRealeInversa, parteImmaginariaInversa);
            return inverso;
        } else {
            System.out.println("Impossibile invertire zero.");
            return null;  
        }
    }

    //Calcola il modulo di questo numero complesso
    //modulo del complesso z: |z| = sqrt( x*x + y*y).
    public double mod()
    {
        double modulo = Math.sqrt((reale * reale) + (immaginaria + immaginaria));
        return modulo;
    }
           
    //Confronta con tolleranza due numeri complessi.
    public boolean approxEquals(MyComplex z)
    {return false;  //completare
    }

    //Crea una stringa che rappresenta questo numero complesso
    //Formato stringa: parte reale + i*parte immaginaria
    public String toString()
    {
        String z = "";
        z = z + reale + " + i  * " + immaginaria;
        return z;
    }


    //-------- metodi di accesso ----------
          
    //Restituisce la parte complessa di un numero complesso
    public double getIm()
    {
        return immaginaria;
    }
    //Restituisce la parte reale di un numero complesso
    public double getRe()
    {
        return reale;
    }
}