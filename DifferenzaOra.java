import java.util.Scanner;
public class DifferenzaOra{
	public static void main(String[] arg){
		Scanner ora = new Scanner(System.in);
		System.out.println("Inserisci il primo orario");
		int orario1 = ora.nextInt();
		if(orario1 > 2400){
			System.out.println("orario inserito erroneamente, le ore non possono superare le 24:00");
			 System.exit(1);
		}
		else if(orario1 < 0){
			System.out.println("orario inserito erroneamente, le ore non possono essere negative");
			 System.exit(1);
		}
		else{
			String ora1 = "" + orario1;
			if(orario1 < 100){
				ora1 = "00" + ora1;
			}
			else if(orario1 < 1000){
				ora1 = "0" + ora1;
			}
				String parteOra1 = ora1.substring(0,2);
				String parteMinuti1 = ora1.substring(2,4);
				int minuti1 = Integer.valueOf(parteMinuti1);
				if(minuti1 > 59){
					System.out.println("Errore, la parte dei minuti non puo' superare 59");
					 System.exit(1);
				}
				else{
					System.out.println("Inserisci il secondo orario");
					int orario2 = ora.nextInt();
					if(orario2 > 2400 ){
						System.out.println("orario inserito erroneamente,  le ore non possono superare le 24:00");
						 System.exit(1);
					}
					else if(orario2 == orario1){
						System.out.println("i due orari coincidono, inserisci due orari differenti");
						 System.exit(1);
					}
					else if(orario2 < 0){
						System.out.println("orario inserito erroneamente, le ore non possono essere negative");
						 System.exit(1);
					}
					else{
						String ora2 = ""+ orario2;
						if(orario2 < 100){
							ora2 = "00" + ora2;
						}
						else if(orario2 < 1000){
							ora2 = "0" + ora2;
						}
							String parteOra2 = ora2.substring(0,2);
							String parteMinuti2 = ora2.substring(2,4);
							int minuti2 = Integer.valueOf(parteMinuti2);
							if(minuti2 > 59){
								System.out.println("Errore, la parte dei minuti non puo' superare 59");
								 System.exit(1);
							}
							else{
								int orarioOre1 = Integer.valueOf(parteOra1);
								int orarioOre2 = Integer.valueOf(parteOra2);
								if(orarioOre1 < orarioOre2  &&  minuti1 < minuti2 ){
										int differenzaOra = orarioOre2 - orarioOre1;
										int differenzaMinuti =  minuti2 - minuti1;
										ora1 = parteOra1 + ":" + parteMinuti1;
										ora2 = parteOra2 + ":" + parteMinuti2;
										System.out.println("Orario 1 : " + ora1 + "\n" + "Orario 2 : " + ora2 + "\n" + "Differenza ore: " + differenzaOra + "\n" + "Differenza minuti: " + differenzaMinuti);
										 System.exit(0);
								}
								else if(orarioOre1 < orarioOre2  && minuti1 > minuti2){
										int differenzaOra = (orarioOre2 - orarioOre1) - 1;
										int differenzaMinuti = (60 - minuti1) + minuti2;
										/*if(differenzaMinuti > 59){
											differenzaMinuti = differenzaMinuti - 60;
											differenzaOra = differenzaOra - 1;
										}*/
										ora1 = parteOra1 + ":" + parteMinuti1;
										ora2 = parteOra2 + ":" + parteMinuti2;
										System.out.println("Orario 1 : " + ora1 + "\n" + "Orario 2 : " + ora2 + "\n" + "Differenza ore: " + differenzaOra + "\n" + "Differenza minuti: " + differenzaMinuti);
										 System.exit(0);
								}
								else if(orarioOre1 > orarioOre2 &&  minuti1 < minuti2 ){
										int differenzaOra = (24 - orarioOre1) + orarioOre2;
										int differenzaMinuti =  minuti2 - minuti1;
										ora1 = parteOra1 + ":" + parteMinuti1;
										ora2 = parteOra2 + ":" + parteMinuti2;
										System.out.println("Orario 1 : " + ora1 + "\n" + "Orario 2 : " + ora2 + "\n" + "Differenza ore: " + differenzaOra + "\n" + "Differenza minuti: " + differenzaMinuti);
										 System.exit(0);
								}
								else if(orarioOre1 > orarioOre2 &&  minuti1 > minuti2 ){
										int differenzaOra = ((24 - orarioOre1) + orarioOre2)-1;
										int differenzaMinuti = (60 - minuti1) + minuti2;
										ora1 = parteOra1 + ":" + parteMinuti1;
										ora2 = parteOra2 + ":" + parteMinuti2;
										System.out.println("Orario 1 : " + ora1 + "\n" + "Orario 2 : " + ora2 + "\n" + "Differenza ore: " + differenzaOra + "\n" + "Differenza minuti: " + differenzaMinuti);
										 System.exit(0);
								}
								else if(orarioOre1 == orarioOre2 &&  minuti1 < minuti2 ){
										int differenzaOra = 0;
										int differenzaMinuti =  minuti2 - minuti1;
										ora1 = parteOra1 + ":" + parteMinuti1;
										ora2 = parteOra2 + ":" + parteMinuti2;
										System.out.println("Orario 1 : " + ora1 + "\n" + "Orario 2 : " + ora2 + "\n" + "Differenza ore: " + differenzaOra + "\n" + "Differenza minuti: " + differenzaMinuti);
										 System.exit(0);
								}
								else if(orarioOre1 == orarioOre2 &&  minuti1 > minuti2 ){
										int differenzaOra = 23;
										int differenzaMinuti =  (60 - minuti1) + minuti2;
										ora1 = parteOra1 + ":" + parteMinuti1;
										ora2 = parteOra2 + ":" + parteMinuti2;
										System.out.println("Orario 1 : " + ora1 + "\n" + "Orario 2 : " + ora2 + "\n" + "Differenza ore: " + differenzaOra + "\n" + "Differenza minuti: " + differenzaMinuti);
										 System.exit(0);
								}
							}
					}
				}	
		}
	}
}
