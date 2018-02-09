package a_Zadanie_1;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class ZgadywanieLiczb {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		compareNumbers(scan);
		scan.close();

	}

	static void compareNumbers(Scanner scan) {
		int allotedNumber = allotNumber();
		while (true) {
			try {
				int usersNumber = getNumber(scan);
				if (usersNumber > allotedNumber) {
					System.out.println("Za dużo!");
				} else if (usersNumber < allotedNumber) {
					System.out.println("Za mało!");
				} else {
					System.out.println("Zgadłeś!");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("To nie jest liczba!");
				scan.nextLine();
			}
		}
	}

	static int allotNumber() {
		Random r = new Random();
		int n = r.nextInt(101);
		return n;
	}

	static int getNumber(Scanner scan) {
		System.out.print("Podaj liczbę: ");
		int usersNumber = scan.nextInt();
		return usersNumber;
	}
}
