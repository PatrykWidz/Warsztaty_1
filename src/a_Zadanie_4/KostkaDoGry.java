package a_Zadanie_4;


import java.util.Random;

public class KostkaDoGry {

	public static void main(String[] args) {

		// xDy+z
		// x - liczba rzutów, jeśli rzut jest jeden, x jest pominięty
		// y - rodzaj kostek, np. D6, D10 itd.
		// z - liczba którą należy dodać(lub odjąć) do wyniku rzutów (opcjonalnie).


		String cube = "3D3";
		System.out.println(cubeRecon(cube));

	}

	// TODO rozbić poprzez split, metodyka dobra, ale nie zawsze będzie działać

	public static int cubeRecon(String cube) {

		String[] cubeToArrFirstStage = cube.split("D");
		String[] cubeToArrPlus = cubeToArrFirstStage[1].split("\\+");
		String[] cubeToArrMinus = cubeToArrFirstStage[1].split("\\+");
		Random r = new Random();
		int result = 0;

		if (cubeToArrPlus.length == 1 && cubeToArrMinus.length == 1) {
			if (cubeToArrFirstStage[0].equals("")) {
				int y = Integer.parseInt(cubeToArrPlus[0]);
				int roll = r.nextInt(y) + 1;
				result = roll;
			} else {
				int x = Integer.parseInt(cubeToArrFirstStage[0]);
				int y = Integer.parseInt(cubeToArrPlus[0]);

				for (int i = 0; i < x; i++) {
					int roll = r.nextInt(y) + 1;
					result += roll;
				}
			}
		} else {
			if (cubeToArrFirstStage[0].equals("")) {
				int y = Integer.parseInt(cubeToArrPlus[0]);
				int z = Integer.parseInt(cubeToArrPlus[1]);
				int roll = r.nextInt(y) + 1;
				if (cubeToArrPlus.length != 1) {
					result = roll + z;
				} else {
					result = roll - z;
				}
			} else {
				int x = Integer.parseInt(cubeToArrFirstStage[0]);
				int y = Integer.parseInt(cubeToArrPlus[0]);
				int z = Integer.parseInt(cubeToArrPlus[1]);
				System.out.println("[" + x + ", " + y + ", " + z + "]");
				
				
				for (int i = 0; i < x; i++) {
					int roll = r.nextInt(y) + 1;
					result += roll;
				}
				if (cubeToArrPlus.length != 1) {
					result = result + z;
				} else {
					result = result - z;
				}
			}
		}

		return result;
	}
}
