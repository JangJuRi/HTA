package array;

import java.util.Scanner;

public class ArrayDemo11 {
	public static void main(String[] args) {
		/*
		 * 숫자 5개를 입력받아서 배열에 저장한다.
		 * 배열의 n번째까지의 합계를 새로운 배열에 저장하고, 새 배열의 값을 전부 출력한다.
		 * 예) [3,5,11,7,4] --> [3,8,19,26,30]
		 */
		
		Scanner scanner = new Scanner(System.in);
		
		int[] numbers = new int[5];
		int[] total = new int[5];
		
		for(int i=0; i<numbers.length; i++) {
			System.out.print(i+1 + "번째 숫자를 입력해주세요 : ");
			numbers[i] = scanner.nextInt();
		}
		
		for(int i=0; i<numbers.length; i++) {
			for(int j=0; j<=i; j++) {
				total[i] += numbers[j];
			}
			System.out.print(total[i] + " ");
		}
	}
}
