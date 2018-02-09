package a_Zadanie_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class SymulatorLOTTO {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		List<Integer> usersNumbers = typowanieLotto(scan);
		scan.close();
		List<Integer> allotation = losowanieLotto();

		didYouWin(usersNumbers, allotation);

	}

	// metoda typowania liczb przez użytkownika
	static List<Integer> typowanieLotto(Scanner scan) {

		List<Integer> typy = new ArrayList<>();
		System.out.println("Podaj kolejno sześć wytypowanych przez Ciebie liczb: ");

		while (typy.size() < 6) {
			try {
				int n = scan.nextInt();
				if (n < 1 || n > 49) {
					System.out.println("Podaj liczbę z zakresu 1-49.");
				} else if ((n >= 1 || n <= 49) && typy.size() == 0) {
					typy.add(n);
				} else {
					checkIfExists(typy, n);
				}
			} catch (InputMismatchException e) {
				System.out.println("To nie jest liczba!");
				scan.nextLine();
			}
		}
		Collections.sort(typy);
		System.out.println("Wytypowane przez Ciebie liczby to: " + Arrays.toString(typy.toArray()));
		return typy;
	}

	// metoda sprawdzająca czy wprowadzany element 'n' nie powtarza się już w liście
	// 'list'
	// jeżeli element się powtarza, nie jest on dodawany do listy
	static void checkIfExists(List<Integer> list, int n) {
		boolean czyJuzJest = false;
		for (int i = 0; i < list.size(); i++) {
			if (n == list.get(i)) {
				czyJuzJest = true;
				System.out.println("Tą liczbę podałeś już wcześniej!");
			}
		}
		if (czyJuzJest == false) {
			list.add(n);
		}
	}

	// metoda losująca liczby jak lotto
	static List<Integer> losowanieLotto() {
		List<Integer> list = new ArrayList<>();
		List<Integer> wynikLosowania = new ArrayList<>();

		for (int i = 0; i < 49; i++) {
			list.add(i + 1);
		}

		Collections.shuffle(list);
		wynikLosowania = list.subList(0, 6);
		Collections.sort(wynikLosowania);
		System.out.println("Wynik losowania lotto to: " + Arrays.toString(wynikLosowania.toArray()));
		return wynikLosowania;
	}

	// metoda sprawdzająca wynik losowania
	static void didYouWin(List<Integer> usersNumbers, List<Integer> allotation) {
		int score = 0;
		for (int i = 0; i < usersNumbers.size(); i++) {
			for (int j = 0; j < allotation.size(); j++) {
				if (usersNumbers.get(i) == allotation.get(j)) {
					score++;
				}
			}
		}
		if (score < 3) {
			System.out.println("Przykro mi. Pieniędzy z tego nie będzie.");
		} else if (score == 3) {
			System.out.println("Gratulacje, trafiłeś trójkę!");
		} else if (score == 4) {
			System.out.println("Gratulacje, trafiłeś czwórkę!");
		} else if (score == 5) {
			System.out.println("Nieźle, trafiłeś piątkę!");
		} else {
			System.out.println("Szóstka! Już nie musisz zostawać programistą!");
		}
	}
}