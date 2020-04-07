package control;

import java.util.Scanner;

public class WhileDemo1 {
	public static void main(String[] args) {
		/*
		 * while(조건식) {
		 * 		조건식이 true로 판정될 동안 실행되는 수행문;
		 * }
		 */
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.print("숫자를 입력하세요 (0을 입력하면 반복을 종료함) : ");
			int number = scanner.nextInt();
			
			//무한반복 탈출 조건
			if(number == 0) {
				System.out.print("종료합니다");
				break;
			}
		}
	}
}
