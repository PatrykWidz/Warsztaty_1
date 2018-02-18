package a_Zadanie_4;

import java.util.Random;

public class Cube {

	private int x = 1;
	private int y = 1;
	private int z = 0;

	public Cube(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Cube() {

	}

	public int calculateRoll() {
		Random r = new Random();
		int result = 0;

		for (int i = 0; i < this.x; i++) {
			int roll = r.nextInt(this.y) + 1;
			result += roll;
		}
		result = result + this.z;
		return result;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setZ(int z) {
		this.z = z;
	}
}
