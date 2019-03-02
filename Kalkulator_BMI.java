// Kalkulator_BMI
// @Adam Tomaszewski, Politechnika Koszalińska, Koszalin 2019

import java.io.*;

public class Kalkulator_BMI
{  
	public static void main(String[] args)
	{  
		// Pakiet strumienia wejścia
		BufferedReader odczyt = new BufferedReader(new InputStreamReader(System.in));
	
		
		// Istnieje ryzyko niepowodzenia wykonania operacji
		try {
			System.out.print("\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			System.out.print("\t\t KALKULATOR BMI!!\n");
			System.out.print("\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			System.out.print("Witaj! Podaj swoje imie: ");
			String imie = odczyt.readLine();
			System.out.print("Ile masz lat? ");
			String wiek = odczyt.readLine();
			System.out.print("Podaj swoja wage (kg): ");
			String waga = odczyt.readLine();
			System.out.print("Podaj swoj wzrost (cm): ");
			String wzrost = odczyt.readLine();
			System.out.print("Plec: 1-Kobieta, 2-Mezczyzna: ");
			String plec = odczyt.readLine();
			

			// Zamiana String na integer/float
			int age = Integer.parseInt(wiek);
			float height = Float.parseFloat(wzrost)/100;
			float weight = Float.parseFloat(waga);
			int male = Integer.parseInt(plec);
			
			// Wzór na obliczenie BMI 
			// Niezależnie od wieku i płci wzór jest ten sam
			float bmi = ( weight/(height*height) );
			
			/* W przypadku dzieci w wieku poniżej 18 lat 
			* BMI interpretujemy na podstawie siatek centylowych
			* ze względu na to, że wskaźnik masy ciała zmienia się ze wzrostem dziecka
			*/
			if (age <= 18) {
				System.out.println("Poza BMI sprawdz jeszcze siatke centylowa BMI! \n");
			}
			
			else if (age <0) {
				System.out.println("Niepoprawny wiek !");
				System.exit(0);
			}
			// Wyświetlenie użytkownikowi obliczonego BMI wraz z komentarzem
			System.out.println("\n\t" + imie + " Twoje BMI wynosi: " + bmi);
			
			
			/* Komentarze zależne od przedziału wartości BMI
			
			* Kobieta i mężczyzna o podobnym wzroście i wadze będą mieli zbliżone BMI,
			* ale z dużym prawdopodobieństwem można stwierdzić, że u kobiety tkanka tłuszczowa 
			* będzie stanowiła większy fragment masy ciała niż u mężczyzny.4*/
		if (male == 1 || male == 2) {
				if (bmi < 16.5) {
					System.out.println("\t JESTES NIEODZYWIONY! KONIECZNIE SKONSULTUJ SIE Z LEKARZEM !");
				}
				if (bmi >= 16.5 && bmi <18.5) {
					System.out.println("\tMasz niedowage! Musisz jesc wiecej !");
				}
				if (bmi >= 18.5 && bmi <25) {
					System.out.println("\tNormalna waga! Brawo! Tak trzymaj !");
				}
				if (bmi >= 25 && bmi <30) {
					System.out.println("\tMasz nadwage! Nie podjadaj wieczorami !");
				}
				if (bmi >= 30 && bmi <35) {
					System.out.println("\tMasz otylosc klasy I! Odstaw slodyczne i przestan jesc fastfoody !");
				}
				if (bmi >= 35 && bmi <40) {
					System.out.println("\tMasz otylosc klasy II (otylosc kliniczna)! Musisz przejsc na scisla diete !");
				}
				if (bmi >= 40) {
					System.out.println("\tMasz otylosc klasy III (otylosc SKRAJNA) !! KONIECZNIE SKONSULTUJ SIE Z LEKARZEM !");
				}
				
			} else {
				System.out.println("Niepoprawny wybor plci!");
				System.exit(0);
			}
			
		}
		catch (IOException e) {
			System.out.println("Input error!");
		}
	}
}