package oop1;

public class Exercise6_21 {
	static int abs(int value) {
		int absNum = Math.abs(value);		
		return absNum;
	}
	public static void main(String[] args) {
		int value = 5;
		System.out.println(value + "의 절댓값 : " + abs(value));
		value = -10;
		System.out.println(value + "의 절댓값 : " + abs(value));
	}
}
