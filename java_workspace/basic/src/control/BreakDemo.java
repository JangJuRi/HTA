package control;

import java.util.Scanner;

public class BreakDemo {
	public static void main(String[] args) {
		//break
		//반복문을 탈출한다. for문, while문 안에서 사용된다.
		
		//내가 입력한 주사위 숫자와 동일한 숫자가 나오면 탈출
		
		Scanner scanner = new Scanner(System.in);
		for(;;) {
			System.out.print("숫자를 입력하세요 : ");
			int mynumber = scanner.nextInt();
			int randomNumber = (int) (Math.random()*6+1);
			
			System.out.println("[" + mynumber + ", " + randomNumber + "]");
			
			if(mynumber == randomNumber) {
				System.out.println("정답입니다!");
				break;
			}
		}
	}
}
