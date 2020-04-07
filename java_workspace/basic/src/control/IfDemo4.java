package control;

import java.util.Scanner;

public class IfDemo4 {
	public static void main(String[] args) {		
		/*
		 * 고객의 등급(일반, 로얄, 플래티넘 중 하나) 과 총구매금액을 입력받는다.
		 * 고객의 등급이 플래티넘인 경우 구매금액의 10%를 할인한다.
		 * 			로얄인 경우 구매금액의 3%를 할인한다.
		 * 			일반인 경우 구매금액의 1%를 할인한다.
		 * 결제금액은 총구매금액에서 할인된 금액만큼을 차감한 금액이다.
		 * 적립포인트는 결제금액의 3%를 적립한다.
		 * 
		 * 출력내용은
		 * 총구매금액, 고객 등급, 할인된 금액, 결제할 금액, 적립 포인트
		 */
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("고객 등급을 입력하세요(일반, 로얄, 플래티넘 중 하나) : ");
		String grade = scanner.next();
		System.out.print("총 구매금액을 입력하세요 : ");
		int totalPrice = scanner.nextInt();
		
		int salePrice;
		if(grade.equals("플래티넘")) {
			salePrice = (int) (totalPrice * 0.1);
		} else if(grade.equals("로얄")) {
			salePrice = (int) (totalPrice * 0.03);
		} else {
			salePrice = (int) (totalPrice * 0.01);
		}
		
		int payPrice = totalPrice - salePrice;
		
		int point = (int) (payPrice * 0.03);
		
		System.out.println("\n총 구매금액\t고객 등급\t할인된 금액\t결제할 금액\t적립 포인트");
		System.out.println(totalPrice +"\t"+ grade +"\t"+ salePrice +"\t"+ payPrice + "\t"+ point);
	}
}
