package array;

import java.util.Scanner;

public class ArrayDemo10 {
	public static void main(String[] args) {
		/*
		 * 숫자를 10개 입력받아서 인접한 두 수의 차이가 가장 많이 나는 숫자를 각각 출력하기
		 */
		
		Scanner scanner = new Scanner(System.in);
		
		int numbers[] = new int[10];
		int prev = 0;
		int next = 0;
		int gap = 0;
		
		for(int i=0; i<numbers.length; i++) {
			System.out.print(i+1 + "번째 숫자를 입력해주세요 : ");
			numbers[i] = scanner.nextInt();
		}
		
		for(int i=0; i<numbers.length-1; i++) {
				if(Math.abs(numbers[i+1] - numbers[i]) > gap) {
					prev = numbers[i];
					next = numbers[i+1];
					gap = Math.abs(next-prev);
				}
		}
		System.out.println(prev + "와 " + next +"의 차이가 " + gap + "으로 가장 차이가 큰 수들 입니다.");
	}
}
