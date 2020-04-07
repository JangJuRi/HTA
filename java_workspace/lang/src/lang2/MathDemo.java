package lang2;

import static java.lang.Math.round;
import static java.lang.Math.rint;
import static java.lang.Math.floor;
import static java.lang.Math.ceil;

public class MathDemo {

	public static void main(String[] args) {
		
		
		System.out.println(round(-1.2) + "," + round(-1.9) + "," + round(1.2) + "," + round(1.8));
		System.out.println(rint(-1.2) + "," + rint(-1.9) + "," + rint(1.2) + "," + rint(1.8));
		System.out.println(floor(-1.2) + "," + floor(-1.9) + "," + floor(1.2) + "," + floor(1.8));
		System.out.println(ceil(-1.2) + "," + ceil(-1.9) + "," + ceil(1.2) + "," + ceil(1.8));
	}
}
