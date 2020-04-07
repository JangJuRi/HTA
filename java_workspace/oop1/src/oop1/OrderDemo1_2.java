package oop1;

import java.util.Scanner;

public class OrderDemo1_2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Order[] orders = new Order[100];
		int savePosition = 0;
		
		while(true) {
			
			System.out.println();
			System.out.println("=====================================");
			System.out.println("1. 조회   2. 검색   3. 입력   0. 종료");
			System.out.println("=====================================");
			
			System.out.print("번호를 입력하세요 : ");
			int menuNo = scanner.nextInt();
			
			if(menuNo == 1) {
				System.out.println("[고객 주문내용 조회]");
				if(savePosition == 0) {
					System.out.println("고객 주문내용이 존재하지 않습니다.");
				} else  {
					System.out.println("고객명\t고객등급\t총구매금액\t적립포인트\t사은품");
					System.out.println("========================================================");
					
					for(int i=0; i<savePosition; i++) {
						Order order = orders[i];
						System.out.print(order.name + "\t");
						System.out.print(order.grade + "\t");
						System.out.print(order.price + "\t\t");
						System.out.print(order.point + "\t\t");
						System.out.println(order.gift);
					}
					System.out.println("\n\n");
					
					
				}
			} else if (menuNo == 2) {
				System.out.println("[고객 주문내용 검색]");
				
				System.out.print("검색조건을 입력하세요 (N:이름,  G:사은품) : ");
				String option = scanner.next();
				System.out.print("검색 내용을 입력하세요 : ");
				String text = scanner.next();
				
				System.out.println("고객명\t고객등급\t총구매금액\t적립포인트\t사은품");
				System.out.println("========================================================");
				
				for(int i=0; i<savePosition; i++) {
					Order order = orders[i];
					
					boolean isFound = false;
					if(option.equals("N") && text.equals(order.name)) {
						isFound = true;
					} else if(option.equals("G") && text.equals(order.gift)) {
						isFound = true;
					}
					
					if(isFound) {
						System.out.print(order.name + "\t");
						System.out.print(order.grade + "\t");
						System.out.print(order.price + "\t\t");
						System.out.print(order.point + "\t\t");
						System.out.println(order.gift);
					}
				}
					
			} else if(menuNo == 3) {
				System.out.println("[고객 주문내용 입력]");
				
				System.out.print("이름을 입력하세요 : ");
				String name = scanner.next();
				System.out.print("등급을 입력하세요 : ");
				String grade = scanner.next();
				System.out.print("총구매금액을 입력하세요 : ");
				int price = scanner.nextInt();
				
				Order order = new Order();
				order.name = name;
				order.grade = grade;
				order.price = price;
				
				if(order.grade.equals("프리미어")) {
					order.point = (int)(order.price * 0.05);
				}else if(order.grade.equals("에이스")) {
					order.point = (int)(order.price * 0.03);
				}else if(order.grade.equals("베스트")) {
					order.point = (int)(order.price * 0.02);
				}else if(order.grade.equals("클래식")) {
					order.point = (int)(order.price * 0.01);
				}
				
				if (order.price >= 5000000) {
					order.gift = "숙박권";
				} else if (order.price >= 1000000) {
					order.gift = "상품권";
				} else if (order.price >= 500000) {
					order.gift = "할인권";
				} else {
					order.gift = "주차권";
				}
				
				orders[savePosition] = order;
				savePosition++;
				
			} else if(menuNo == 0) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
		scanner.close();
	}
}
