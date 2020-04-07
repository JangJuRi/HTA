package oop1;

import java.util.Scanner;

public class OrderDemo1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Order[] orders = new Order[100];
		int savePosition = 0;
		
		while(true) {
			int count = -1;
			
			System.out.println();
			System.out.println("=====================================");
			System.out.println("1. 조회   2. 검색   3. 입력   0. 종료");
			System.out.println("=====================================");
			
			System.out.print("번호를 입력하세요 : ");
			int menuNo = scanner.nextInt();
			
			if(menuNo == 1) {
				System.out.println("고객명\t고객등급\t총구매금액\t적립포인트\t사은품");
				System.out.println("=====================================================");
				
				for(int i=0; i<savePosition; i++) {
					Order order = orders[i];
					
					System.out.print(order.name + "\t");
					System.out.print(order.grade + "\t");
					System.out.print(order.price + "\t\t");
					System.out.print(order.point + "\t\t");
					System.out.println(order.gift);
				}
				System.out.println("\n\n");
				
			} else if (menuNo == 2) {
				System.out.print("검색조건을 입력하세요(N:이름, G:사은품) : ");		
				String searchKey = scanner.next();
				Order[] foundOrder = new Order[100];
				
				if(searchKey.equals("N") || searchKey.equals("n")) {
					System.out.print("고객명을 입력하세요 : ");
					String name = scanner.next();
					for(int i=0; i<savePosition; i++) {
						Order order = orders[i];
						
						if(name.equals(order.name)) {
							count++;
							foundOrder[count] = order;
						}
					}
				} else if (searchKey.equals("G") || searchKey.equals("g")) {
					System.out.print("사은품을 입력하세요 : ");
					String name = scanner.next();
					for(int i=0; i<savePosition; i++) {
						Order order = orders[i];
						
						if(name.equals(order.gift)) {
							count++;
							foundOrder[count] = order;
						}
					}
				}
				
				
				if(count != -1) {
					for(int i=0; i<=count; i++) {
						System.out.println("------["+ (i+1) + "]번째 검색 결과 ------");
						System.out.println("고객명 : " + foundOrder[i].name);
						System.out.println("고객등급 : " + foundOrder[i].grade);
						System.out.println("총구매금액 : " + foundOrder[i].price);
						System.out.println("적립포인트 : " + foundOrder[i].point);
						System.out.println("사은품 : " + foundOrder[i].gift);
						System.out.println("------------------------");
					}
					
				} else {
					System.out.println("고객정보를 찾을 수 없습니다.");
				}
				
			} else if (menuNo == 3) {
				System.out.print("고객명을 입력하세요 : ");
				String name = scanner.next();
				System.out.print("고객등급을 입력하세요 : ");
				String grade = scanner.next();
				System.out.print("총구매금액을 입력하세요 : ");
				int price = scanner.nextInt();
				
				int point = 0; 
				String gift;
				
				if (grade.equals("프리미어")) {
					point = (int) (price * 0.05);
				} else if (grade.equals("에이스")) {
					point = (int) (price * 0.03);
				} else if (grade.equals("베스트")) {
					point = (int) (price * 0.02);
				} else if (grade.equals("클래식")) {
					point = (int) (price * 0.01);
				}
				
				if (price >= 5000000) {
					gift = "숙박권";
				} else if (price >= 1000000) {
					gift = "상품권";
				} else if (price >= 500000) {
					gift = "할인권";
				} else {
					gift = "주차권";
				}
				
				
				Order order = new Order();
				order.name = name;
				order.grade = grade;
				order.price = price;
				order.point = point;
				order.gift = gift;
				
				orders[savePosition] = order;
				savePosition++;
				
			} else if (menuNo == 0) {
				System.out.println("프로그램을 종료합니다.");
				break;	
			}
		}
	}
}