package a_Zadanie_4;

import java.util.Random;

public class KostkaDoGry {

	public static void main(String[] args) {

		String cube = "2D6-2";
		System.out.println(cubeRecon(cube));

	}

	public static int cubeRecon(String cube) {

		String[] cubeToArrFirstStage = cube.split("D");
		String[] cubeToArrPlus = cubeToArrFirstStage[1].split("\\+");
		String[] cubeToArrMinus = cubeToArrFirstStage[1].split("-");
		Random r = new Random();
		int result = 0;

		if (cubeToArrPlus.length == 1 && cubeToArrMinus.length == 1) {
			if (cubeToArrFirstStage[0].equals("")) {
				int y = Integer.parseInt(cubeToArrPlus[0]);
				int roll = r.nextInt(y) + 1;
				result = roll;
			} else {
				int x = Integer.parseInt(cubeToArrFirstStage[0]);
				int y = Integer.parseInt(cubeToArrFirstStage[1]);

				for (int i = 0; i < x; i++) {
					int roll = r.nextInt(y) + 1;
					result += roll;
				}
			}
		} else {
			int z = 0;
			int y = 0;
			if (cubeToArrPlus.length != 1) {
				z = Integer.parseInt(cubeToArrPlus[1]);
			} else {
				z = -Integer.parseInt(cubeToArrMinus[1]);
			}

			if (cubeToArrFirstStage[0].equals("")) {
				if (z > 0) {
					y = Integer.parseInt(cubeToArrPlus[0]);
				} else {
					y = Integer.parseInt(cubeToArrMinus[0]);
				}
				int roll = r.nextInt(y) + 1;

				result = roll + z;

			} else {
				int x = Integer.parseInt(cubeToArrFirstStage[0]);
				if (z > 0) {
					y = Integer.parseInt(cubeToArrPlus[0]);
				} else {
					y = Integer.parseInt(cubeToArrMinus[0]);
				}
				System.out.println("[" + x + ", " + y + ", " + z + "]");

				for (int i = 0; i < x; i++) {
					int roll = r.nextInt(y) + 1;
					result += roll;
				}
				result = result + z;

			}

		}

		return result;
	}
}
