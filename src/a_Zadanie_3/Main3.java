package a_Zadanie_3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main3 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		guess(scan);
		scan.close();

	}

	static void guess(Scanner scan) {

		int min = 0, max = 1000;

		int tries = 0;

		while (true) {
			int guess = ((max - min) / 2) + min;
			System.out.println("Zgaduję: " + guess);
			int usersAnswer = didHeGuess(scan);
			if (usersAnswer == 1) {
				System.out.println("Za mało!");
				min = guess;
				tries++;
			} else if (usersAnswer == 2) {
				System.out.println("Za dużo!");
				max = guess;
				tries++;
			} else if (usersAnswer == 3) {
				System.out.println("Wygrałem!");
				tries++;
				break;
			}
		}
		System.out.println("Zadłem w " + tries + " próbach :)");
	}

	static int didHeGuess(Scanner scan) {
		System.out.println("Wpisz do konsoli: ");
		System.out.println("1 aby powiedzieć \"Za mało!\", 2 aby powiedzieć \"Za dużo!\" oraz 3 dla \"Zgadłeś!\"");

		int n0 = 0;

		while (true) {
			try {
				int n = scan.nextInt();
				if (n <= 3 && n > 0) {
					n0 = n;
					break;
				} else {
					System.out.println("Wprowadź poprawną wartość.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Wprowadzona wartość musi być liczbą.");
				scan.nextLine();
			}
		}
		return n0;
	}
}
