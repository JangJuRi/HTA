package control;

import java.util.Scanner;

public class WhileDemo3 {
	public static void main(String[] args) {
		//1~100까지 임의의 정수를 하나 생성한다.
		//사용자가 숫자를 입력하면 정수와 비교해서 up/down을 표시한다.
		//사용자가 입력한 숫자와 임의의 정수가 일치하면 몇번만에 맞혔는지 화면에 표시한다.
		
		Scanner scanner = new Scanner(System.in);
		int randomNum = (int) (Math.random()*100+1);
		int userNum;
		int count = 0;
		
		while(true) {		
			System.out.print("숫자를 입력하세요 : ");
			userNum = scanner.nextInt();
			
			if(userNum > randomNum) {
				System.out.println("더 작은 수를 입력하세요\n");
				count++;
			} else if(userNum < randomNum) {
				System.out.println("더 큰 수를 입력하세요\n");
				count++;
			} else {
				System.out.println("====== 정답입니다! ======");
				count++;
				break;
			}
		}
		System.out.println("총 " + count +"번 만에 정답을 맞혔습니다!");
		
	}
}
