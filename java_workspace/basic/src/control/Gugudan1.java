package control;

import java.util.Scanner;

public class Gugudan1 {
	public static void main(String[] args) {
		// 숫자를 입력받아서 해당 숫자에 대한 구구단을 출력하기
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("출력하고 싶은 구구단의 범위를 입력하세요");
		System.out.print("구구단 처음 범위 입력 : ");
		int num1 = scanner.nextInt();
		System.out.print("구구단 마지막 범위 입력 : ");
		int num2 = scanner.nextInt();
		
		GuguScope(num1, num2);	
	}
	
	public static void Gugu(int num) {
		for(int i=1; i<=9; i++) {
			System.out.println(num + " x " + i + " = " + num*i);
		}
	}
	
	public static void GuguScope(int num1, int num2) {
		for(int i=num1; i<=num2; i++) {
			Gugu(i);
			System.out.println("");
		}
	}
}
