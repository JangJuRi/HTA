package array;

import java.util.Scanner;

public class ArrayDemo7 {
	public static void main(String[] args) {
		/* 숫자를 5개 입력받아서 입력받은 숫자의 총합을 계산하기 */
		
		Scanner scanner = new Scanner(System.in);
		int number[] = new int[5];
		int total = 0;
		
		for(int i=0; i<number.length; i++) {
			System.out.print(i+1 + "번째 숫자를 입력하세요 : ");
			number[i] = scanner.nextInt();
		}
		for(int n : number) {
			total += n;
		}
		System.out.println("총합은 " + total + "입니다.");
	}
}
