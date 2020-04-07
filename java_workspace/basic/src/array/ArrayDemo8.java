package array;

import java.util.Scanner;

public class ArrayDemo8 {
	public static void main(String[] args) {
		/*
		 * 5개의 정수를 입력받아서 그 중에 가장 큰 값을 출력하시오
		 */
		
		Scanner scanner = new Scanner(System.in);
		
		int number[] = new int[5];
		
		for(int i=0; i<number.length; i++) {
			System.out.print(i+1 +"번째 숫자를 입력해주세요 : ");
			number[i] = scanner.nextInt();
		}
		
		int max = 0;
		for(int n : number) {
			if(n > max) {
				max = n;
			}
		}
		
		System.out.println("가장 큰 수는 " + max + "입니다.");
	}
}
