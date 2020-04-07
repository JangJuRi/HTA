package control;


import java.util.Scanner;

public class WhileDemo4 {
	public static void main(String[] args) {
		// 10000 ~ 99999 사이의 임의의 정수를 입력하세요.
		// 예) 입력값 : 12132  ---> 출력값 : 1+2+1+3+2 --> 9
		
		Scanner scanner = new Scanner(System.in);
		
		int sum = 0;
		
		System.out.print("10000 ~ 99999 사이의 임의의 정수를 입력하세요.");
		int number = scanner.nextInt();
		
		while(number != 0) {
			sum += number % 10;
			number /= 10;
		}
		System.out.println("합계는 " + sum + "입니다.");
	}
}
