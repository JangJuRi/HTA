package control;

import java.util.Scanner;

public class Lotto2 {
	public static void main(String[] args) {
		/*
		 * 금액을 입력받는다.
		 * 금액은 1000원 단위의 값만 입력받는다.
		 * 로또번호를 입력된 금액만큼 발행한다.
		 * 1000원당 1세트씩 발행한다.
		 */
		int count;
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("금액을 입력해주세요 (1000원 단위)");
		int money = scanner.nextInt();
	
		count = (money / 1000) * 6;
		
		for(int i=1; i<=count; i++) {
			int number = (int) (Math.random()*45+1);
			System.out.print(number + "\t");
			if(i % 6 == 0) {
				System.out.println("");
			}
		}
	}
}
