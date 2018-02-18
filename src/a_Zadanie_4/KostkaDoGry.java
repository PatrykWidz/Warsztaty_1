package a_Zadanie_4;

import java.util.Arrays;

public class KostkaDoGry {

	public static void main(String[] args) {

		String cubeDesc = "3D6-5";
		int[] parameters = getCubeParameters(cubeDesc);
		System.out.println(Arrays.toString(parameters));
		Cube cube = new Cube(parameters[0], parameters[1], parameters[2]);
		System.out.println(cube.calculateRoll());

	}

	public static int[] getCubeParameters(String cube) {
		String[] cubeToArrFirstStage = cube.split("D");
		String[] cubeToArrPlus = cubeToArrFirstStage[1].split("\\+");
		String[] cubeToArrMinus = cubeToArrFirstStage[1].split("\\-");

		int x = 1;
		int y = 1;
		int z = 0;

		if (!cubeToArrFirstStage[0].equals("")) {
			x = Integer.parseInt(cubeToArrFirstStage[0]);
		}

		if (cubeToArrPlus.length != 1) {
			y = Integer.parseInt(cubeToArrPlus[0]);
			z = Integer.parseInt(cubeToArrPlus[1]);
		}

		if (cubeToArrMinus.length != 1) {
			y = Integer.parseInt(cubeToArrMinus[0]);
			z = -Integer.parseInt(cubeToArrMinus[1]);
		}

		if (cubeToArrPlus.length == 1 && cubeToArrMinus.length == 1) {
			y = Integer.parseInt(cubeToArrFirstStage[1]);
		}

		int[] result = { x, y, z };
		return result;
	}
}
