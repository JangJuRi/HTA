package control;

import java.util.Scanner;

public class Exercise4_10 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int answer = (int) ((Math.random()*100)+1);
		int input = 0;
		int count = 0;
		
		do {
			count++;
			System.out.print("1과 100사이의 값을 입력하세요 : ");
			input = scanner.nextInt();
			
			if(input > answer) {
				System.out.println("더 작은 수를 입력하세요.");
			} else if(input < answer) {
				System.out.println("더 큰 수를 입력하세요.");
			} else {
				System.out.println("맞혔습니다.\n시도 횟수는 "+count+"번 입니다.");
				break;
			}
		} while(true);
	}
}
