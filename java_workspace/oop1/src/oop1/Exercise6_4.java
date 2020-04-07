package oop1;

public class Exercise6_4 {
	static double getDistance(int x, int y, int x1, int y1) {
		
		return Math.sqrt((Math.pow((Math.abs(x1-x)), 2)) + (Math.pow((Math.abs(y1-y)), 2)));
	}
	
	public static void main(String[] args) {
		System.out.println(getDistance(1, 1, 2, 2));
	}
}
